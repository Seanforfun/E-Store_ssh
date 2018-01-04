<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>List</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
</head>
<body>
	<div class="container header">
		<%@ include file="/jsp/header.jsp"%>
		<%@ include file="/jsp/level1.jsp"%>
		<%@ include file="/jsp/level2.jsp"%>
	</div>
	<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
				<s:iterator value="level1List" var="level1">
					<dl>
						<dt>
							<a><s:property value="#level1.level1_name" /></a>
						</dt>
						<s:iterator value="#level1.level2_set" var="level2s">
							<dd>
								<a><s:property value="#level2s.level2_name" /></a>
							</dd>
						</s:iterator>
					</dl>
				</s:iterator>
			</div>
		</div>
		<div class="span18 last">

			<form id="productForm"
				action="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm"
				method="get">
				<input type="hidden" id="brandId" name="brandId" value=""> <input
					type="hidden" id="promotionId" name="promotionId" value="">
				<input type="hidden" id="orderType" name="orderType" value="">
				<input type="hidden" id="pageNumber" name="pageNumber" value="1">
				<input type="hidden" id="pageSize" name="pageSize" value="20">

				<div id="result" class="result table clearfix">
					<ul>
						<s:iterator value="#pageBean.list" var="p">
							<li>
								<a href="">
								<img src="${pageContext.request.contextPath}/<s:property value='#p.product_photo'/>" width="170" height="170"  style="display: inline-block;">
								<span style='color:green'>
									 <s:property value="#p.product_name"/>
								</span>
								<span class="price">
									Store price:<s:property value="#p.product_store_price"/>
								</span>
							</a></li>
						</s:iterator>
					</ul>
				</div>
				<div class="pagination">
					<span class="firstPage">&nbsp;</span> <span class="previousPage">&nbsp;</span>
					<span class="currentPage">1</span> <a
						href="javascript: $.pageSkip(2);">2</a> <a class="nextPage"
						href="javascript: $.pageSkip(2);">&nbsp;</a> <a class="lastPage"
						href="javascript: $.pageSkip(2);">&nbsp;</a>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="/jsp/tail.jsp"%>
</body>
</html>