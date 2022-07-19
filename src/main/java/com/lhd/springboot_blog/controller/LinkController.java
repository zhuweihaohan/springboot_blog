package com.lhd.springboot_blog.controller;

import com.lhd.springboot_blog.entity.Link;
import com.lhd.springboot_blog.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller @RequestMapping("/Link")
public class LinkController {

	@Resource
	LinkService linkService;

	@RequestMapping("")
	public String index(ModelMap m) {
		List<Link> links=linkService.listLink();
		System.out.println(links);
		m.put("linkList", links);


		return "Link/Link";
	}
	@RequestMapping("/show")
	public String show(ModelMap m) {
		List<Link> links=linkService.listLink();
		System.out.println(links);
		m.put("links", links);


		return "home/Link";
	}
	@RequestMapping(value="/insert")
	public String addLink(Link link) {


		linkService.addCategory(link);
		return "redirect:/Link";}

	/**
	 * 删除公告
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteLink/{id}")
	public String deleteAdmin(@PathVariable("id") Integer id) {
		linkService.deleteById(id);
		return "redirect:/Link";
	}
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id,ModelMap m)
	{Link link= linkService.getLinkById(id);
		m.put("link", link);
		return "Link/edit";
	}
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") int id,HttpServletRequest request)
	{ Link link=new Link();
		link.setLinkId(id);
		link.setLinkName(request.getParameter("linkName"));
		link.setLinkDescription(request.getParameter("linkDescription"));
		link.setLinkOrder(Integer.valueOf(request.getParameter("linkOrder")) );
		link.setLinkUrl(request.getParameter("linkUrl"));
		link.setLinkOwnerContact(request.getParameter("linkOwnerContact"));
		link.setLinkUpdateTime(new Date());
		linkService.update(link);
		return "redirect:/Link";
	}
}
