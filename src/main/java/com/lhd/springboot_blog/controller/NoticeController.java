package com.lhd.springboot_blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author lhd
 * @Description //TODO
 * @Date 2022/7/18 17:26
 * @company bonc
 * @project springboot_blog
 */
@Controller
@RequestMapping("/Notice")
@Slf4j
public class NoticeController {
    @RequestMapping(value="/add",method= RequestMethod.GET)
    public String Register(String userName, String userNickname, String userEmail, String userPass, String userPass1, ModelMap m)
    {  return "Notice/addNotice";
    }
}
