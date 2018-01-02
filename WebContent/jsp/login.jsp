<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	<meta name="author" content="Seanforfun">
	<meta name="copyright" content="Seanforfun">
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<script type="text/javascript">
	/*Refresh verify code picture*/
	function changeCheckcode(id){
		var img = document.getElementById(id);
		img.src = "${pageContext.request.contextPath}/user_checkcode?time=" + new Date().getTime().toString();
	}
</script>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="http://localhost:8080/mango/">
				<img src="${pageContext.request.contextPath}/image/logo.png" alt="Seanforfunlogo" style="width: 250px; height: 50px; "/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="good quality" title="good quality">
</div>	</div>
	<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/user_loginPage">Login</a>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/user_registerPage">Register</a>|
				</li>
				<li id="headerUsername" class="headerUsername"></li>
				<li id="headerLogout" class="headerLogout">
					<a>[Exit]</a>|
				</li>
						<li>
							<a>Membership</a>
							|
						</li>
						<li>
							<a>Shopping guide</a>
							|
						</li>
						<li>
							<a>About me</a>
							
						</li>
			</ul>
		</div>
		<div class="cart">
			<a  href="./购物车.htm">Cart</a>
		</div>
			<div class="phone">
				Contact:
				<strong>Seanforfun</strong>
			</div>
	</div>
	<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="./index.htm">Main page</a>
						|
					</li>
					<li>
						<a href="./蔬菜分类.htm">Custom combos</a>
						
					</li>
					
		</ul>
	</div>
	<div class="span24">
		<div class="tagWrap">
			<ul class="tag">
						<li class="icon" style="background: url(http://storage.shopxx.net/demo-image/3.0/tag/hot.gif) right no-repeat;">
							<a >Hot</a>
						</li>
						<li class="icon" style="background: url(http://storage.shopxx.net/demo-image/3.0/tag/new.gif) right no-repeat;">
							<a>New</a>
						</li>
			</ul>
			<div class="search">
				<form id="productSearchForm" method="get">
					<input name="keyword" class="keyword" value="Product search" maxlength="30">
					<button type="submit">search</button>
				</form>
			</div>
		</div>
</div>	<div class="container login">
		<div class="span12">
<div class="ad">
					<img src="${pageContext.request.contextPath}/image/login.jpg" width="500" height="330" alt="login" title="login">
</div>		</div>
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>User login</strong>
					</div>
					<div>
						<s:actionerror/>
					</div>
					<form id="loginForm"  method="post" action="${pageContext.request.contextPath }/user_login">
						<table>
							<tbody><tr>
								<th>
										Username:
								</th>
								<td>
									<input type="text" id="username" name="user_username" class="text" maxlength="20" value="<s:property value="#cookie.remember"/>">
								</td>
							</tr>
							<tr>
								<th>
									Password:
								</th>
								<td>
									<input type="password" id="password" name="user_password" class="text" maxlength="20">
								</td>
							</tr>
								<tr>
									<th>
										Checkcode:
									</th>
									<td>
										<span class="fieldSet">
											<input type="text" id="checkcode" name="checkcode" class="text captcha" maxlength="4">
											<img id="checkcodeImage" class="captchaImage" src="${pageContext.request.contextPath}/user_checkcode" onclick="changeCheckcode('checkcodeImage')">
											<span id="checkcodeSpan"></span>
										</span>
									</td>
								</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									<label>
										<input type="checkbox" id="isRememberUsername" name="isRememberUsername" value="true">remember
									</label>
									<label>
										&nbsp;&nbsp;<a >Forget password</a>
									</label>
								</td>
							</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									<input type="submit" class="submit" value="Login">
								</td>
							</tr>
							<tr class="register">
								<th>&nbsp;
									
								</th>
								<td>
									<dl>
										<dt>Not a membership?</dt>
										<dd>
											Register now for shopping!
											<a href="${pageContext.request.contextPath }/user_registerPage">Register now</a>
										</dd>
									</dl>
								</td>
							</tr>
						</tbody></table>
					</form>
				</div>
			</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
	  <div class="footerAd"><img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="Our advantage" title="Our advantage" /></div>	
	</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a>About us</a>
						|
					</li>
					<li>
						<a href="https://github.com/Seanforfun">Contect me</a>
						|
					</li>
					<li>
						<a href="https://github.com/Seanforfun">Hire me</a>
						|
					</li>
					<li>
						<a>Legal Notices</a>
						|
					</li>
					<li>
						<a>Blogroll</a>
						|
					</li>
					<li>
						<a target="_blank">Pay method</a>
						|
					</li>
					<li>
						<a target="_blank">Delivery</a>
						|
					</li>
					<li>
						<a>Service invoicement</a>
						|
					</li>
					<li>
						<a>Advertisement</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2018 Seanforfun</div>
	</div>
</div>
</body></html>