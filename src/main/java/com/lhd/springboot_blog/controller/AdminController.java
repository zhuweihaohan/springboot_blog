package com.lhd.springboot_blog.controller;

import com.lhd.springboot_blog.entity.*;
import com.lhd.springboot_blog.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		User tempuser=userService.getUserByName(user.getUserName());
		if(tempuser==null)
		{user.setUserRegisterTime(new Date());
			user.setUserStatus(1);
			user.setUserPhoto(photo.getBytes());
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
	@RequestMapping("/photo/{id}")
	public void showPhoto(@PathVariable("id") Integer id,HttpServletResponse response) throws IOException {
		User user=userService.getUserById(id);

		response.setContentType("image/jpg");
		ServletOutputStream outStream=response.getOutputStream();
		outStream.write(user.getUserPhoto());
		outStream.flush();
	}

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