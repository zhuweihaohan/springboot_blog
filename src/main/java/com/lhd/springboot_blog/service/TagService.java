package com.lhd.springboot_blog.service;

import com.lhd.springboot_blog.entity.Tag;

import java.util.List;

public interface TagService {
	/**
	 * 查询标签列表
	 * @return 标签列表
	 */
	public List<Tag> listTag();

	public Tag getTagByName(String tagName);

	public void addTag(Tag tag);

	public int getArticlenumberById(Integer tagId);

	public void updateTag(Tag tag);

	public void deleteById(Integer id);

	public int getCount();

	public List<Tag> listTagByArticleId(Integer articleId);
}
