<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name='robots' content='noindex,follow' />
<meta name="viewport" content="width=device-width" />

<link rel="stylesheet"
	href="static/plugin/font-awesome/css/font-awesome.min.css">
<link rel="shortcut icon" href="img/logo.png">
<link rel='stylesheet' id='dashicons-css'
	href='static/plugin/login/dashicons.min.css' type='text/css'
	media='all' />
<link rel='stylesheet' id='buttons-css'
	href='static/plugin/login/buttons.min.css' type='text/css'
	media='all' />
<link rel='stylesheet' id='forms-css'
	href='static/plugin/login/forms.min.css' type='text/css' media='all' />
<link rel='stylesheet' id='l10n-css'
	href='static/plugin/login/l10n.min.css' type='text/css' media='all' />
<link rel='stylesheet' id='login-css'
	href='static/plugin/login/login.min.css' type='text/css' media='all' />
<link rel='stylesheet' href='static/css/login.css' type='text/css'
	media='all' />

</head>
<body class="login login-action-login wp-core-ui  locale-zh-cn">
	<div id="login">
		<br /> <br />
		 <form name="loginForm" id="loginForm" action="admin/Register"
			method="post">
			<p>
				<label for="user_login">用户名<br /> <input type="text"
					name="userName" id="user_login" class="input" 
					size="20" required /></label>
			</p>
			<p>
				<label for="user_login1">昵称<br /> <input type="text"
					name="userNickname" id="user_login1" class="input" 
					size="20" required /></label>
			</p>
			<p>
				<label for="user_Email">电子邮件地址<br /> <input type="text"
					name="userEmail" id="user_Email" class="input" 
					size="20" required /></label>
			</p>
			<p>
				<label for="user_pass">密码<br /> <input type="password"
					name="userPass" id="user_pass" class="input" 
					size="20" required />
				</label>
			</p>
			<p>
				<label for="user_pass1">确认密码<br /> <input type="password"
					name="userPass1" id="user_pass1" class="input" 
					size="20" required />
				</label>
			</p>
			
			
			<p class="submit">
				<input type="submit" name="wp-submit" id="submit-btn"
					class="button button-primary button-large" value="注册" />
			</p>
			
		</form>
	</div>
	<div class="clear"></div>
	<script >
	 var msg="${msg}";
	if(msg!="")
	 alert(msg);
	</script>
</body>
</html>