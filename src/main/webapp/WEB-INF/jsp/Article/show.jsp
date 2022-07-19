<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
					<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>			
					
					<rapid:override name="frame-content">
				     <!-- 内容主体区域 -->
				    
        <div style="padding: 15px;">
            <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="admin">首页</a>
               <a >文章详情</a>
        </span>
    </blockquote>
      <blockquote class="layui-elem-quote layui-quote-nm">
                文章标题：  ${article.getArticleTitle()}
                <ul>
                    <li></li>
                    <li>内容如下</li>
                     <li>${article.getArticleContent() }</li>
                </ul>
            </blockquote>

</div>

					</rapid:override>
					<%@ include file="../framework.jsp" %>
					