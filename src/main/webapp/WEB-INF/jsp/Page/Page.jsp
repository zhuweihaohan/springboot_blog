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
          <a><cite>页面列表</cite></a>
        </span>
    </blockquote>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>页面列表</legend>
    </fieldset>
    <form id="pageForm" method="post">
        <table class="layui-table">
            <colgroup>
                <col width="50">
                <col width="50">
                <col width="100">
                <col width="200">
                <col width="50">
                <col width="100">
            </colgroup>
            <thead>
            <tr>
                <th>id</th>
                <th>key</th>
                <th>标题</th>
                <th>内容</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                        <td>5</td>
                        <td>aboutSite</td>
                        <td>
                            关于本站</td>
                        <td>
                            <a href="/aboutSite"
                               target="_blank">
                                    <h2>关于项目</h2><p>该项目是</a>
                        </td>
                        <td>
                            
                                    显示
                                </td>
                        <td>
                            <a href="/admin/page/edit/5"
                               class="layui-btn layui-btn-mini">编辑</a>
                            <a href="/admin/page/delete/5"
                               class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
                        </td>
                    </tr>
                <tr>
                        <td>7</td>
                        <td>hello</td>
                        <td>
                            11</td>
                        <td>
                            <a href="/hello"
                               target="_blank">
                                    11111111</a>
                        </td>
                        <td>
                            
                                    显示
                                </td>
                        <td>
                            <a href="/admin/page/edit/7"
                               class="layui-btn layui-btn-mini">编辑</a>
                            <a href="/admin/page/delete/7"
                               class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
                        </td>
                    </tr>
                </tbody>
        </table>
    </form>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>自定义页面</legend>
    </fieldset>
    <div class="layui-form">
        <table class="layui-table" style="width: 40%;">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>别名</th>
                <th>标题</th>
                <th>内容</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                            <td>map</td>
                            <td>站点地图</td>
                            <td><a href="/map" target="_blank">点击查看</a></td>
                        </tr>
                    <tr>
                            <td>articleFile</td>
                            <td>文章归档</td>
                            <td><a href="/articleFile" target="_blank">点击查看</a></td>
                        </tr>
                    <tr>
                            <td>message</td>
                            <td>留言板</td>
                            <td><a href="/message" target="_blank">点击查看</a></td>
                        </tr>
                    <tr>
                            <td>applyLink</td>
                            <td>申请友链</td>
                            <td><a href="/applyLink" target="_blank">点击查看</a></td>
                        </tr>
                    </tbody>
        </table>
    </div>


    <blockquote class="layui-elem-quote layui-quote-nm">
        温馨提示： <br>
        1、自定义的页面，无法删除，别名已写入控制器
    </blockquote>
</div>
      
				</rapid:override>
		
	
<%@ include file="../framework.jsp" %>