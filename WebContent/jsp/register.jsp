<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Register</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<script type="text/javascript">
	var flag = true;
	var checkcode = true;
	function createXMLHttpRequest() {
		var xmlHttp = null;
		try { // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {// Internet Explorer
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}
		return xmlHttp;
	}
	
	function verifyCheckcode(){
		var checkcodeVal = document.getElementById("checkcodeId").value;
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.onreadystatechange = function(){
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				var resp = xmlHttp.responseText;
				var jsondata = eval("("+resp+")");
				if(jsondata.result != "true"){
					checkcodeSpan.innerHTML = jsondata.result;
					checkcode = false;
				}else{
					checkcodeSpan.innerHTML = "";
					checkcode = true;
				}
			}
		}
		xmlHttp.open("GET", "${pageContext.request.contextPath}/user_verify?checkcode=" + checkcodeVal, true);
		xmlHttp.send(null);
	}
	
	function checkForm(){
		var username = document.getElementById("username").value;
		flag = true;
		if(username == ""|| username.length == 0){
			var span1 = document.getElementById("usernameSpan");
			span1.innerHTML = "Username required!";
			flag = false;
		}
		var password = document.getElementById("password").value;
		if(password == ""){
			var span2 = document.getElementById("passwordSpan");
			span2.innerHTML = "Password required!";
			flag = false;
		}
		var repassword = document.getElementById("repassword").value;
		if(repassword != password){
			var span3 = document.getElementById("repasswordSpan");
			span3.innerHTML = "password should be same!";
			flag = false;
		}
		var email = document.getElementById("email").value.trim();
		if(email == "" || email.length == 0){
			var span4 = document.getElementById("emailSpan");
			span4.innerHTML = "E-mail required!";
			flag = false;
		}else{
			var reg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			if(!reg.test(email)){
				var span4 = document.getElementById("emailSpan");
				span4.innerHTML = "Please use a correct e-mail!";
				flag = false;
			}
		}
		if(flag&checkcode == 0){
			return false;
		}else{
			return true;
		}
	}
	
	function removeSpanContent(id){
		var span = document.getElementById(id);
		span.innerHTML = "";
	}
	
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
					<a href="./index.htm" >[Exit]</a>|
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
			<a href="./购物车.htm">Cart</a>
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
						|
					</li>
					<li>
						<a >item</a>
						|
					</li>
					<li>
						<a>item</a>
						|
					</li>
					<li>
						<a>item</a>
						|
					</li>
					<li>
						<a>item</a>
						|
					</li>
					<li>
						<a>item</a>
						|
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
	</div>
</div>	<div class="container register">
		<div class="span24">
			<div class="wrap">
				<div class="main clearfix">
					<div class="title">
						<strong>User Register</strong>
					</div>
					<s:fielderror/>
					<form id="registerForm"  action="${pageContext.request. contextPath}/user_register" method="post" onsubmit="return checkForm();">
						<table>
							<tbody><tr>
								<th>
									<span class="requiredField">*</span>Username:
								</th>
								<td>
									<input type="text" id="username" name="user_username" class="text" maxlength="20" onclick="removeSpanContent('usernameSpan')">
									<span id="usernameSpan"></span>
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>Password:
								</th>
								<td>
									<input type="password" id="password" name="user_password" class="text" maxlength="20" onclick="removeSpanContent('passwordSpan')">
									<span id="passwordSpan"></span>
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>Re-password:
								</th>
								<td>
									<input  type="password" id="repassword" name="repassword" class="text" maxlength="20" onclick="removeSpanContent('repasswordSpan')">
									<span id="repasswordSpan"></span>
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>E-mail:
								</th>
								<td>
									<input type="text" id="email" name="user_email" class="text" maxlength="200" onclick="removeSpanContent('emailSpan')">
									<span id="emailSpan"></span>
								</td>
							</tr>
									<tr>
										<th>
											Name:
										</th>
										<td>
												<input type="text" name="user_name" class="text" maxlength="200" >
										</td>
									</tr>
									<tr>
										<th>
											Gender:
										</th>
										<td>
												<span class="fieldSet">
														<label>
															<input type="radio" name="user_gender" value="male">male
														</label>
														<label>
															<input type="radio" name="user_gender" value="female">female
														</label>
												</span>
										</td>
									</tr>
									<tr>
										<th>
											Address:
										</th>
										<td>
												<input type="text" name="user_address" class="text" maxlength="200">
										</td>
									</tr>
								<tr>
									<th>
										<span class="requiredField">*</span>Checkcode:
									</th>
									<td>
										<span class="fieldSet">
											<input type="text" id="checkcodeId" name="checkcode" class="text captcha" maxlength="4" onblur="verifyCheckcode()" onclick="removeSpanContent('checkcodeSpan')">
											<img id="checkcodeImage" class="captchaImage" src="${pageContext.request.contextPath}/user_checkcode" onclick="changeCheckcode('checkcodeImage')">
											<span id="checkcodeSpan"></span>
										</span>
									</td>
								</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									<input type="submit" class="submit" value="Agree and submit">
								</td>
							</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									Register protocol
								</td>
							</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									<div id="agreement" class="agreement" style="height: 200px;">
										<p>Copyright (c) 2017 Botao Xiao
											Permission is hereby granted, free of charge, to any person obtaining a copy
											of this software and associated documentation files (the "Software"), to deal
											in the Software without restriction, including without limitation the rights
											to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
											copies of the Software, and to permit persons to whom the Software is
											furnished to do so, subject to the following conditions:
											
											The above copyright notice and this permission notice shall be included in all
											copies or substantial portions of the Software.
											
											THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
											IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
											FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
											AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
											LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
											OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
											SOFTWARE.</p>
									</div>
								</td>
							</tr>
						</tbody></table>
						<div class="login">
<div class="ad">
					<dl>
	<dt>
		Register to enjoy:
	</dt>
	<dd>
		Membership service
	</dd>
	<dd>
		30 days no reason return
	</dd>
</dl>
</div>							<dl>
								<dt>Already have an account?</dt>
								<dd>
									Login now to enjoy shopping!
									<a href="${pageContext.request.contextPath }/user_loginPage">Login</a>
								</dd>
							</dl>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="Our advantage" title="Our advantage">
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a>About us</a>
						|
					</li>
					<li>
						<a>Contect me</a>
						|
					</li>
					<li>
						<a>Hire me</a>
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
<div id="_my97DP" style="position: absolute; top: -1970px; left: -1970px;"><iframe style="width: 190px; height: 191px;" src="./会员注册 - Powered By Mango Team_files/My97DatePicker.htm" frameborder="0" scrolling="no"></iframe></div></body></html>