package com.lhd.springboot_blog.mapper;

import com.lhd.springboot_blog.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TagMapper {



	/**
	 * 查询标签列表
	 * @return 标签列表
	 */
	public List<Tag> listTag();
	
	
	public Tag getTagByName (@Param("tagName") String tagName);

	/**
	 * 添加标签
	 * @param tag
	 */
	public void addTag(Tag tag);


public int getArticlenumberById(@Param("tagId") Integer tagId);


public void update(Tag tag) ;


public void deleteById(Integer id);


public List<Tag> listTagByArticleId(Integer articleId);


public int getCount();




}
