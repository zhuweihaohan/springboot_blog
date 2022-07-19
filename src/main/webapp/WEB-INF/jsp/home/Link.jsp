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
				font-size:white;
					width:10%;
					height:100%;
					
					position : relative ;}
					#article{
				algin:center;
					
					width:65%;
				
				/* background:#D8D8D8; *//* url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595840633264&di=f5c22c59de95d2c9bfc0d0d574b0f58a&imgtype=0&src=http%3A%2F%2Fwww.waibao123.com%2FUploads%2Fphoto%2F2014-07-04%2F4b9180ad9c55d749666ee7bbca482ab0_big.png"); */
					}
					#aandr{
					float:left;
				
					width:10%;
					height:100%;
					
					position : relative ;
					}
					#title{
					height:5%;
					background:url("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3385125687,2419799288&fm=26&gp=0.jpg");
					width:100%;
					}
					p{color:green;
					font-size:20px;}
					#right{
					float:left;
					width:15%;
					height:100%;
				background-color:#C7C7E2;
					position : relative ;
				
					}
					table{width:80%;
					}
					td{
border:none;
}
					</style>
					</head>
<body style="background-position: 0px 0px; background:#F5FBEF;  background-repeat: repeat;">
					
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
					
				
						<div class="layui-tab layui-tab-card" id="article">
					<form id="articleForm" method="post" >		
								
				<c:forEach var="l" items="${links}">
				<table align="center"  border="solid">
				
						
							
					
							<tr><td><a href="${l.getLinkUrl()}"><p align="center">${l.getLinkName() }</p> </a></td></tr>
							<tr>
							<td><p >创建时间：<fmt:formatDate value="${l.getLinkCreateTime() }" pattern="yyyy/MM/dd"/></p></td></tr>
             <tr><td><a >概要：${l.linkDescription}</a></td></tr>
          
          <tr><br></tr>
          <tr><br></tr>

								<!--
								<td><a href="show/${a.articleId }" target="_blank"> ${a.articleTitle }</a></td>
								<td>
								<c:forEach var="c" items="${a.categoryList}">
								
									<a href="category" target="_blank">${c.getCategoryName()}</a>
									&nbsp;&nbsp;
								
								 </c:forEach>
								  </td>
								<td>
									<a > 
										<c:if test="${a.articleStatus==1 }">
											<span style="color: #5FB878;">已发布</span>
										</c:if>
										<c:if test="${a.articleStatus==0 }">
											<span style="color: RED;">草稿</span>
										</c:if>
								    </a>
								 </td>
								<td> <fmt:formatDate value="${a.articleCreateTime }" pattern="yyyy/MM/dd hh:mm:ss"/>  </td>
								
								<td>${a.articleId}</td>
							</tr>-->
					</c:forEach>
								
								
							</table>
						</form>
						
						
					</div>

</body></html>