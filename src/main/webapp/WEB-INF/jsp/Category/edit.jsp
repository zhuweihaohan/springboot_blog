<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
				<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
											
				<rapid:override name="frame-header-style">
					<link rel="stylesheet" href="static/css/index-page.css">
				</rapid:override>
				
				<rapid:override name="frame-content"  >
				
        <!-- 内容主体区域 -->
        <div style="padding:15px;">
            <blockquote class="layui-elem-quote">
				        <span class="layui-breadcrumb" lay-separator="/">
				              <a  href="admin">首页</a>
				              <a >分类列表</a>
				              <a><cite>修改分类</cite></a>
				        </span>
				    </blockquote>
   
    
    <div class="layui-row">
        <div class="layui-col-md4">
            <form class="layui-form"  method="post" id="myForm" action="category/update/${category.getCategoryId()}">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>修改分类</strong>
                    </div>
                    <div class="layui-input-block">
                        名称 <span style="color: #FF5722; ">*</span>
                        <input type="text" name="categoryName" value="${category.getCategoryName()}" autocomplete="off" class="layui-input" required>
                    </div>
                  
                    <div class="layui-input-block">
                        分类描述
                        <input type="text" name="categoryDescription" value="${category.getCategoryDescription()}" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        图标样式
                        <input type="text" name="categoryIcon" value="${category.getCategoryIcon()}" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-filter="formDemo" type="submit">修改</button>
                    </div>
                </div>
            </form>
       
				</rapid:override>
		
	
<%@ include file="../framework.jsp" %>