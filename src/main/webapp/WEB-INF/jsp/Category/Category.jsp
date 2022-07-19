<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
				<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
											
				<rapid:override name="frame-header-style">
					<link rel="stylesheet" href="static/css/index-page.css">
				</rapid:override>
				
				<rapid:override name="frame-content"  >
				
        <!-- 内容主体区域 -->
        <div style="padding:15px;">
            <blockquote class="layui-elem-quote">
				        <span class="layui-breadcrumb" lay-separator="/">
				              <a  href="admin">首页</a>
				              <a >分类列表</a>
				              <a><cite>添加分类</cite></a>
				        </span>
				    </blockquote>
   
    
    <div class="layui-row">
        <div class="layui-col-md4">
            <form class="layui-form"  method="post" id="myForm" action="category/insert">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>添加分类</strong>
                    </div>
                    <div class="layui-input-block">
                        名称 <span style="color: #FF5722; ">*</span>
                        <input type="text" name="categoryName" placeholder="请输入分类名称" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        父节点 <span style="color: #FF5722; ">*</span>
                        <select name="categoryPid" class="layui-input" required>
                           <option value="0">无</option>
                          <c:forEach items="${categoryList}" var="x">
	                  <c:if test="${x.categoryPid==0}">
                           
                            <option value="${x.getCategoryId()}">${x.getCategoryName()}</option>
                             
                                  </c:if>
	                      </c:forEach> 
                                </select>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        分类描述
                        <input type="text" name="categoryDescription" placeholder="请输入分类描述" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        图标样式
                        <input type="text" name="categoryIcon" placeholder="请输入图标样式,如 fa fa-coffee" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-filter="formDemo" type="submit">添加</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="layui-col-md8" >
            <table class="layui-table" >
                <colgroup>
                    <col width="300">
                    <col width="100">
                    <col width="100">
                    <col width="100">
                    <col width="50">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th>名称</th>
                    <th>文章数</th>
                    <th>操作</th>
                    <th>ID</th>
                    <th>pid</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categoryList}" var="c">
	                  <c:if test="${c.categoryPid==0}">
	                      <tr>
	                          <td>
	                              <a href="https://www.baidu.com/s?wd=${c.categoryName}" target="_blank">${c.categoryName}</a>
	                          </td>
	                          <td>
	                              <a  target="_blank">${c.articleCount}</a>
	                          </td>
	                          <td>
	                              <a href="category/edit/${c.categoryName}" class="layui-btn layui-btn-mini">编辑</a>
	                              
	                                      <c:if test="${c2.articleCount==0}">
	                                      <a  href="category/deleteCategory/${c2.categoryId}" 	class="layui-btn layui-btn-danger layui-btn-mini" 	onclick="return confirmDelete()">删除</a>
	                                      </c:if>
	                              <c:if test="${c.articleCount==0}">
	                                  <a href="category/deleteCategory/${c.categoryId}" class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
	                              </c:if>
	                          </td>
	                          <td>${c.categoryId}</td>
	                          <td>${c.categoryPid}</td>
	                      </tr>
	                      <c:forEach items="${categoryList}" var="c2">
	                          <c:if test="${c2.categoryPid==c.categoryId}">
	                              <tr>
	                                  <td>
	                                      <a href="https://www.baidu.com/s?wd=${c2.categoryName}" target="_blank">——${c2.categoryName}</a>
	                                  </td>
	                                  <td>
	                                      <a  target="_blank">${c2.articleCount}</a>
	                                  </td>
	                                  <td>
	                                      <a href="category/edit/${c2.categoryName}" class="layui-btn layui-btn-mini">编辑</a>
	                               
	                                      <c:if test="${c2.articleCount==0}">
	                                      <a  href="category/deleteCategory/${c2.categoryId}" 	class="layui-btn layui-btn-danger layui-btn-mini" 	onclick="return confirmDelete()">删除</a>
	                                      </c:if>
	                                  </td>
	                                  <td class="cate-parent">${c2.categoryId}</td>
	                                  <td>${c2.categoryPid}</td>
	                              </tr>
	                          </c:if>
	                      </c:forEach>
	                  </c:if>
	
	
	              </c:forEach>
                            </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>分类最多只有两级，一级分类pid=0，二级分类pid=其父节点id</li>
                    <li>分类包含文章的不可删除</li>
                </ul>
            </blockquote>
        </div>
    </div>






</div>
    </div>
				</rapid:override>
			<script >
	 var msg="${msg}";
	if(msg!="")
	 alert(msg);
	</script>		
<%@ include file="../framework.jsp" %>