<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
				<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
											
				<rapid:override name="frame-header-style">
					<link rel="stylesheet" href="static/css/index-page.css">
				</rapid:override>
				
				<rapid:override name="frame-content"  >
			<!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a  href="admin">首页</a>
              <a><cite>评论列表</cite></a>
        </span>
    </blockquote>
    <div class="layui-tab layui-tab-card">
        <table class="layui-table" lay-even lay-skin="nob">
            <colgroup>
                <col width="100">
                <col width="300">
                <col width=200">
                <col width="150">
                <col width="50">
            </colgroup>
            <thead>
            <tr>
                <th>作者</th>
                <th>评论内容</th>
                <th>回复至</th>
                <th>提交于</th>
                <th>ID</th>
            </tr>
            </thead>
            <tbody>
             <c:forEach var="a" items="${commentList}">
            <tr>
                    <td>
                        <img src="http://tie.027cgb.com/631114/2ea282c186df8a15b254409f04e53fc0.jpg" alt="" width="64px">
                        <strong>${a.getCommentPname()}</strong>
                        <br>
                            ${a.getCommentAuthorUrl()}<br>
                            ${a.getCommentAuthorEmail()}<br>
                            </td>
                    <td class="dashboard-comment-wrap">
                        <span class="at">@ </span><a >${a.getCommentAuthorName()}</a>
                        ${a.getCommentContent()}<div class="row-actions">
                                    
                        </div>
                    </td>
                    <td>
                        <a href="article"
                           target="_blank">${a.getArticle().getArticleTitle()}</a>
                    </td>
                    <td>
                        ${a.getCommentCreateTime()}</td>
                    <td>${a.getCommentId()}</td>

                </tr>
          </c:forEach>
            </tbody>

        </table>

        <div id="nav" style="">
            <nav class="navigation pagination" role="navigation">
        
    </nav>
    </div>
    </div>


</div>
				</rapid:override>
				
					<%@ include file="../framework.jsp" %>