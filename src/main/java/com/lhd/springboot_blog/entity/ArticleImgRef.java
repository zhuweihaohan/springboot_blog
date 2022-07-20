package com.lhd.springboot_blog.entity;

import lombok.Data;

/**
 * @Author lhd
 * @Description //TODO
 * @Date 2022/7/19 15:08
 * @company bonc
 * @project springboot_blog
 */
@Data
public class ArticleImgRef {
    private int articleId;
    private String imgUrl;
    private String imgPath;
    private String createTime;
}
