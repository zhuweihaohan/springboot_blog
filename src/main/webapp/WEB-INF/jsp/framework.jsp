<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
				<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
				<%
					String path = request.getContextPath();
					String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
				%>
				
				<!DOCTYPE HTML>
				<html lang="zh-CN">
				<head>
				<base href="<%=basePath%>">
				
				<title  href="admin">博客后台</title>
				
				<meta http-equiv="pragma" content="no-cache">
				<meta http-equiv="cache-control" content="no-cache">
				<meta http-equiv="expires" content="0">
				<meta charset="utf-8">
				<link rel="shortcut icon" href="static/img/logo.png">
				<link rel="stylesheet" href="static/plugin/layui/css/layui.css">
				<link rel="stylesheet" href="static/css/back.css">
				<link rel="stylesheet" href="static/plugin/font-awesome/css/font-awesome.min.css">
				
				<!-- 留给别的页面去覆盖,让其他页面能引入自已的css或js -->
				<rapid:block name="frame-header-style"></rapid:block>
				<rapid:block name="frame-header-script"></rapid:block>
				
				</head>
				
				<body>
					<div class="layui-layout layui-layout-admin">
						<div class="layui-header">
							<div class="layui-logo">
								<a  href="/article/blog" style="color: #009688;"> 博客前台</a>
							</div>
							<!-- 头部区域（可配合layui已有的水平导航） -->
							<ul class="layui-nav layui-layout-left">
								<!-- <li class="layui-nav-item"><a href="/" target="_blank">前台</a></li> -->
								<li class="layui-nav-item"><a href="javascript:;">新建</a>
									<dl class="layui-nav-child">
										<dd>
											<a href="/article/insert">文章</a>
										</dd>
										<!-- <dd>
											<a href="jsp/Page/addPage.jsp">页面</a>
										</dd> -->
										<dd>
											<a href="/category">分类</a>
										</dd>
										<dd>
											<a href="/Notice/add">公告</a>
										</dd>
<%--										<dd>--%>
<%--											<a href="jsp/Link/addLink.jsp">链接</a>--%>
<%--										</dd>--%>
									</dl></li>
							</ul>
							<ul class="layui-nav layui-layout-right">
								<li class="layui-nav-item"><a href="javascript:;">
										 <img src="static/img/touxiang.jpg" class="layui-nav-img">
										admin
								</a>
									<dl class="layui-nav-child">
										<dd>
											<a href="admin/userForOne">基本资料</a>
										</dd>
									</dl></li>
								<li class="layui-nav-item"><a href="/admin/logout">退出</a></li>
							</ul>
						</div>
				
						<div class="layui-side layui-bg-black">
							<div class="layui-side-scroll">
								<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
								<ul class="layui-nav layui-nav-tree" lay-filter="test">
									<li class="layui-nav-item layui-nav-itemed"><a class=""
										href="javascript:;">文章</a>
										<dl class="layui-nav-child">
											<dd>
												<a href="article">全部文章</a>
											</dd>
											<dd>
												<a href="article/insert">写文章</a>
											</dd>
											<dd>
												<a href="category">全部分类</a>
											</dd>
											<dd>
												<a href="admin/tag-list">全部标签</a>
											</dd>
										</dl></li>
									 <li class="layui-nav-item"><a href="javascript:;">网站概览</a>
										<dl class="layui-nav-child">
											<dd>
												<a href="admin/visit_list">访问记录</a>
											</dd>
											<dd>
												<a href="admin/ip_list">访问IP</a>
											</dd>
										</dl></li>
									<!-- <li class="layui-nav-item"><a href="javascript:;">页面</a>
										<dl class="layui-nav-child">
											<dd>
												<a href="/ssm-blog-luohongde/jsp/Page/Page.jsp">全部页面</a>
											</dd>
											<dd>
												<a href="/ssm-blog-luohongde/jsp/Page/addPage.jsp">添加页面</a>
											</dd>
										</dl></li> -->
<%--									<li class="layui-nav-item"><a class="" href="javascript:;">--%>
<%--											链接 </a>--%>
<%--										<dl class="layui-nav-child">--%>
<%--											<dd>--%>
<%--												<a href="Link">全部链接</a>--%>
<%--											</dd>--%>
<%--											<dd>--%>
<%--												<a href="/ssm-blog-luohongde/jsp/Link/addLink.jsp">添加链接</a>--%>
<%--											</dd>--%>
<%--										</dl></li>--%>
									<li class="layui-nav-item"><a href="javascript:;">公告</a>
										<dl class="layui-nav-child">
											<dd>
												<a href="admin/Notice">全部公告</a>
											</dd>
											<dd>
												<a href="Notice/add">添加公告</a>
											</dd>
										</dl></li>
<%--									<li class="layui-nav-item"><a href="article/Comment"> 评论 </a></li>--%>
									<li class="layui-nav-item"><a class="" href="javascript:;">
											用户 </a>
										<dl class="layui-nav-child">
											<dd>
												<a href="admin/user" >全部用户</a>
											</dd>
											<dd>
												<a href="admin/add">添加用户</a>
											</dd>
										</dl></li>
<%--									<li class="layui-nav-item"><a href="javascript:;">设置</a>--%>
<%--										<dl class="layui-nav-child">--%>
<%--											<dd>--%>
<%--												<a href="/ssm-blog-luohongde/jsp/Menu.jsp">菜单</a>--%>
<%--											</dd>--%>
<%--											<dd>--%>
<%--												<a href="/ssm-blog-luohongde/jsp/Main.jsp">主要选项</a>--%>
<%--											</dd>--%>
<%--										</dl></li>--%>
								</ul>
							</div>
						</div>
				
						<div class="layui-body">
							<div style="padding: 15px;">
								<!-- 主体内容,要留给别的页面覆盖 -->
								<rapid:block name="frame-content">
									内容主体区域,不同的页面要分别进行不同的编写
								</rapid:block>
							</div>
				 		</div>
				
						<div class="layui-footer">
							<!-- 底部固定区域 -->
							回到首页 <a href="#" target="_blank">首页</a>
						</div>
					</div>
				
					<script src="static/js/jquery.min.js"></script>
					<script src="static/plugin/layui/layui.all.js"></script>
					<script src="static/js/back.js"></script>
				
					<!-- 留给别的页面去覆盖,让它们可以引入自已的js -->
					<rapid:block name="frame-footer-script"></rapid:block>
				
				</body>
				</html>