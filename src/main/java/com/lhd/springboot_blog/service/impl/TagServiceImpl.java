package com.lhd.springboot_blog.service.impl;

import com.lhd.springboot_blog.entity.Tag;
import com.lhd.springboot_blog.mapper.TagMapper;
import com.lhd.springboot_blog.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl implements TagService{

	@Resource
	private TagMapper tagMapper;

	public List<Tag> listTag() {
		return tagMapper.listTag();
	}

	public Tag getTagByName(String tagName) {

		return tagMapper.getTagByName(tagName);
	}

	//添加标签
	@Transactional
	public void addTag(Tag tag) {
		tagMapper.addTag(tag);
	}

	/**
	 * 得到文章数
	 */
	public int getArticlenumberById(Integer tagId) {

		return tagMapper.getArticlenumberById(tagId);
	}


	public void updateTag(Tag tag) {
		tagMapper.update(tag);

	}


	public void deleteById(Integer id) {
		tagMapper.deleteById(id);

	}

	//查数量
	public int getCount() {

		return tagMapper.getCount();
	}
	//根据文章查标签
	public List<Tag> listTagByArticleId(Integer articleId) {

		return tagMapper.listTagByArticleId(articleId);
	}

}