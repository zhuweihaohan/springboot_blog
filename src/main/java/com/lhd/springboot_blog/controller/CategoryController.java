package com.lhd.springboot_blog.controller;

import com.lhd.springboot_blog.entity.Article;
import com.lhd.springboot_blog.entity.Category;
import com.lhd.springboot_blog.entity.Notice;
import com.lhd.springboot_blog.entity.Tag;
import com.github.pagehelper.PageInfo;
import com.lhd.springboot_blog.service.ArticleService;
import com.lhd.springboot_blog.service.CategoryService;
import com.lhd.springboot_blog.service.NoticeService;
import com.lhd.springboot_blog.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller @RequestMapping("/category")
public class CategoryController {
	@Resource
	CategoryService categoryService;
	@Resource
	TagService tagService;
	@Resource
	ArticleService articleService;
	@Resource
	NoticeService noticeService;
	@RequestMapping("")
	public String index(ModelMap m) {
		List<Category> categories=categoryService.listCategory();
		for(int i=0;i<categories.size();i++)
		{categories.get(i).setArticleCount(categoryService.getNumberById(categories.get(i).getCategoryId()));}
		m.put("categoryList", categories);


		return "Category/Category";
	}

	@RequestMapping(value="/insert")
	public String addCategory(Category category,ModelMap m) {
		Category tempCategory=categoryService.getCategoryByName(category.getCategoryName());
		if(tempCategory==null)
		{categoryService.addCategory(category);
			return "redirect:/category";}
		else
		{m.put("msg", "已有此标签");
			return "redirect:/category";
		}


	}
	@RequestMapping("/edit/{name}")
	public String edit(@PathVariable("name") String name,ModelMap m) {
		Category c=categoryService.getCategoryByName(name);
		m.put("category",c);
		m.put("category_id", c.getCategoryId());
		//转向
		return "Category/edit";
	}

	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)  //POST 请求走这个方法
	public String update(@PathVariable("id") Integer id,ModelMap m,HttpServletRequest request){
		Category c=new Category();

		c.setCategoryId(id);
		c.setCategoryName(request.getParameter("categoryName"));
		c.setCategoryDescription(request.getParameter("categoryDescription"));
		c.setCategoryIcon(request.getParameter("categoryIcon"));

		categoryService.updateArticle(c);

		//将请求转发到查询所有文章
		return "forward:/category";
	}
	@RequestMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") Integer id) {
		categoryService.deleteById(id);
		return "redirect:/category";
	}
	/**
	 * 查找分类下文章
	 * @param name
	 * @param m
	 * @return
	 */
	@RequestMapping("/find/{name}")
	public String find(@PathVariable("name") String name,@RequestParam(required = false,defaultValue="1")  Integer pageIndex,
					   @RequestParam(required = false,defaultValue="5") Integer pageSize,ModelMap m) {
		Category c=categoryService.getCategoryByName(name);
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

		PageInfo<Article> pageInfo= articleService.getPageArticleListByCategory(pageIndex,pageSize,c.getCategoryId());
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
}
