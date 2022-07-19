package com.lhd.springboot_blog.controller;

import com.github.pagehelper.PageInfo;
import com.lhd.springboot_blog.entity.*;
import com.lhd.springboot_blog.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lhd
 * @Description //TODO
 * @Date 2022/7/18 16:53
 * @company bonc
 * @project springboot_blog
 */
@Controller
@Slf4j
public class FrontController {
    @Resource
    ArticleService articleService;
    @Resource
    CategoryService categoryService;
    @Resource
    TagService tagService;
    @Resource
    CommentService commentService;
    @Resource
    NoticeService noticeService;
    @RequestMapping("")
    public String index(ModelMap m) {

        int siteBasicStatistics[]=new int[5];
        siteBasicStatistics[0]=articleService.getArticleNumber();
        siteBasicStatistics[1]=articleService.getCommentNumber();
        siteBasicStatistics[2]=categoryService.getCount();
        siteBasicStatistics[3]=tagService.getCount();
        siteBasicStatistics[4]=articleService.getArticleSum();
        List<Tag> tagList=new ArrayList<Tag>();
        List<Category> categoryList=new ArrayList<Category>();
        tagList=tagService.listTag();

        categoryList=categoryService.listCategory();

        PageInfo<Article> pageInfo= articleService.getPageArticleList(1,10);
        List<Article> hot=articleService.getArticleByView();
        m.put("hotList",hot);
        List<Notice> notices=new ArrayList<Notice>();

        notices=noticeService.listNotice();
        m.put("siteBasicStatistics",siteBasicStatistics);
        m.put("pageInfo", pageInfo);

        m.put("noticeList",notices);

        m.put("pageUrlPrefix","?pageIndex");
        m.put("tagList",tagList);
        m.put("categoryList1",categoryList);
        return "view/index";
    }
}
