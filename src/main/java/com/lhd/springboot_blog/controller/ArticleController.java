package com.lhd.springboot_blog.controller;

import cn.hutool.http.HtmlUtil;
import com.lhd.springboot_blog.entity.*;
import com.github.pagehelper.PageInfo;
import com.lhd.springboot_blog.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller @RequestMapping("/article")
@Slf4j
public class ArticleController {
	@Resource
	ArticleService articleService;
	@Resource
	CategoryService categoryService;
	@Resource
	TagService tagService;
	@Resource
	CommentService commentService;
	@Resource
	NoticeService noticeService;
	@Resource
	LinkService linkService;
	@Resource
	UserService userService;
	@Value("${img_file}")
	private String img_file;
	@Value(("${img_url}"))
	private String img_url;
	@RequestMapping("")
	public String index(
			@RequestParam(required = false,defaultValue="1")  Integer pageIndex,
			@RequestParam(required = false,defaultValue="10") Integer pageSize,ModelMap m) {


		PageInfo<Article> pageInfo= articleService.getPageArticleList(pageIndex,pageSize);

		m.put("pageInfo", pageInfo);

		m.put("pageUrlPrefix","article?pageIndex");

		return "Article/article-list";
	}
	@RequestMapping(value="/insert", method=RequestMethod.GET)   //GET 请求走这个方法
	public String gotoAddPage(ModelMap m){
		//查询分类信息
		List<Category> categoryList=categoryService.listCategory();

		//查询标签信息
		List<Tag> tagList=tagService.listTag();

		//带过去
		m.put("categoryList", categoryList);
		m.put("tagList", tagList);

		//转向
		return "Article/article-add";
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)  //POST 请求走这个方法
	public String add(ModelMap m,HttpServletRequest request){
		Article article=new Article();

		//取当前用户的id
		User user=(User)request.getSession().getAttribute("session_user");
		if(user!=null) {
			article.setArticleUserId(user.getUserId());
		}

		//文章标题
		article.setArticleTitle(request.getParameter("articleTitle"));

		//文章内容
		article.setArticleContent(request.getParameter("articleContent"));

		//文章的状态
		article.setArticleStatus(Integer.parseInt(request.getParameter("articleStatus")));

		//文章摘要
		String str=HtmlUtil.cleanHtmlTag(article.getArticleContent());
		article.setArticleSummary(str.length()>150?str.substring(0,150):str);

		//文章的发布时间
		article.setArticleCreateTime(new Date());

		//文章的最后更新时间
		article.setArticleUpdateTime(new Date());

		//把几个参数置成初始值 0
		article.setArticleViewCount(0);
		article.setArticleLikeCount(0);
		article.setArticleCommentCount(0);
		article.setArticleIsComment(1);

		//文章排序
		article.setArticleOrder(1);

		//一级分类的id
		int  parentCateId=Integer.parseInt(request.getParameter("articleParentCategoryId"));

		//二级分类的id
		int childCateId=Integer.parseInt(request.getParameter("articleChildCategoryId"));

		//把上面的两个分类装到list中
		List<Category> categoryList=new ArrayList<>(2);
		categoryList.add(new Category(parentCateId));
		categoryList.add(new Category(childCateId));

		//标签列表


		List<Tag> tagList=new ArrayList<>();
		if(request.getParameterValues("articleTagIds")!=null){
		//把上面的标签放到list
			String [] tagIds =request.getParameterValues("articleTagIds");
		for(String tagId:tagIds) {
			tagList.add(new Tag(Integer.parseInt(tagId)));
		}}

		//把分类和标签信息都添到article中
		article.setCategoryList(categoryList);
		article.setTagList(tagList);

		//添加文章
		articleService.addArticle(article);

		//将请求转发到查询所有文章
		return "forward:/article";
	}
	@RequestMapping(value="/insertc", method=RequestMethod.POST)  //POST 请求走这个方法
	public String addc(ModelMap m,HttpServletRequest request){
		Article article=new Article();

		//取当前用户的id
		User user=(User)request.getSession().getAttribute("session_user");
		if(user!=null) {
			article.setArticleUserId(user.getUserId());
		}

		//文章标题
		article.setArticleTitle(request.getParameter("articleTitle"));

		//文章内容
		article.setArticleContent(request.getParameter("articleContent"));

		//文章的状态
		article.setArticleStatus(Integer.parseInt(request.getParameter("articleStatus")));
		//文章的最后更新时间
		article.setArticleCreateTime(new Date());


		//添加文章
		articleService.addArticlec(article);

		//将请求转发到查询所有文章
		return "forward:/article";
	}
	@RequestMapping("/uploadimg")  @ResponseBody
	public String uploadFile(MultipartHttpServletRequest request) throws Exception {

		//imgFile这个名称就是这么写的
		MultipartFile file =request.getFile("imgFile");

		//生成一个随机的文件名
		String newName=UUID.randomUUID().toString();
		File destFile =new File(img_file+newName+".jpg");

		file.transferTo(destFile);

		String path=img_url+newName+".jpg";



		return "{\"error\":0,\"url\":\""+path+"\"}";
	}
	@RequestMapping("/Comment")
	public String Comment(ModelMap m) {
		List<Comment> comments=new ArrayList<Comment>();

		comments=commentService.listComment();
		for(int i=0;i<comments.size();i++)
		{comments.get(i).setArticle(articleService.getArticleById(comments.get(i).getCommentArticleId()));}
		System.out.println(comments);
		m.put("commentList", comments);
		return "Comment/Comment";
	}
	/**
	 * 删除文章
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteArticle/{id}")
	public String deleteAdmin(@PathVariable("id") Integer id) {
		articleService.deleteById(id);
		return "redirect:/article";
	}
	/**
	 * 修改文章
	 * @param id
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id,ModelMap m) {
		Article a=articleService.getArticleById(id);
		m.put("article",a);
		m.put("article_id", a.getArticleId());
		//转向
		return "Article/edit";
	}
	/**
	 * update
	 * @param m
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)  //POST 请求走这个方法
	public String update(@PathVariable("id") Integer id,ModelMap m,HttpServletRequest request){
		Article article=new Article();

		//取当前用户的id
		User user=(User)request.getSession().getAttribute("session_user");
		if(user!=null) {
			article.setArticleUserId(user.getUserId());
		}
		article.setArticleId(id);
		//文章标题
		article.setArticleTitle(request.getParameter("articleTitle"));

		//文章内容
		article.setArticleContent(request.getParameter("articleContent"));

		//文章的状态
		article.setArticleStatus(Integer.parseInt(request.getParameter("articleStatus")));

		//文章摘要
		String str=HtmlUtil.cleanHtmlTag(article.getArticleContent());
		article.setArticleSummary(str.length()>150?str.substring(0,150):str);

		//文章的最后更新时间
		article.setArticleUpdateTime(new Date());


		//修改文章
		articleService.updateArticle(article);

		//将请求转发到查询所有文章
		return "forward:/article";
	}
	@RequestMapping(value="/show/{id}")
	public String show(@PathVariable("id") Integer id,ModelMap m) {
		articleService.addViewContent(id);
		Article a=articleService.getArticleById(id);
		User user=userService.getUserById(a.getArticleUserId());
		a.setUser(user);
		List<Article> hot=articleService.getArticleByView();
		List<Category> categoryList=categoryService.listCategoryByArticleId(a.getArticleId());
		a.setCategoryList(categoryList);
		List<Tag> tagList=tagService.listTagByArticleId(a.getArticleId());
		a.setTagList(tagList);
		m.put("hotList",hot);
		m.put("article", a);

		return "view/Page/articleDetail";
	}
	@RequestMapping("/blog")
	public String index1(
			@RequestParam(required = false,defaultValue="1")  Integer pageIndex,
			@RequestParam(required = false,defaultValue="10") Integer pageSize,ModelMap m) {

		int siteBasicStatistics[]=new int[5];
		siteBasicStatistics[0]=articleService.getArticleNumber();
		siteBasicStatistics[1]=articleService.getCommentNumber();
		siteBasicStatistics[2]=categoryService.getCount();
		siteBasicStatistics[3]=tagService.getCount();
		siteBasicStatistics[4]=articleService.getArticleSum();
		List<Tag> tagList=new ArrayList<Tag>();
		List<Category> categoryList=new ArrayList<Category>();
		tagList=tagService.listTag();

		categoryList=categoryService.listCategory();

		PageInfo<Article> pageInfo= articleService.getPageArticleList(pageIndex,pageSize);
		List<Article> hot=articleService.getArticleByView();
		m.put("hotList",hot);
		List<Notice> notices=new ArrayList<Notice>();

		notices=noticeService.listNotice();
		m.put("siteBasicStatistics",siteBasicStatistics);
		m.put("pageInfo", pageInfo);

		m.put("noticeList",notices);

		m.put("pageUrlPrefix","?pageIndex");
		m.put("tagList",tagList);
		m.put("categoryList1",categoryList);
		return "view/index";
	}
	/**
	 * 查找标签下文章
	 * @param name
	 * @param m
	 * @return
	 */

	@RequestMapping("/findTag/{name}")
	public String find(@PathVariable("name") String name,@RequestParam(required = false,defaultValue="1")  Integer pageIndex,
					   @RequestParam(required = false,defaultValue="5") Integer pageSize,ModelMap m) {
		Tag t=tagService.getTagByName(name);

		int siteBasicStatistics[]=new int[5];
		siteBasicStatistics[0]=articleService.getArticleNumber();
		siteBasicStatistics[1]=articleService.getCommentNumber();
		siteBasicStatistics[2]=categoryService.getCount();
		siteBasicStatistics[3]=tagService.getCount();
		siteBasicStatistics[4]=articleService.getArticleSum();
		List<Tag> tagList=new ArrayList<Tag>();
		List<Category> categoryList=new ArrayList<Category>();
		tagList=tagService.listTag();

		categoryList=categoryService.listCategory();

		PageInfo<Article> pageInfo= articleService.getPageArticleListByTag(pageIndex,pageSize,t.getTagId());
		List<Article> hot=articleService.getArticleByView();
		List<Notice> notices=new ArrayList<Notice>();
		notices=noticeService.listNotice();
		m.put("siteBasicStatistics",siteBasicStatistics);
		m.put("pageInfo", pageInfo);
		m.put("hotList",hot);
		m.put("noticeList",notices);

		m.put("pageUrlPrefix","?pageIndex");
		m.put("tagList",tagList);
		m.put("categoryList1",categoryList);
		return "view/index";
	}
	/**
	 * 查找标签下文章
	 * @param name
	 * @param m
	 * @return
	 */

	@RequestMapping("/search")
	public String search(String q,@RequestParam(required = false,defaultValue="1")  Integer pageIndex,
						 @RequestParam(required = false,defaultValue="10000") Integer pageSize,ModelMap m) {
		String ss = q;
		int siteBasicStatistics[]=new int[5];
		siteBasicStatistics[0]=articleService.getArticleNumber();
		siteBasicStatistics[1]=articleService.getCommentNumber();
		siteBasicStatistics[2]=categoryService.getCount();
		siteBasicStatistics[3]=tagService.getCount();
		siteBasicStatistics[4]=articleService.getArticleSum();
		List<Tag> tagList=new ArrayList<Tag>();
		List<Category> categoryList=new ArrayList<Category>();
		tagList=tagService.listTag();
		categoryList=categoryService.listCategory();
		PageInfo<Article> pageInfo= articleService.getPageArticleListBySearch(pageIndex,pageSize,ss);
		List<Article> hot=articleService.getArticleByView();
		List<Notice> notices=new ArrayList<Notice>();
		notices=noticeService.listNotice();
		m.put("siteBasicStatistics",siteBasicStatistics);
		m.put("pageInfo", pageInfo);
		m.put("hotList",hot);
		m.put("noticeList",notices);

		m.put("pageUrlPrefix","?pageIndex");
		m.put("tagList",tagList);
		m.put("categoryList1",categoryList);
		return "view/index";
	}
	/**
	 * 点赞操作
	 */
	@RequestMapping(value="/like/{id}")
	public String like(@PathVariable("id") Integer id,ModelMap m) {
		articleService.addlike(id);
		Article a=articleService.getArticleById(id);
		User user=userService.getUserById(a.getArticleUserId());
		List<Category> categoryList=categoryService.listCategoryByArticleId(a.getArticleId());
		a.setCategoryList(categoryList);
		List<Tag> tagList=tagService.listTagByArticleId(a.getArticleId());
		a.setTagList(tagList);

		a.setUser(user);
		List<Article> hot=articleService.getArticleByView();
		m.put("hotList",hot);
		m.put("article", a);

		return "view/Page/articleDetail";
	}

}
