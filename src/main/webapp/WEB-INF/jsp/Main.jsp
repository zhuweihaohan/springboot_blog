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
          <a >首页</a>
          <a><cite>基本信息</cite></a>
        </span>
    </blockquote>
    <form class="layui-form" action="/ssm-blog-luohongde/jsp/Main.jsp" method="post">

    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
        <ul class="layui-tab-title">
            <li class="layui-this">基本信息</li>
           
        </ul>
        <div class="layui-tab-content">
            <br><br>
            <input type="hidden" name="optionId" value="1">
                <div class="layui-tab-item layui-show">
                <div class="layui-form-item">
                    <label class="layui-form-label">站点名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="optionSiteTitle"  value="风吟博客"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">站点描述</label>
                    <div class="layui-input-block">
                        <input type="text" name="optionSiteDescrption"   value="莫问收获，但问耕耘。"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">首页描述</label>
                    <div class="layui-input-block">
                        <input type="text" name="optionMetaDescrption"  value="风吟博客,一个简洁的Java博客,言曌程序学习的一个新起点。"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">首页关键词</label>
                    <div class="layui-input-block">
                        <input type="text" name="optionMetaKeyword"  value="风吟,风吟博客,Java博客,SSM博客,言曌,言曌博客"   autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-tab-item">
                <div class="layui-form-item">
                    <label class="layui-form-label">头像</label>
                    <div class="layui-input-inline">
                        <div class="layui-upload">
                            <div class="layui-upload-list" style="">
                                <img class="layui-upload-img" src="/uploads/2018/11/avatar(3).jpg" id="demo1" width="100"
                                     height="100">
                                <p id="demoText"></p>
                            </div>
                            <button type="button" class="layui-btn" id="test1">上传图片</button>
                            <input type="hidden" id="optionAboutsiteAvatar" name="optionAboutsiteAvatar" value="/uploads/2018/11/avatar(3).jpg">
                        </div>
                    </div>
                    <div class="layui-form-mid layui-word-aux">建议 150px*150px</div>

                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">昵称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="optionAboutsiteTitle"   value="博客初心"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">说明</label>
                    <div class="layui-input-block">
                        <input type="text" name="optionAboutsiteContent"   value="程序人生，永不止步"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">微信二维码</label>
                    <div class="layui-input-inline">
                        <div class="layui-upload">
                            <div class="layui-upload-list" style="">
                                <img class="layui-upload-img" src="/uploads/2017/10/20171006224906122.jpg" id="demo2" width="100"
                                     height="100">
                                <p id="demoText2"></p>
                            </div>
                            <button type="button" class="layui-btn" id="test2">上传图片</button>
                            <input type="hidden" id="optionAboutsiteWechat" name="optionAboutsiteWechat" value="/uploads/2017/10/20171006224906122.jpg">
                        </div>
                    </div>
                    <div class="layui-form-mid layui-word-aux">建议 430px*430px</div>

                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">QQ</label>
                    <div class="layui-input-inline">
                        <input type="text" name="optionAboutsiteQq"   value="847064370"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">微博</label>
                    <div class="layui-input-inline">
                        <input type="text" name="optionAboutsiteWeibo"  value="5936412667"    autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">Github</label>
                    <div class="layui-input-inline">
                        <input type="text" name="optionAboutsiteGithub"  value="saysky"   autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
        </div>

    </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">保存设置</button>
            </div>
        </div>
    </form>




</div>
				</rapid:override>
		
	
 <%@ include file="framework.jsp" %>