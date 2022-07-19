package com.lhd.springboot_blog.config;

import com.lhd.springboot_blog.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author lhd
 * @Description //TODO
 * @Date 2022/7/18 9:32
 * @company bonc
 * @project springboot_blog
 */
@Slf4j
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("session_user");

        if(obj==null)

        {    response.sendRedirect("/admin");
            return false;}
        else {
            User user=(User)request.getSession().getAttribute("session_user");
//            log.info("用户操作："+user.getUserName());
            return true;
        }
    }
    }
