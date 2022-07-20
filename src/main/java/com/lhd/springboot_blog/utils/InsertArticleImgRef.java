package com.lhd.springboot_blog.utils;


import com.lhd.springboot_blog.service.ArticleService;

import java.io.File;
import java.util.concurrent.CountDownLatch;

/**
 * @Author lhd
 * @Description //TODO
 * @Date 2022/7/19 15:18
 * @company bonc
 * @project springboot_blog
 */

public class InsertArticleImgRef implements Runnable {


    private String path;
    private CountDownLatch countDownLatch;
    private int articleId;
    private String img_path;
    public InsertArticleImgRef(String path, CountDownLatch countDownLatch,int articleId,String img_path){
        this.path=path;
        this.countDownLatch = countDownLatch;
        this.articleId=articleId;
        this.img_path = img_path;
    };

    public static void InsertArticleImgRefF(String img_url_temp, int articleId, String s) {
        ArticleService articleService=SpringUtil.getBean(ArticleService.class);
        articleService.addArticleImgRef(img_url_temp,articleId,s);
    }

    public static void DeleteArticleImgRefF(String img_url, int articleId, String img_path) {
        ArticleService articleService=SpringUtil.getBean(ArticleService.class);
        articleService.deleteArticleImgRef(img_url,articleId,img_path);
        File file=new File(img_path);
        file.delete();
    }

    @Override
    public void run() {
        ArticleService articleService=SpringUtil.getBean(ArticleService.class);
articleService.addArticleImgRef(path,articleId,img_path);
countDownLatch.countDown();
    }
}
