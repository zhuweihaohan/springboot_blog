package com.lhd.springboot_blog.service.impl;

import com.lhd.springboot_blog.entity.Category;
import com.lhd.springboot_blog.mapper.CategoryMapper;
import com.lhd.springboot_blog.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Resource
	private CategoryMapper categoryMapper;


	public List<Category> listCategory() {
		return categoryMapper.listCategory();
	}


	public Category getCategoryByName(String categoryName) {

		return categoryMapper.getCategoryByName(categoryName);
	}


	/**
	 * 添加分类
	 */
	public void addCategory(Category category) {
		categoryMapper.addCategory(category);
	}


	public void updateArticle(Category c) {
		categoryMapper.update(c);

	}



	public Integer getNumberById(int id) {

		return categoryMapper.getNumberById(id);
	}



	public void deleteById(Integer id) {
		categoryMapper.delete(id);

	}


	//查数量
	public int getCount() {

		return categoryMapper.getCount();
	}


	//根据文章查分类
	public List<Category> listCategoryByArticleId(Integer articleId) {

		return categoryMapper.listCategoryByArticleId(articleId);
	}
}