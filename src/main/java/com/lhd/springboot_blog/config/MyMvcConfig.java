package com.lhd.springboot_blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;


@Component
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * springboot 无法直接访问静态资源，需要放开资源访问路径。
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/META-INF/resources/");
    }

    //配置视图组件
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/index.html").setViewName("index");
            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                /**
                 * addPathPatterns：拦截哪些请求
                 * excludePathPatterns：不拦截哪些请求
                 */
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                        excludePathPatterns("/","/admin/login","/admin/logout","/static/**","/admin",
                                "/article/blog","/category/find/**","/article/search","/article/findTag/**","/article/show/**","/article/like/**");
            }
        };
        return adapter;
    }
}
