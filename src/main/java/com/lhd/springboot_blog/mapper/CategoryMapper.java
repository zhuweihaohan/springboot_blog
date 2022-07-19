package com.lhd.springboot_blog.mapper;

import com.lhd.springboot_blog.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CategoryMapper {
	@Select("select * from category where category_id in(  select category_id from article_category_ref where article_id= #{articleId})")
	List<Category> listCategoryByArticleId(Integer articleId);



	/**
	 * 查询分类列表
	 * @return
	 */
	@Select("select * from category ")
	List<Category> listCategory();

	/**
	 * 根据父类级分类的id查询子级分类列表,暂时没用上,以后可能会用
	 * @param parentId 父级分类
	 * @return 子級分类列表
	 */
	@Select("select * from category where category_pi=#{parentId}")
	List<Category> listCategoryByParentId(Integer parentId);

	/**
	 * 根据name查询
	 * @param categoryName
	 * @return
	 */
	@Select("select * from category where category_name=#{categoryName}")
	Category getCategoryByName(@Param("categoryName") String categoryName);


	@Insert("insert into category (category_pid,category_name,category_description,category_icon) values(#{categoryPid},#{categoryName},#{categoryDescription},#{categoryIcon})")
	void addCategory(Category category);


	@Update("update category set category_name=#{categoryName},category_description=#{categoryDescription},category_icon=#{categoryIcon} WHERE category_id=#{categoryId}")
	void update(Category c);


	@Select("select count(*) from article_category_ref where category_id=#{id}")
	Integer getNumberById(int id);


	@Delete("delete from category where category_id=#{id}")
	void delete(Integer id);


	@Select("select count(*) from category")
	int getCount();

}
