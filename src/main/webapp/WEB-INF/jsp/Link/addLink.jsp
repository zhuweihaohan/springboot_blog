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
              <a >链接列表</a>
              <a><cite>添加链接</cite></a>
        </span>
    </blockquote>
    <div class="layui-row">
        <div class="layui-col-md4">
            <form class="layui-form" method="post" id="myForm" action="Link/insert">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>编辑链接</strong>
                    </div>
                    <input type="hidden" name="linkId" value="">
                    <div class="layui-input-block">
                        名称 <span style="color: #FF5722; ">*</span>
                        <input type="text" name="linkName" value="" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        URL <span style="color: #FF5722; ">*</span>
                        <input type="text" name="linkUrl" value="" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        联系方式
                        <input type="text" name="linkOwnerContact" value="" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        描述
                        <input type="text" name="linkDescription" value="" autocomplete="off" class="layui-input" >
                    </div>

                    <br>
                    <div class="layui-input-block">
                         Order
                        <input type="number" name="linkOrder" value="" autocomplete="off" class="layui-input" min="0" max="10">
                    </div>
                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-filter="formDemo" type="submit">添加</button>
                    </div>
                </div>
            </form>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>URL：如 http://liuyanzhao.com</li>
                    <li>Order：默认是0，Order越大排名越靠前</li>
                </ul>
            </blockquote>
        </div>
       
    </div>
</div>
				</rapid:override>
		
	
<%@ include file="../framework.jsp" %>