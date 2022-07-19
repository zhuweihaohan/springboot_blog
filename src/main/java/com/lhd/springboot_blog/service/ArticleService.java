package com.lhd.springboot_blog.service;

import com.lhd.springboot_blog.entity.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ArticleService {
	/**
	 * 查询前n条文章
	 * @param n  要查出来的文章数
	 * @return 文章列表
	 */
	List<Article> listRecentArticle(Integer n);

	PageInfo<Article> getPageArticleList(Integer pageIndex, Integer pageSize);
	/**
	 * 发布文章
	 * @param article 文章信息
	 */
	void addArticle(Article article);
	void addArticlec(Article article);


	Article getArticleById(Integer commentArticleId);

	void deleteById(Integer id);

	void updateArticle(Article article);

	PageInfo<Article> getPageArticleListByCategory(Integer pageIndex, Integer pageSize,Integer categoryId);
	//查询标签下文章
	PageInfo<Article> getPageArticleListByTag(Integer pageIndex, Integer pageSize, Integer tagId);
	//搜索文章
	PageInfo<Article> getPageArticleListBySearch(Integer pageIndex, Integer pageSize, String ss);

	void addViewContent(Integer id);

	List<Article> getArticleByView();

	int getArticleNumber();
	//留言数
	int getCommentNumber();

	int getArticleSum();

	void addlike(Integer id);
}
