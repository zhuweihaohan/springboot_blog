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
              <a><cite>链接列表</cite></a>
        </span>
    </blockquote>

    <table class="layui-table" >
        <colgroup>
            <col width="100">
            <col width=50">
            <col width="100">
            <col width="100">
            <col width="50">
            <col width="50">
            <col width="100">
            <col width="50">
        </colgroup>
        <thead>
        <tr>
            <th>名称</th>
            <th>URL</th>
            <th>联系方式</th>
            <th>创建时间</th>
            <th>状态</th>
            <th>操作</th>
            <th>ID</th>
        </tr>
        </thead>
        <tbody>
         <c:forEach var="a" items="${linkList}">
        <tr>
                <td>
                    ${a.getLinkName()}</td>
                <td >
                    <a href="${a.getLinkUrl()}" target="_blank">${a.getLinkUrl()}</a>
                </td>
                <td>
                 ${a.getLinkOwnerContact()}</td>
                <td>
                  <fmt:formatDate value="${a.getLinkCreateTime()}" pattern="yyyy/MM/dd hh:mm:ss"/>  
               
                <td>
                <c:choose>
										<c:when test="${a.getLinkStatus()==0}">
											<span style="color: #FF5722;">禁用</span>
										</c:when>
										<c:otherwise>
				                    			   正常
				                 		   </c:otherwise>
									</c:choose>
                        </td>
                <td>
                    <a href="Link/edit/${a.getLinkId()}" class="layui-btn layui-btn-mini">编辑</a>
 <a  href="Link/deleteLink/${a.getLinkId()}" 	class="layui-btn layui-btn-danger layui-btn-mini" 	onclick="return confirmDelete()">删除</a>
                </td>
                <td> ${a.getLinkId()}</td>
            </tr>
</c:forEach>
     

        </tbody>
    </table>





</div>
				</rapid:override>
		
	
<%@ include file="../framework.jsp" %>