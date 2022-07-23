package com.lhd.springboot_blog.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageInfo;
import com.lhd.springboot_blog.entity.*;
import com.lhd.springboot_blog.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller @RequestMapping("/admin")
@Slf4j
public class AdminController {
	@Resource
	UserService userService;
	@Resource
	private ArticleService articleService;
	@Resource
	private CommentService commentService;
	@Resource
	private TagService tagService;
	@Resource
	private NoticeService noticeService;
	@Value("${img_file}")
	private String img_file;
	@Value("${img_url}")
	private String img_url;
	@Autowired
	private VisitService visitService;
	@RequestMapping("/login")
	public String login(String userName,String userPass,ModelMap m,HttpSession session) {
		User user=userService.login(userName, userPass);
		log.info("登录用户------>"+user);
		if(user!=null) {
			m.put("msg", "登录成功");
			session.setAttribute("session_user", user);
			//展示最近五个文章
			List<Article> articleList=articleService.listRecentArticle(5);
			m.put("articleList", articleList);
			//展示最近五条评论
			List<Comment> commentList =commentService.listRecentComment(5);
			m.put("commentList", commentList);
			//添加cookie 相关的信息
			//更新用户最后的登录时间
			//更新用户的最后登录IP
			//....

			return "index";
		}
		else {
			m.put("msg", "用户名或密码错误,登录失败");
			return "login";
		}
	}
	@RequestMapping(value="")
	public String index(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("session_user");

		if(obj==null)

		{
//			m.put("msg", "请先登录");
			return "login";}
		//展示最近五个文章
		else {
			List<Article> articleList=articleService.listRecentArticle(5);
			m.put("articleList", articleList);
			//展示最近五条评论
			List<Comment> commentList =commentService.listRecentComment(5);
			m.put("commentList", commentList);
			//添加cookie 相关的信息
			//更新用户最后的登录时间
			//更新用户的最后登录IP
			//....

			return "index"; }
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String Register(String userName,String userNickname,String userEmail,String userPass,String userPass1,ModelMap m)
	{  return "User/user-add";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(User user,MultipartFile photo,ModelMap m,HttpServletResponse response) throws IOException {
		//生成一个随机的文件名
		String newName= UUID.randomUUID().toString();
		File destFile =new File(img_file+newName+".jpg");

		photo.transferTo(destFile);

		String path=img_url+newName+".jpg";
		User tempuser=userService.getUserByName(user.getUserName());
		if(tempuser==null)
		{user.setUserRegisterTime(new Date());
			user.setUserStatus(1);
			user.setUserAvatar(path);
			userService.addUser(user);
			return "redirect:/admin/user";   }//添加完成以后.转到用望列表
		else
		{m.put("msg", "已有此账号");
			return "User/user-add";}
	}

	@RequestMapping(value="/user")
	public String users(ModelMap m) {
		List<User> userList= userService.listUser();
		m.put("userList",userList);
		return "User/user-list";
	}
	@RequestMapping(value="/visit_list")
	public String visitList(@RequestParam(required = false,defaultValue="1")  Integer pageIndex,
							@RequestParam(required = false,defaultValue="30") Integer pageSize,ModelMap m) {
		PageInfo<VisitInfo> pageInfo= visitService.getPageVisitList(pageIndex,pageSize);

		m.put("pageInfo", pageInfo);

		m.put("pageUrlPrefix","admin/visit_list?pageIndex");

		return "Visit/visit-list";
	}

	@RequestMapping(value="/ip_list")
	public String ipList(@RequestParam(required = false,defaultValue="1")  Integer pageIndex,
							@RequestParam(required = false,defaultValue="20") Integer pageSize,ModelMap m) {
		PageInfo<IpListInfo> pageInfo= visitService.getPageIpList(pageIndex,pageSize);

		m.put("pageInfo", pageInfo);

		m.put("pageUrlPrefix","admin/ip_list?pageIndex");

		return "Visit/ip-list";
	}

	@RequestMapping(value = "/checkUserName",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject checkUserName(HttpServletRequest request){
		String userName = request.getParameter("username");
		User user =userService.getUserByName(userName);
		if(user==null){
		JSONObject json=new JSONObject();
		json.put("code",0);
		json.put("msg","用户名可用");

		return json;}
		else {
			JSONObject json=new JSONObject();
			json.put("code",1);
			json.put("msg","用户名已存在");

			return json;
		}
	}
	@RequestMapping(value="/userForOne")
	public String user(ModelMap m,HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("session_user");
		if(user==null)
		{ m.put("msg","请先登录");
			return "login";}

		else
		{User temp=userService.getUserById(user.getUserId());
			List<User> userList=new ArrayList<User>();
			userList.add(temp);
			m.put("userList",userList);
			return "User/user-list";}
	}
//	@RequestMapping("/photo/{id}")
//	public void showPhoto(@PathVariable("id") Integer id,HttpServletResponse response) throws IOException {
//		User user=userService.getUserById(id);
//
//		response.setContentType("image/jpg");
//		ServletOutputStream outStream=response.getOutputStream();
//		outStream.write(user.getUserPhoto());
//		outStream.flush();
//	}

	@RequestMapping(value="/addTag")
	public String addTag(Tag tag,ModelMap m) {
		Tag tempTag=tagService.getTagByName(tag.getTagName());
		if(tempTag==null)
		{tagService.addTag(tag);
			return "redirect:/admin/tag-list";}
		else
		{m.put("msg", "已有此标签");
			return "Tag/Tag-list";
		}


	}

	@RequestMapping(value="/tag-list")
	public String tagList(ModelMap m) {
		List<Tag> tagList=tagService.listTag();
		for(int i=0;i<tagList.size();i++)
		{ int number=tagService.getArticlenumberById(tagList.get(i).getTagId());
			tagList.get(i).setArticleCount(number);
		}
		m.put("tagList",tagList);
		return "Tag/Tag-list";
	}

	@RequestMapping(value="/Notice")
	public String noticeList(ModelMap m) {
		List<Notice> noticeList=noticeService.listNotice();

		m.put("noticeList",noticeList);
		return "Notice/Notice";
	}

	@RequestMapping(value="/addNotice")
	public String addNotice(Notice notice) {

		noticeService.addNotice(notice);

		return "redirect:/admin/Notice";


	}
	/**
	 * 删除公告
	 *
	 * @param id 文章ID
	 */
	@RequestMapping("/deleteNotice/{id}")
	public String deleteNotice(@PathVariable("id") Integer id) {
		noticeService.deleteById(id);
		return "redirect:/admin/Notice";
	}
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable("id") Integer id) {
		userService.deleteById(id);
		return "redirect:/admin/user";
	}
	@RequestMapping("/editTag/{name}")
	public String editTag(@PathVariable("name") String name,ModelMap m) {
		Tag tag=tagService.getTagByName(name);
		m.put("tag", tag);
		m.put("tagId", tag.getTagId());
		return "Tag/edit";
	}
	@RequestMapping(value="/updateTag/{id}", method=RequestMethod.POST)  //POST 请求走这个方法
	public String updateTag(@PathVariable("id") Integer id,ModelMap m,HttpServletRequest request){
		Tag tag=new Tag();
		tag.setTagId(id);
		tag.setTagName(request.getParameter("tagName"));
		tag.setTagDescription(request.getParameter("tagDescription"));

		tagService.updateTag(tag);

		//将请求转发到查询所有文章
		return "redirect:/admin/tag-list";
	}

	/**
	 * 修改用户*/
	@RequestMapping(value="/edit/{id}")
	public String edit(@PathVariable("id") Integer id,ModelMap m) {
		User user=userService.getUserById(id);
		m.put("user",user);

		return "User/edit";
	}
	@RequestMapping(value="/updateUser/{id}", method=RequestMethod.POST)  //POST 请求走这个方法
	public String updateUser(@PathVariable("id") Integer id,ModelMap m,HttpServletRequest request){
		User user=new User();
		user.setUserName(request.getParameter("userName"));
		user.setUserId(id);
		user.setUserNickname(request.getParameter("userNickname"));
		user.setUserPass(request.getParameter("userPass"));
		user.setUserEmail(request.getParameter("userEmail"));
		user.setUserUrl(request.getParameter("userUrl"));
		userService.update(user);
		//将请求转发到查询所有文章
		return "redirect:/admin/user";
	}
	@RequestMapping("/deleteTag/{id}")
	public String deleteTag(@PathVariable("id") Integer id) {
		tagService.deleteById(id);
		return "redirect:/admin/tag-list";
	}
	/**
	 * 修改用户*/
	@RequestMapping(value="/editNotice/{id}")
	public String editNotice(@PathVariable("id") Integer id,ModelMap m) {
		Notice n=new Notice();
		n=noticeService.getNoticeById(id);
		m.put("notice", n);
		return "Notice/edit";
	}
	@RequestMapping(value="/updateNotice/{id}", method=RequestMethod.POST)  //POST 请求走这个方法
	public String updateNotice(@PathVariable("id") Integer id,HttpServletRequest request){
		Notice n=new Notice();
		n.setNoticeContent(request.getParameter("noticeContent"));
		n.setNoticeId(id);
		n.setNoticeTitle(request.getParameter("noticeTitle"));
		noticeService.updateById(n);
		//将请求转发到查询所有文章
		return "redirect:/admin/Notice";
	}
	@RequestMapping(value="/showNotice/{id}")
	public String showNotice(@PathVariable("id") Integer id,HttpServletRequest request,ModelMap m){
		Notice notice=noticeService.getNoticeById(id);
		List<Article> hot=articleService.getArticleByView();
		m.put("hotList",hot);
		m.put("notice",notice);
		return "view/Page/noticeDetail";
	}
	@RequestMapping("/loginshow")
	public String loginshow(String userName,String userPass,ModelMap m,HttpSession session) {
		User user=userService.login(userName, userPass);
		if(user!=null) {
			m.put("msg", "登录成功");
			m.put("suser",user);
			session.setAttribute("session_user", user);
			//展示最近五个文章
			List<Article> articleList=articleService.listRecentArticle(5);
			m.put("articleList", articleList);
			//展示最近五条评论
			List<Comment> commentList =commentService.listRecentComment(5);
			m.put("commentList", commentList);
			//添加cookie 相关的信息
			//更新用户最后的登录时间
			//更新用户的最后登录IP
			//....

			return "home/index";
		}
		else {
			m.put("msg", "用户名或密码错误,登录失败");
			return "showLogin";
		}
	}
	@RequestMapping("/logout")
	public String logout(ModelMap m,HttpSession session) {
		session.removeAttribute("session_user");

		return "login";
	}
}