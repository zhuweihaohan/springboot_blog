package com.lhd.springboot_blog.config;

import com.lhd.springboot_blog.service.VisitService;
import com.lhd.springboot_blog.utils.IP.IpAddressUtil;
import com.lhd.springboot_blog.utils.ThreadPoolUtils;
import com.lhd.springboot_blog.utils.mail.SendNewIpMail;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.ip2region.core.Ip2regionSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter
@Component
@Slf4j
public class WebVisitFilter implements Filter {
    @Autowired
    private VisitService visitService;

    @Value("${resultFile}")
    private String resultFile;
    @Value("${mysqlIp}")
    private   String mysqlIp;
    @Value("${spring.datasource.username}")
    private  String userName;
    @Value("${spring.datasource.password}")
    private  String password;
    @Value("${database}")
    private  String database;
    @Value("${mysql_port}")
    private  String port;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    private Ip2regionSearcher regionSearcher;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * 输出访问 ip
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //获取访问 ip 地址
        HttpServletRequest req = (HttpServletRequest) request;
        String visitIp = IpAddressUtil.getIpAddr(req);

        // 每次拦截到请求输出访问 ip
        if (!((HttpServletRequest) request).getServletPath().startsWith("/static")){
            String site = regionSearcher.getAddress(visitIp);
        log.info("访问 IP = " + visitIp+",访问接口："+ ((HttpServletRequest) request).getServletPath()+",ip属地："+site);
        String url = ((HttpServletRequest) request).getServletPath();
        int count = visitService.getNewIp(visitIp);
        if(count==0){
            ThreadPoolUtils.ThreadPool pool=ThreadPoolUtils.getInstance();
            pool.execute(new SendNewIpMail(javaMailSender,visitIp,site));
        }
        visitService.addRecord(visitIp,url,site);

        }
        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {
    }
}