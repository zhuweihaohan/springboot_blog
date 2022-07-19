package com.lhd.springboot_blog.service;

import com.lhd.springboot_blog.entity.Link;

import java.util.List;

public interface LinkService {
	/**
	 * 获取链接表
	 * @return
	 */
	List<Link> listLink();

void addCategory(Link link);

void deleteById(Integer id);

Link getLinkById(int id);

void update(Link link);

}
