package com.lhd.springboot_blog.service;

import com.lhd.springboot_blog.entity.Category;

import java.util.List;

public interface CategoryService {
	/**
	 * 查询分类列表
	 * @return 分类列表
	 */
	List<Category> listCategory();

	Category getCategoryByName(String categoryName);

	void addCategory(Category category);

	void updateArticle(Category c);

	Integer getNumberById(int id);

	void deleteById(Integer id);
//查数量
	int getCount();

	List<Category> listCategoryByArticleId(Integer articleId);
	
}
