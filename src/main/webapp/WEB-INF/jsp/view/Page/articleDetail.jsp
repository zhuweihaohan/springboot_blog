<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    <title>${article.articleTitle}</title>
</rapid:override>

<rapid:override name="header-style">
    <rapid:override name="header-style">
        <link rel="stylesheet" href="/static/css/highlight.css">
        <style>
            .entry-title {
                background: #f8f8f8;
            }
        </style>
    </rapid:override>
</rapid:override>

<rapid:override name="breadcrumb">
    <%--面包屑导航 start--%>
    <nav class="breadcrumb">
        <a class="crumbs" href="/article/blog">
            <i class="fa fa-home"></i>首页
        </a>
        <c:choose>
            <c:when test="${article.categoryList != null && article.categoryList.size() > 0}" >
                <c:forEach items="${article.categoryList}" var="c">
                    <i class="fa fa-angle-right"></i>
                    <a href="/category/find/${c.getCategoryName()}">
                            ${c.categoryName}
                    </a>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <i class="fa fa-angle-right"></i>
                <a>未分类</a>
            </c:otherwise>
        </c:choose>
        <i class="fa fa-angle-right"></i>
        正文
    </nav>
    <%--面包屑导航 end--%>
</rapid:override>


<rapid:override name="left">
    <%--博客主体-左侧文章正文 start--%>
    <div id="primary" class="content-area">
        <main id="main" class="site-main" role="main">
            <article class="post" id="articleDetail" data-id="${article.articleId}">
                <header class="entry-header">
                    <h1 class="entry-title">
                            ${article.articleTitle}
                    </h1>
                </header><!-- .entry-header -->
                <div class="entry-content">
                    <div class="single-content">
                            ${article.articleContent}
                    </div>

                    <div class="clear"></div>
                    <div id="social">
                        <div class="social-main">
                            <span class="like">
                            
                                <a href="/article/like/${article.articleId}" data-action="ding" data-id="1" title="点赞"
                                   class="favorite" >
                                    <i class="fa fa-thumbs-up"></i>赞
                                    <i class="count"
                                       id="count-${article.articleId}">${article.articleLikeCount}</i>
                                </a>
                            </span>
                            <div class="shang-p">
                                <div class="shang-empty"><span></span></div>
                                <span class="shang-s">
                                    <a onclick="PaymentUtils.show();" style="cursor:pointer">赏</a>
                                </span>
                            </div>
                            <div class="share-sd">
                                        <span class="share-s" style="margin-top: 25px!important;">
                                            <a href="javascript:void(0)" id="share-s" title="分享">
                                                <i class="fa fa-share-alt"></i>分享
                                            </a>
                                        </span>
                                <div id="share">
                                    <ul class="bdsharebuttonbox bdshare-button-style1-16" data-bd-bind="1503997585792">
                                        <li><a title="更多" class="bds_more fa fa-plus-square" data-cmd="more"
                                               onclick="return false;" href="#"></a></li>
                                        <li><a title="分享到QQ空间" class="fa fa-qq" data-cmd="qzone" onclick="return false;"
                                               href="#"></a></li>
                                        <li><a title="分享到新浪微博" class="fa fa-weibo" data-cmd="tsina"
                                               onclick="return false;" href="#"></a></li>
                                        <li><a title="分享到腾讯微博" class="fa fa-pinterest-square" data-cmd="tqq"
                                               onclick="return false;" href="#"></a></li>
                                        <li><a title="分享到人人网" class="fa fa-renren" data-cmd="renren"
                                               onclick="return false;" href="#"></a></li>
                                        <li><a title="分享到微信" class="fa fa-weixin" data-cmd="weixin"
                                               onclick="return false;" href="#"></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>

                    <footer class="single-footer">
                        <ul class="single-meta">
                            <c:if test="${sessionScope.user!=null}">
                                <li class="edit-link">
                                    <a target="_blank" class="post-edit-link"
                                       href="/admin/article/edit/${article.articleId}">编辑</a>
                                </li>
                            </c:if>
                          
                            <li class="views">
                                <i class="fa fa-eye"></i> <span
                                    class="articleViewCount">${article.articleViewCount} </span>
                                views
                            </li>
                            <li class="r-hide">
                                <a href="javascript:pr()" title="侧边栏">
                                    <i class="fa fa-caret-left"></i>
                                    <i class="fa fa-caret-right"></i>
                                </a>
                            </li>
                        </ul>
                        <ul id="fontsize">
                            <li>A+</li>
                        </ul>
                        <div class="single-cat-tag">
                          <div class="single-cat">所属分类：
                                <c:forEach items="${article.getCategoryList()}" var="ca">
                                    <a href="/category/find/${ca.getCategoryName()}">
                                            ${ca.categoryName}
                                    </a>
                                </c:forEach>
                            </div> --%>
                        </div>
                    </footer>


                    <div class="clear"></div>
                </div><!-- .entry-content -->
            </article><!-- #post -->

                <%--所属标签 start--%>
       <div class="single-tag">所属标签：
                <ul class="" data-wow-delay="0.3s">
                    <c:forEach items="${article.tagList}" var="t">
                        <li>
                            <a href="/article/findTag/${t.getTagName()}" rel="tag"
                               style="background:#666666">
                                    ${t.tagName}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div> 
                <%--所属标签 end--%>


                <%--版权声明 start--%>
            <div class="authorbio wow fadeInUp">
                
                <ul class="postinfo">
                    <li></li>
<%--                    <li><strong>版权声明：</strong>本站原创文章，于<fmt:formatDate--%>
<%--                            value="${article.articleCreateTime}"--%>
<%--                            pattern="yyyy-MM-dd"/>，由--%>
<%--                        <strong>--%>
<%--                                ${article.user.userNickname}--%>
<%--                        </strong>--%>
<%--                        发表。--%>
<%--                    </li>--%>
                    <li class="reprinted"><strong>转载请注明出处哦</strong>
                
                    </li>
                </ul>
                <div class="clear"></div>
            </div>
                <%--版权声明 end--%>

               
            <div id="single-widget">
                <div class="wow fadeInUp" data-wow-delay="0.3s">
                    
                </div>
                <div class="clear"></div>
            </div>
              

                <%--评论区域 start--%>
           <%--  <div class="scroll-comments"></div>
            <div id="comments" class="comments-area">
                <div id="respond" class="comment-respond">
                    <h3 id="reply-title" class="comment-reply-title"><span id="reply-title-word">发表评论</span>
                        <a rel="nofollow" id="cancel-comment-reply-link"
                           href="/article/${article.articleId}#respond"
                           style="">取消回复</a>
                    </h3>
                    <form id="comment_form" method="post"> --%>
                       <%--  <c:if test="${sessionScope.user!=null}">
                            <div class="user_avatar">
                                <img alt="言曌"
                                     src="${sessionScope.user.userAvatar}"
                                     class="avatar avatar-64 photo" height="64" width="64">
                                登录者：${sessionScope.user.userNickname}
                                <br> <a href="javascript:void(0)" onclick="logout()">登出</a>
                                <input type="hidden" name="commentRole" value="1">
                                <input type="hidden" name="commentAuthorName"
                                       value="${sessionScope.user.getUserNickname()}">
                                <input type="hidden" name="commentAuthorEmail"
                                       value="${sessionScope.user.getUserEmail()}">
                                <input type="hidden" name="commentAuthorUrl" value="${sessionScope.user.getUserUrl()}">
                            </div>
                        </c:if> --%>
                       <%--  <p class="comment-form-comment">
                            <textarea id="comment" name="commentContent" rows="4" tabindex="1" required></textarea>
                        </p>
                        <div id="comment-author-info">
                            <input type="hidden" name="commentPid" value="0">
                            <input type="hidden" name="commentPname" value="">
                            <c:if test="${sessionScope.user == null}">
                                <input type="hidden" name="commentRole" value="0">
                                <p class="comment-form-author">
                                    <label for="author_name">
                                        昵称<span class="required">*</span>
                                    </label>
                                    <input type="text" name="commentAuthorName" id="author_name" class="" value=""
                                           tabindex="2" required>
                                </p>
                                <p class="comment-form-email">
                                    <label for="author_email">
                                        邮箱<span class="required">*</span>
                                    </label>
                                    <input type="email" name="commentAuthorEmail" id="author_email" class="" value=""
                                           tabindex="3" required>
                                </p>
                                <p class="comment-form-url">
                                    <label for="author_url">网址</label>
                                    <input type="url" name="commentAuthorUrl" id="author_url" class="" value=""
                                           tabindex="4">
                                </p>
                            </c:if>
                        </div>
                        <div class="clear"></div>
                         <p class="form-submit">
                            <input id="submit" name="submit" type="submit" tabindex="5" value="提交评论">
                            <input type="hidden" name="commentArticleId"
                                   value="${article.articleId}" id="article_id">
                            <input type="hidden" name="commentPid" id="comment_pid" value="0">
                        </p>
                    </form>
                </div> --%>
<%--
                <ol class="comment-list">
                    <c:set var="floor" value="0"/>
                    <c:forEach items="${commentList}" var="c">
                        <c:if test="${c.commentPid == 0}">
                            <c:set var="floor" value="${floor + 1}"/>
                            <li class="comments-anchor">
                                <ul id="anchor-comment-${c.commentId}"></ul>
                            </li>
                            <li class="comment">
                                <div id="div-comment-${c.commentId}" class="comment-body">
                                    <div class="comment-author vcard">
                                        <img class="avatar" src="${c.commentAuthorAvatar}" alt="avatar"
                                             style="display: block;">
                                        <strong>${c.commentAuthorName} </strong>
                                        <c:if test="${c.commentRole == 1}">
                                            <i class="fa fa-black-tie" style="color: #c40000;"></i>
                                            <span class=""
                                                  style="margin-top: 2px!important;color: #c40000;font-size: 13px;;"><b>博主</b></span>
                                        </c:if>
                                        <span class="comment-meta commentmetadata">
                                            <span class="ua-info" style="display: inline;">
                                                <br>
                                                <span class="comment-aux">
                                                    <span class="reply">
                                                        <a rel="nofollow" class="comment-reply-link" href="#respond"
                                                           onclick="replyComment()">回复
                                                        </a>
                                                    </span>
                                                    <fmt:formatDate value="${c.commentCreateTime}"
                                                                    pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;
                                                    <c:if test="${sessionScope.user != null}">
                                                        <a href="javascript:void(0)"
                                                           onclick="deleteComment(${c.commentId})">删除</a>
                                                        <a class="comment-edit-link"
                                                           href="/admin/comment/edit/${c.commentId}"
                                                           target="_blank">编辑</a>
                                                    </c:if>
                                                    <span class="floor"> &nbsp;${floor}楼 </span>
                                                </span>
                                            </span>
                                        </span>
                                        <p>
                                            <c:if test="${c.commentPid!=0}">
                                                <span class="at">@ ${c.commentPname}</span>
                                            </c:if>
                                                ${c.commentContent}
                                        </p>
                                    </div>
                                </div>
                                <ul class="children">
                                    <c:set var="floor2" value="0"/>
                                    <c:forEach items="${commentList}" var="c2">
                                        <c:if test="${c.commentId == c2.commentPid}">
                                            <c:set var="floor2" value="${floor2+1}"/>
                                            <li class="comments-anchor">
                                                <ul id="anchor-comment-${c2.commentId}"></ul>
                                            </li>
                                            <li class="comment">
                                                <div id="div-comment-${c.commentId}" class="comment-body">
                                                    <div class="comment-author vcard">
                                                        <img class="avatar" src="${c2.commentAuthorAvatar}" alt="avatar"
                                                             style="display: block;">
                                                        <strong>${c2.commentAuthorName} </strong>
                                                        <c:if test="${c2.commentRole==1}">
                                                            <i class="fa fa-black-tie" style="color: #c40000;"></i>
                                                            <span class=""
                                                                  style="margin-top: 2px!important;color: #c40000;font-size: 13px;;"><b>博主</b></span>
                                                        </c:if>
                                                        <span class="comment-meta">
                                                    <span class="ua-info" style="display: inline;">
                                                    <br>
                                                    <span class="comment-aux">
                                                        <span class="reply">
                                                            <a rel="nofollow" class="comment-reply-link" href="#respond"
                                                               onclick="replyComment()">回复
                                                            </a>
                                                        </span>
                                                        <fmt:formatDate value="${c2.commentCreateTime}"
                                                                        pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;
                                                        <c:if test="${sessionScope.user != null}">
                                                            <a href="javascript:void(0)"
                                                               onclick="deleteComment(${c2.commentId})">删除</a>
                                                            <a class="comment-edit-link"
                                                               href="/admin/comment/edit/${c2.commentId}"
                                                               target="_blank">编辑</a>
                                                        </c:if>
                                                        <span class="floor"> &nbsp;${floor2}层 </span>
                                                    </span>
                                                </span>
                                                    </span>
                                                        <p>
                                                            <c:if test="${c2.commentPid!=0}">
                                                                <c:if test="${c2.commentPid!=0}">
                                                                    <span class="at">@ ${c2.commentPname}</span>
                                                                </c:if>
                                                                ${c2.commentContent}
                                                            </c:if>
                                                        </p>
                                                    </div>
                                                </div>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:if>
                    </c:forEach>
                </ol>
            </div> --%>
                <%--评论框 end--%>

        </main>
        <!-- .site-main -->
    </div>
    <%--博客主体-左侧文章正文end--%>
</rapid:override>


<%--侧边栏 start--%>
<rapid:override name="right">
    <%@include file="../Public/part/sidebar-3.jsp" %>
</rapid:override>
<%--侧边栏 end--%>

<rapid:override name="footer-script">
    <script src="/static/js/jquery.cookie.js"></script>

    <script type="text/javascript">

        $(document).ready(function () {
            if ($('#author_name').val() == '') {
                var author = localStorage.getItem("author");
                $("#author_name").val(author == 'undefined' ? '' : author);
            }
            if ($('#author_email').val() == '') {
                var email = localStorage.getItem("email");
                $("#author_email").val(email == 'undefined' ? '' : email);
            }
            if ($('#author_url').val() == '') {
                var url = localStorage.getItem("url");
                $("#author_url").val(url == 'undefined' ? '' : url);
            }
        });

        var articleId = $("#articleDetail").attr("data-id");
        increaseViewCount(articleId);
        layui.code({
            elem: 'pre',//默认值为.layui-code
            // skin: 'notepad', //如果要默认风格，不用设定该key。
            about: false
        });

    </script>

</rapid:override>


<%@ include file="../Public/framework.jsp" %>
 <<script type="text/javascript">


 //打赏
(function ($) {
    var id = Date.now();
    if ($("#STYLE_" + id).size() < 1) {
        document.writeln("<style id='STYLE_" + id + "'>*{-webkit-tap-highlight-color:rgba(255,0,0,0)}.box-size{box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box}.ds-hide{display:none}.ds-reward-stl{font-family:\"microsoft yahei\";text-align:center;background:#f1f1f1;padding:10px 0;color:#666;margin:20px auto;width:90%}#dsRewardBtn {padding: 0;margin: 0;position: absolute;background: #7ab951;left: 110px;top: -7px;width: 50px;height: 50px;font-size: 16px;font-weight: 600;line-height: 43px;display: block;border: 4px solid #fff;border-radius: 40px;color: #FFF;}#dsRewardBtn span{display:inline-block;width:50px;height:50px;border-radius:100%;line-height:58px;color:#fff;font:400 25px/50px 'microsoft yahei';background:#FEC22C}#dsRewardBtn:hover{cursor:pointer}.ds-dialog{z-index:9999;width:100%;height:100%;position:fixed;top:0;left:0;border:1px solid #d9d9d9}.ds-dialog .ds-close-dialog{position:absolute;top:15px;right:20px;font:400 24px/24px Arial;width:20px;height:20px;text-align:center;padding:0;cursor:pointer;background:transparent;border:0;-webkit-appearance:none;font-weight:700;line-height:20px;opacity:.6;filter:alpha(opacity=20)}.ds-dialog .ds-close-dialog:hover{color:#000;text-decoration:none;cursor:pointer;opacity:.6;filter:alpha(opacity=40)}.ds-dialog-bg{position:absolute;opacity:.6;filter:alpha(opacity=30);background:#000;z-index:9999;left:0;top:0;width:100%;height:100%}.ds-dialog-content{font-family:'microsoft yahei';font-size:14px;background-color:#FFF;position:fixed;padding:0 20px;z-index:10000;overflow:hidden;border-radius:6px;-webkit-box-shadow:0 3px 7px rgba(0,0,0,.3);-moz-box-shadow:0 3px 7px rgba(0,0,0,.3);box-shadow:0 3px 7px rgba(0,0,0,.3);-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box}.ds-dialog-pc{width:390px;height:380px;top:50%;left:50%;margin:-190px 0 0 -195px}.ds-dialog-wx{width:90%;height:280px;top:50%;margin-top:-140px;margin-left:5%}.ds-dialog-content h5{text-align:left;font-size:15px;font-weight:700;margin:15px 0;color:#555}.ds-payment-way{text-align:left}.ds-payment-way label{cursor:pointer;font-weight:400;display:inline-block;font-size:14px;margin:0 15px 0 0;padding:0}.ds-payment-way input[type=radio]{vertical-align:middle;margin:-2px 5px 0 0}.ds-payment-img{margin:15px 0;text-align:center}p.ds-pay-info{font-size:15px;margin:0 0 10px}.ds-pay-money{font-size:14px;margin-top:10px}.ds-pay-money p{margin:0}.ds-pay-money .ds-pay-money-sum{margin-bottom:4px}.ds-payment-img img{margin:0 auto;width:185px;}.ds-payment-img #qrCode_1{display:none}.ds-payment-img .qrcode-border{margin:0 auto}.ds-payment-img .qrcode-tip{width:48.13px;position:relative;margin:0 auto;font-size:12px;font-weight:700;background:#fff;height:15px;line-height:15px;margin-top:-12px}#qrCode_0 .qrcode-tip{color:#3caf36}#qrCode_3 .qrcode-tip{color:#e10602}.ds-payment-img #qrCode_3{display:none}.ds-payment-img #qrCode_2{display:none}#qrCode_2 .qrcode-tip{color:#eb5f01}#qrCode_1 .qrcode-tip{color:#6699cc}.wx_qrcode_container{text-align:center}.wx_qrcode_container h2{font-size:17px}.wx_qrcode_container p{font-size:14px}.ds-reward-stl{text-align:left;background:#fff;padding:0;color:#666;margin:0;width:0}#dsRewardBtn span{position:absolute;left:115px;top:-7px;background:#7ab951;width:50px;height:50px;font-size:16px;font-weight:600;line-height:43px;border:4px solid #fff;border-radius:40px}.share-s a{margin-top:-25px} .ds-payment-img .qrcode-border{border-radius: 29.97px; width: 236.89px; height: 236.89px; padding: 18.05px; margin-top: 25.53px; } </style>");
    }

    function write() {
        var content = "<div class=\"ds-dialog\" id='PAY_" + id + "'>"
            + "   <div class=\"ds-dialog-bg\" onclick=\"PaymentUtils.hide();\"></div>"
            + "   <div class=\"ds-dialog-content ds-dialog-pc \">"
            + "    <i class=\"ds-close-dialog\">&times;</i>"
            + "    <h5>选择打赏方式：</h5>"
            + "    <div class=\"ds-payment-way\">"
            + "     <label for=\"wechat\"><input type=\"radio\" id=\"wechat\" class=\"reward-radio\" value=\"0\" checked=\"checked\" name=\"reward-way\" />微信红包</label>"
            + "     <label for=\"qqqb\"><input type=\"radio\" id=\"qqqb\" class=\"reward-radio\" value=\"1\" name=\"reward-way\" />QQ钱包</label>"
            + "     <label for=\"alipay\"><input type=\"radio\" id=\"alipay\" class=\"reward-radio\" value=\"2\" name=\"reward-way\" />支付宝</label>"
            + "    </div>"
            + "    <div class=\"ds-payment-img\">"
            + "     <div class=\"qrcode-img qrCode_0\" id=\"qrCode_0\">"
            + "      <div class=\"qrcode-border box-size\" style=\"border: 9.02px solid rgb(60, 175, 54\">"
            + "       <img  class=\"qrcode-img qrCode_0\" id=\"qrCode_0\" src=\"/static/img/shang/weixin.jpg\"  />"
            + "      </div>"
            + "      <p class=\"qrcode-tip\">打赏</p>"
            + "     </div>"
            + "     <div class=\"qrcode-img qrCode_1\" id=\"qrCode_1\">"
            + "      <div class=\"qrcode-border box-size\" style=\"border: 9.02px solid rgb(102, 153, 204\">"
            + "       <img  class=\"qrcode-img qrCode_1\" id=\"qrCode_1\"  src=\"/static/img/shang/qqpay.png\"  />"
            + "      </div>"
            + "      <p class=\"qrcode-tip\">打赏</p>"
            + "     </div>"
            + "     <div class=\"qrcode-img qrCode_2\" id=\"qrCode_2\">"
            + "      <div class=\"qrcode-border box-size\" style=\"border: 9.02px solid rgb(235, 95, 1\">"
            + "       <img  class=\"qrcode-img qrCode_2\" id=\"qrCode_2\"  src=\"/static/img/shang/alipay.jpg\" />"
            + "      </div>"
            + "      <p class=\"qrcode-tip\">打赏</p>"
            + "     </div>"
            + "     </div>"
            + "    </div>"
            + "   </div>"
            + "  </div> ";
        $("body").append(content);
    }

    $(function () {
        write();
        var $pay = $("#PAY_" + id).hide();
        $pay.find(".ds-payment-way").bind("click", function () {
            $pay.find(".qrcode-img").hide();
            $pay.find(".qrCode_" + $pay.find("input[name=reward-way]:checked").val()).show();
        });
        $pay.find(".ds-close-dialog").bind("click", function () {
            $pay.hide();
        });
    });
    var PaymentUtils = window['PaymentUtils'] = {};
    PaymentUtils.show = function () {
        $("#PAY_" + id).show();
    }
    PaymentUtils.hide = function () {
        $("#PAY_" + id).hide();
    }
})(jQuery);
</script>
