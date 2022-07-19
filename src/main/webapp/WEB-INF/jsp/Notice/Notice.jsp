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
          <a><cite>公告列表</cite></a>
        </span>
    </blockquote>


            <table class="layui-table" >
                <colgroup>
                    <col width="400">
                    <col width="50">
                    <col width="100">
                    <col width="100">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th>标题</th>
                    <th>Order</th>
                    <th>状态</th>
                    <th>操作</th>
                    <td>ID</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="a" items="${noticeList}">
                <tr>
                        <td>
                            <a  target="_blank">${a.getNoticeTitle()}</a>
                        </td>
                        <td>
                              ${a.getNoticeOrder()}</td>
                        <td>
             <c:choose>
										<c:when test="${a.getNoticeStatus()==0}">
											<span style="color: #FF5722;">禁用</span>
										</c:when>
										<c:otherwise>
				                    			   正常
				                 		   </c:otherwise>
									</c:choose>
                                </td>
                        <td>
                        <a href="admin/editNotice/${a.getNoticeId()}"
                               class="layui-btn layui-btn-mini">编辑</a>
                            <a href="admin/deleteNotice/${a.getNoticeId()}" class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
                        </td>
                        <td >${a.getNoticeId()}</td>
                    </tr>
</c:forEach>
              
                </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>Order的大小决定显示的顺序</li>
                </ul>
            </blockquote>


</div>
				</rapid:override>
				
				<%@ include file="../framework.jsp" %>