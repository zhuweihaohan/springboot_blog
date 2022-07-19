<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
				<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
					<html>
					
				
					<head>
						<link rel="stylesheet" href="../static/css/index.css">
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
					<div id="left"><div>站内公告</div>
    <hr/>
    <div id="demo" style="OVERFLOW: hidden; height: 20px;">
        <div id="marquePic1">
        <c:forEach var="no" items="${notice}">
							${no.getNoticeTitle()}<br>
								
								 </c:forEach>    
        </div>
        <div id="marquePic2" valign="top">
        </div>
    </div>
    
    
    </div>
				<div class="layui-tab layui-tab-card" id="article">
					<form id="articleForm" method="post" >		
								
				<c:forEach var="a" items="${pageInfo.list}">
				<table align="center"  border="solid">
				
						
							
					
							<tr><td><a href="show/${a.articleId}"><p align="center">${a.articleTitle }</p> </a></td></tr>
							<tr>
							<td><p >创建时间：<fmt:formatDate value="${a.articleCreateTime }" pattern="yyyy/MM/dd"/></p></td></tr>
             <tr><td><a href="show/${a.articleId}">概要：${a.articleSummary }</a></td></tr>
          <tr><td>  属于 标签：<a><c:forEach var="t" items="${a.tagList}">
								
									<a href="/ssm-blog-luohongde/article/findTag/${t.getTagName()}" target="_blank">${t.getTagName()}</a>
									&nbsp;&nbsp;
								
								 </c:forEach></a> 分类:<a><c:forEach var="c" items="${a.categoryList}">
								
									<a href="/ssm-blog-luohongde/category/find/${c.getCategoryName()}" target="_blank">${c.getCategoryName()}</a>
									&nbsp;&nbsp;
								
								 </c:forEach></a></td></tr>
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
						<nav class="navigation pagination" role="navigation">
							<div class="nav-links">
								<%@ include file="../page.jsp" %>
							</div>
						</nav>
						</table>
					</div>

<div id="aandr">&nbsp;</div>
					<div id="right">
					
<ul>热门文章</ul>
<c:forEach var="hot" items="${hotList}">
			<li>
				
							<a href="show/${hot.articleId}" target="">${hot.getArticleTitle()}</a> 
									
								</li>
								 </c:forEach>
<br/>
<br/>
					<table align="center">
<tr>分类如下</tr><br>
<c:forEach var="c1" items="${categoryList1}">
			<tr>					
									<a href="/ssm-blog-luohongde/category/find/${c1.getCategoryName()}" target="_blank">${c1.getCategoryName()}</a>
									&nbsp;&nbsp;
								</tr>
								 </c:forEach>
</table>
<table align="center">
<tr>标签如下</tr><br>
<c:forEach var="t1" items="${tagList}">
			<tr>					
									<a href="/ssm-blog-luohongde/article/findTag/${t1.getTagName()}" target="_blank">${t1.getTagName()}</a>
									&nbsp;&nbsp;
								</tr>
								 </c:forEach>
</table>
</div>
</body>
					</html>
					<script type="text/javascript">
    //纵向滚动 需要设置div的高度
    var speed=100
    marquePic2.innerHTML=marquePic1.innerHTML
    function Marquee(){
        if(demo.scrollTop>=marquePic1.scrollHeight){
            demo.scrollTop=0
        }else{
            demo.scrollTop++
        }
    }
    var MyMar=setInterval(Marquee,speed)
    demo.onmouseover=function() {clearInterval(MyMar)}
    demo.onmouseout=function() {MyMar=setInterval(Marquee,speed)}
</script>