<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
				<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
					<html>
					<link rel="shortcut icon" href="static/img/logo.png">
				<link rel="stylesheet" href="static/plugin/layui/css/layui.css">
				<link rel="stylesheet" href="static/css/back.css">
				<link rel="stylesheet" href="static/plugin/font-awesome/css/font-awesome.min.css">
					<head>
					<style type="text/css">
					#left{float:left;
					
					width:10%;
					height:100%;
					
					position : relative ;}
					#article{
					float:left;
					
					width:75%;
				background:#ffffff;
					}
					#title{
					height:5%;
					
					background:url("http://pic.027cgb.com/631114/RU_7K_%7DA%5B%7B21KELT58(6X)Y.png");
					}
					p{color:green;
					font-size:20px;}
					#right{
					float:left;
					width:15%;
				
					position : relative ;
				
					}
					table{width:80%;
					}
					td{
border:none;
}
					</style>
					</head>
					<body style="background-size:100% 100%;
background-attachment: fixed;background-position: 0px 0px; background: url('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595840633264&di=f5c22c59de95d2c9bfc0d0d574b0f58a&imgtype=0&src=http%3A%2F%2Fwww.waibao123.com%2FUploads%2Fphoto%2F2014-07-04%2F4b9180ad9c55d749666ee7bbca482ab0_big.png'); background-repeat: repeat;">
					<div id="title">
					<table align="center">
					<tr>
					<td><p>简易博客</p>
</td>
     <td> <form id='search_form' class='navbar-search' action="/ssm-blog-luohongde/article/search">
        <input type='text' id='q' name='q' class='search-query span3' value="搜索"/>
      </form></td>
        <td><a href="/ssm-blog-luohongde/article/blog">首页</a></td>
        
        <td><a href="https://gitee.com/luohongde/ssm-bolg-luohongde.git" target="_Blank">码云地址</a></td>
        
           <td><a href="/ssm-blog-luohongde/Link/show" target="_Blank">链接</a></td>
        <td><a href="/ssm-blog-luohongde/jsp/home/lianxi.jsp" target="_blank">联系我</a></td>
        <td><a href='/ssm-blog-luohongde/jsp/login.jsp'>登录</a></td>
        
	  </tr>
	  </table>
					</div>
					<div id="left">&nbsp;</div>
				<div class="layui-tab layui-tab-card" id="article">
					     <span class="layui-breadcrumb" lay-separator="/">
              <span>浏览次数：${article.getArticleViewCount() }</span>
        </span>
						<p align="center">${article.getArticleTitle()}</p><br/>
						<span>${article.getArticleContent() }</span><br/>
						<span>浏览次数：${article.getArticleViewCount() }</span>
					</div>


					</body>
					</html>
					