package com.lhd.springboot_blog.service.impl;

import com.lhd.springboot_blog.entity.Link;
import com.lhd.springboot_blog.mapper.LinkMapper;
import com.lhd.springboot_blog.service.LinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LinkServiceImpl implements LinkService{

	@Resource
	private  LinkMapper linkMapper;
	public List<Link> listLink() {
		
		return linkMapper.listLink();
	}

	public void addCategory(Link link) {
		linkMapper.addLink(link);
		
	}

	
	public void deleteById(Integer id) {
		linkMapper.deleteById(id);
		
	}


	public Link getLinkById(int id) {
		
		return linkMapper.getLinkById(id);
	}

	
	public void update(Link link) {
		linkMapper.update(link);
		
	}

}
