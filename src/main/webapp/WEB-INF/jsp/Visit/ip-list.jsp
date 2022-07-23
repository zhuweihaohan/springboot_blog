<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
					<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
					<rapid:override name="frame-content">
					<blockquote class="layui-elem-quote">
						<span class="layui-breadcrumb" lay-separator="/"> <a
							 href="admin">首页</a> <a><cite>ip记录</cite></a>
						</span>
					</blockquote>

					<div class="layui-tab layui-tab-card">
						<form id="articleForm" method="post" >
							<input type="hidden" name="currentUrl" id="currentUrl" value="">
							<table class="layui-table">
								<colgroup>
									<col width="300">
									<col width="150">
									<col width="100">
									<col width="150">
									<col width="100">
									<col width="50">
								</colgroup>
								<thead>
									<tr>
										<th>IP</th>
										<th>访问次数</th>
										<th>ip属地</th>
										<th>最后访问时间</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="a" items="${pageInfo.list}">
							<tr>
								<td><span style="color: #5FB878;" >${a.ip }</span> </td>
								<td> ${a.count }</td>
								<td>${a.site} </td>
								<td> ${a.lastVistTime } </td>

							</tr>
					</c:forEach>

								</tbody>
							</table>
						</form>
						<nav class="navigation pagination" role="navigation">
							<div class="nav-links">
								<%@ include file="../Public/paging.jsp" %>
							</div>
						</nav>
					</div>
					</rapid:override>

					<%@ include file="../framework.jsp" %>