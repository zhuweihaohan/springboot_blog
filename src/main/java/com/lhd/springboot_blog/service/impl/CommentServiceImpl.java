package com.lhd.springboot_blog.service.impl;

import com.lhd.springboot_blog.entity.Comment;
import com.lhd.springboot_blog.mapper.ArticleMapper;
import com.lhd.springboot_blog.mapper.CommentMapper;
import com.lhd.springboot_blog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentMapper commentMapper;
	@Resource
	private ArticleMapper articleMapper;
	public List<Comment> listRecentComment(Integer n) {
		
		List<Comment> comments= commentMapper.listRecentComment(n);
		for(Comment c:comments)
		c.setArticle(articleMapper.getArticleTitleById(c.getCommentArticleId()));
		return comments;
	}
	
	public List<Comment> listComment() {
		
		return commentMapper.listComment();
	}
}