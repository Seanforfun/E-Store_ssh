<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>  
<div class="span5">
			<div class="logo">
				<a href="${pageContext.request.contextPath }/index.action"> <img
					src="${pageContext.request.contextPath}/image/logo.png"
					alt="Seanforfunlogo" style="width: 250px; height: 50px;" />
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="${pageContext.request.contextPath}/image/header.jpg"
					width="320" height="50" alt="good quality" title="good quality" />
			</div>
		</div>  
<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<s:if test="#session.existUser != null">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						Welcome:<s:property value="#session.existUser.user_username"/>|
					</li>
					<li>
							<a href="${pageContext.request.contextPath }/user_exit">[Exit]</a>|
					</li>
				</s:if>
				<s:else>
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${pageContext.request.contextPath }/user_loginPage">Login</a>|
					</li>
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath }/user_registerPage">Register</a>|
					</li>
				</s:else>
						<li>
							<a>Membership</a>|
						</li>
						<li>
							<a>Shopping guide</a>|
						</li>
						<li>
							<a>About me</a>
						</li>
			</ul>
		</div>
		<div class="cart">
			<a  href="${pageContext.request.contextPath }/jsp/cart.jsp">Cart</a>
		</div>
			<div class="phone">
				Contact:
				<strong>416-828-0752</strong>
			</div>
	</div>