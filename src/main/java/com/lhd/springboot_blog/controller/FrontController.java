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

    @RequestMapping("")
    public String index() {

        return "redirect:/article/blog";
    }
}
