<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title>Cart</title>
	<meta name="author" content="Mango Team">
		<meta name="copyright" content="Mango">
			<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
				<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css">
					<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
					<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
</head>
<body>
	<div class="container header">
		<%@ include file="/jsp/header.jsp"%>
		<%@ include file="/jsp/level1.jsp"%>
		<%@ include file="/jsp/level2.jsp"%>
	</div>
	<div class="container cart">
		<div class="span24">
			<div class="step step1"></div>
			<table>
				<tbody>
					<tr>
						<th>Photo</th>
						<th>Product</th>
						<th>Price</th>
						<th>Number</th>
						<th>Subtotal</th>
						<th>Operation</th>
					</tr>
					<s:iterator value="#session.cart.map">
						<tr>
							<td width="60">
								<input type="hidden" name="id" value="22">
									<img src="${pageContext.request.contextPath}/<s:property value="value.product.product_photo"/>">
							</td>
							<td>
								<a target="_blank"><s:property value="value.product.product_name"/></a>
							</td>
							<td>$<s:property value="value.product.product_store_price"/></td>
							<td class="quantity" width="60">
								<input type="text" name="quantity" value="<s:property value='value.count'/>" maxlength="4" onpaste="return false;">
									<div>
										<span class="increase">&nbsp;</span> <span class="decrease">&nbsp;</span>
									</div>
							</td>
							<td width="140">
								<span class="subtotal">$<s:property value="value.subtotal"/></span>
							</td>
							<td><a href="javascript:;" class="delete">Delete</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<dl id="giftItems" class="hidden" style="display: none;">
			</dl>
			<div class="total">
				<em id="promotion"></em>
				<a href="${pageContext.request.contextPath}/user_loginPage.action"><em> Login to have a discount </em></a>
				Get Points: <em
					id="effectivePoint"><s:property value="#session.cart.total/10"/></em> Total Price: <strong id="effectivePrice">$<s:property value="#session.cart.total"/></strong>
			</div>
			<div class="bottom">
				<a href="javascript:;" id="clear" class="clear">Clear Cart</a> <a
					href="./会员登录.htm" id="submit" class="submit">Submit orders</a>
			</div>
		</div>
	</div>
	<%@ include file="/jsp/tail.jsp"%>
</body>
</html>