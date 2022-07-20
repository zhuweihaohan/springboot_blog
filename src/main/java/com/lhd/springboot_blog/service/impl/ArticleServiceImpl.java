package com.lhd.springboot_blog.service.impl;

import com.lhd.springboot_blog.entity.Article;
import com.lhd.springboot_blog.entity.Category;
import com.lhd.springboot_blog.entity.Tag;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.springboot_blog.mapper.ArticleMapper;
import com.lhd.springboot_blog.mapper.CategoryMapper;
import com.lhd.springboot_blog.mapper.ImgMapper;
import com.lhd.springboot_blog.mapper.TagMapper;
import com.lhd.springboot_blog.service.ArticleService;
import com.lhd.springboot_blog.utils.DeleteImgFile;
import com.lhd.springboot_blog.utils.ThreadPoolUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
@Slf4j
	public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleMapper articleMapper;
	@Resource
	private CategoryMapper categoryMapper;
	@Resource
	private TagMapper tagMapper;
	@Autowired
	private ImgMapper imgMapper;

	public List<Article> listRecentArticle(Integer n) {
		return articleMapper.listRecentArticle(n);
	}


	public PageInfo<Article> getPageArticleList(Integer pageIndex, Integer pageSize) {
		PageHelper.startPage(pageIndex,pageSize);

		List<Article> articleList= articleMapper.findAll();

		//把每个文件对应的分类信处查出来
		for(Article a:articleList) {
			List<Category> categoryList=categoryMapper.listCategoryByArticleId(a.getArticleId());
			a.setCategoryList(categoryList);
		}
		//查标签
		for(int i=0;i<articleList.size();i++) {

			List<Tag> tagList=tagMapper.listTagByArticleId(articleList.get(i).getArticleId());
			articleList.get(i).setTagList(tagList);
		}
		return new PageInfo<>(articleList);
	}


	@Override
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
	public void addArticle(Article article) {
		articleMapper.addArticle(article);
		log.info("插入文章的id:"+article.getArticleId());

		//添加文章和分类的对应信息
		for(Category c: article.getCategoryList()) {
			articleMapper.addArticleCategory(article.getArticleId(),c.getCategoryId());
		}
		//添加文章和标签的对应信息
		for(Tag t: article.getTagList()) {
			articleMapper.addArticleTag(article.getArticleId(),t.getTagId());
		}
	}


	public void addArticlec(Article article) {
		articleMapper.addArticlec(article);

	}



	public Article getArticleById(Integer id) {

		return articleMapper.getArticleTitleById(id);
	}



	@Override
	@Transactional
	public void deleteById(Integer id) {
		articleMapper.deleteArticle_tag_refById(id);
		articleMapper.deleteArticle_category_refById(id);
		articleMapper.deleteCommentById(id);
		articleMapper.deleteById(id);

		List<String> list = imgMapper.selImgPathByArticleId(id);
		ThreadPoolUtils.ThreadPool pool =ThreadPoolUtils.getInstance();
		for(int i= 0;i<list.size();i++){
   pool.execute(new DeleteImgFile(list.get(i)));
		}
		imgMapper.delArticleImgRefByArticleId(id);


	}



	public void updateArticle(Article article) {
		articleMapper.update(article);

	}


	//根据分类查询文章
	public PageInfo<Article> getPageArticleListByCategory(Integer pageIndex, Integer pageSize,Integer categoryId) {

		PageHelper.startPage(pageIndex,pageSize);

		List<Article> articleList= articleMapper.findByCategory(categoryId);

		//把每个文件对应的分类信处查出来
		for(Article a:articleList) {
			List<Category> categoryList=categoryMapper.listCategoryByArticleId(a.getArticleId());
			a.setCategoryList(categoryList);
		}
		//查标签
		for(int i=0;i<articleList.size();i++) {

			List<Tag> tagList=tagMapper.listTagByArticleId(articleList.get(i).getArticleId());
			articleList.get(i).setTagList(tagList);
		}
		return new PageInfo<>(articleList);
	}


	//查找标签下文章
	public PageInfo<Article> getPageArticleListByTag(Integer pageIndex, Integer pageSize, Integer tagId) {
		PageHelper.startPage(pageIndex,pageSize);

		List<Article> articleList= articleMapper.findByTag(tagId);

		//把每个文件对应的分类信处查出来
		for(Article a:articleList) {
			List<Category> categoryList=categoryMapper.listCategoryByArticleId(a.getArticleId());
			a.setCategoryList(categoryList);
		}
		//查标签
		for(int i=0;i<articleList.size();i++) {

			List<Tag> tagList=tagMapper.listTagByArticleId(articleList.get(i).getArticleId());
			articleList.get(i).setTagList(tagList);
		}
		return new PageInfo<>(articleList);

	}



	public PageInfo<Article> getPageArticleListBySearch(Integer pageIndex, Integer pageSize, String ss) {

		PageHelper.startPage(pageIndex,pageSize);

		List<Article> articleList= articleMapper.findBySearch(ss);

		//把每个文件对应的分类信处查出来
		for(Article a:articleList) {
			List<Category> categoryList=categoryMapper.listCategoryByArticleId(a.getArticleId());
			a.setCategoryList(categoryList);
		}
		//查标签
		for(int i=0;i<articleList.size();i++) {

			List<Tag> tagList=tagMapper.listTagByArticleId(articleList.get(i).getArticleId());
			articleList.get(i).setTagList(tagList);
		}
		return new PageInfo<>(articleList);
	}


	//添加浏览次数
	public void addViewContent(Integer id) {
		articleMapper.addViewContent(id);

	}


	//按浏览排序
	public List<Article> getArticleByView() {
		return articleMapper.getArticleTitleByView();
	}


	//查询文章数
	public int getArticleNumber() {

		return articleMapper.getArticleNumber();
	}


	//查询留言数
	public int getCommentNumber() {

		return articleMapper.getCommentNumber();
	}


	//查浏览总数
	public int getArticleSum() {

		return articleMapper.getArticleSum();
	}


	//点赞操作
	public void addlike(Integer id) {
		articleMapper.addlike(id);

	}
	//添加图片文章表
	@Override
	public void addArticleImgRef(String path, int articleId, String img_path) {
		articleMapper.addArticleImgRef(path,articleId,img_path);
	}

	@Override
	public void deleteArticleImgRef(String img_url, int articleId, String img_path) {
		articleMapper.deleteArticleImgRef(img_url,articleId,img_path);
	}

	@Override
	public PageInfo<Article> getPageArticleBlogList(Integer pageIndex, Integer pageSize) {
		PageHelper.startPage(pageIndex,pageSize);

		List<Article> articleList= articleMapper.getPageArticleBlogList();

		//把每个文件对应的分类信处查出来
		for(Article a:articleList) {
			List<Category> categoryList=categoryMapper.listCategoryByArticleId(a.getArticleId());
			a.setCategoryList(categoryList);
		}
		//查标签
		for(int i=0;i<articleList.size();i++) {

			List<Tag> tagList=tagMapper.listTagByArticleId(articleList.get(i).getArticleId());
			articleList.get(i).setTagList(tagList);
		}
		return new PageInfo<Article>(articleList);
	}
}

