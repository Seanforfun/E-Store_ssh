<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>E-store</title>
<link href="${pageContext.request.contextPath}/css/slider.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="container header">
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
		<%@ include file="/jsp/header.jsp"%>
		<%@ include file="/jsp/level1.jsp"%>
	</div>

	<div class="container index">
		<div class="span24">
			<div id="hotProduct" class="hotProduct clearfix">
				<div class="title">
					<strong>Hot Products</strong>
					<!-- <a  target="_blank"></a> -->
				</div>
				<ul class="tab">
					<li class="current"><a href="./蔬菜分类.htm?tagIds=1"
						target="_blank"></a></li>
				</ul>
				<ul class="tabContent" style="display: block;">
					<s:iterator value="hotList" var="hot">
						<li>
							<a>
								<img src="${pageContext.request.contextPath}/<s:property value='#hot.product_photo'/>"/>
							</a>
						</li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
				<div class="title">
					<strong>New Products</strong> <a target="_blank"></a>
				</div>
				<ul class="tab">
					<li class="current"><a href="./蔬菜分类.htm?tagIds=2"
						target="_blank"></a></li>
					<li><a target="_blank"></a></li>
					<li><a target="_blank"></a></li>
				</ul>
				<ul class="tabContent" style="display: block;">
						<s:iterator value="newList" var="newproducts">
							<li>
								<a>
									<img src="${pageContext.request.contextPath}/<s:property value='#newproducts.product_photo'/>"/>
									</a></li>
						</s:iterator>
				</ul>
			</div>
		</div>
		<div class="span24">
			<div class="friendLink">
				<dl>
					<dt>User guide</dt>
					<dd>
						<a target="_blank">Pay method</a> |
					</dd>
					<dd>
						<a target="_blank">Delivery</a> |
					</dd>
					<dd>
						<a target="_blank">Aftersale service</a> |
					</dd>
					<dd>
						<a target="_blank">Shopping guide</a> |
					</dd>
					<dd>
						<a target="_blank">Vegatable </a> |
					</dd>
					<dd>
						<a target="_blank">Gift card</a> |
					</dd>
					<dd class="more">
						<a>More</a>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<%@ include file="/jsp/tail.jsp"%>
</body>
</html>