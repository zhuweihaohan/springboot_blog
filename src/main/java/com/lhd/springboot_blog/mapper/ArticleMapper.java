package com.lhd.springboot_blog.mapper;

import com.lhd.springboot_blog.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleMapper {
	/**
	 * 添加文章信息
	 * @param article
	 */
	@Insert("insert into article" +
			"		        (article_user_id, article_title," +
			"		        article_view_count, article_comment_count," +
			"		        article_like_count, article_create_time, article_update_time," +
			"		        article_is_comment, article_status, article_order," +
			"		        article_content, article_summary)" +
			"		        values (#{articleUserId}, #{articleTitle}," +
			"		        #{articleViewCount}," +
			"		        #{articleCommentCount}," +
			"		        #{articleLikeCount}, #{articleCreateTime}," +
			"		        #{articleUpdateTime}," +
			"		        #{articleIsComment}, #{articleStatus}, #{articleOrder}," +
			"		        #{articleContent}, #{articleSummary})")
	@Options(useGeneratedKeys = true, keyProperty = "articleId", keyColumn = "article_id")
	void addArticle(Article article);


	/**
	 * 查询前n条文章
	 * @param n  要查出来的文章数
	 * @return 文章列表
	 */
	@Select("select * from article order by article_id DESC limit #{n}")
	List<Article> listRecentArticle(Integer n);

	/**
	 * @param commentArticleId
	 * @return Article
	 */
	@Select("select * from article where article_id=#{commentArticleId}")
	Article getArticleTitleById(Integer commentArticleId);
	@Select("select * from article order  by article_order DESC, article_id DESC")
	List<Article> findAll();

	/**
	 * 添加文章和分类的关联
	 * @param articleId 文章ID
	 * @param categoryId 分类ID
	 */
	@Insert("insert into article_category_ref (article_id,category_id) values (#{articleId},#{categoryId})")
	void addArticleCategory(@Param("articleId") Integer articleId, @Param("categoryId") Integer  categoryId);

	/**
	 * 添加文章和标签的关联
	 * @param articleId 文章ID
	 * @param tagId 标签ID
	 */
	@Insert("insert into article_tag_ref (article_id,tag_id) values (#{articleId},#{tagId})")
	void addArticleTag(@Param("articleId") Integer articleId, @Param("tagId") Integer tagId);

	@Insert("insert into article (article_user_id,article_title,article_status,article_content,article_create_time)" +
			" values(#{articleUserId},#{articleTitle},#{articleStatus},#{articleContent},#{articleCreateTime})")
	@Options(useGeneratedKeys = true, keyProperty = "articleId", keyColumn = "article_id")
	void addArticlec(Article article);


	@Delete("delete from article where article_id=#{id};")
	void deleteById(Integer id);
@Delete("delete from comment where comment_article_id=#{id};")
	void deleteCommentById(Integer id);
@Delete("delete from article_category_ref where article_id=#{id};")
	void deleteArticle_category_refById(Integer id);
@Delete("delete from article_tag_ref where article_id=#{id};")
	void deleteArticle_tag_refById(Integer id);
@Update("update article set article_user_id=#{articleUserId},article_title=#{articleTitle},article_content=#{articleContent},article_status=#{articleStatus},article_update_time=#{articleUpdateTime},article_summary=#{articleSummary} where article_id=#{articleId}")
void update(Article article);

@Select("select * from article where article_id in(SELECT article_id from article_category_ref where category_id=#{categoryId})")
List<Article> findByCategory(Integer categoryId);

@Select("select * from article where article_id in(SELECT article_id from article_tag_ref where tag_id=#{tagId})")
List<Article> findByTag(Integer tagId);

@Select("select * from article where article_title like concat('%',#{ss},'%') or article_content like concat('%',#{ss},'%')")
List<Article> findBySearch(String ss);

@Update("update article set article_view_count=article_view_count+1 where article_id=#{id}")
void addViewContent(Integer id);

@Select("select * from article order by article_view_count desc limit 5")
List<Article> getArticleTitleByView();

@Select("select count(*) from article")
int getArticleNumber();

@Select("select count(*) from comment")
int getCommentNumber();

@Select("SELECT SUM(article_view_count) FROM article")
int getArticleSum();

@Update("update article set article_like_count=article_like_count+1 where article_id=#{id}")
void addlike(Integer id);
@Insert("insert into article_img_ref (article_id,img_url,img_path,create_time) values(#{articleId},#{path},#{img_path},now())")
	void addArticleImgRef(String path, int articleId, String img_path);
@Delete("delete from article_img_ref where img_url =#{img_url} and article_id=#{articleId} and img_path =#{img_path} ")
    void deleteArticleImgRef(String img_url, int articleId, String img_path);
	@Select("select * from article where article_status =1 order  by article_order DESC, article_id DESC")
    List<Article> getPageArticleBlogList();
}
