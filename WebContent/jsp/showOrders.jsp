<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>Order Page</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/common.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>

<div class="container header">
	<%@ include file="/jsp/header.jsp"%>
	<%@ include file="/jsp/level1.jsp"%>
	<%@ include file="/jsp/level2.jsp"%>
</div>	

<div class="container cart">

		<div class="span24">
			<s:iterator value="currrentUserOrders" var="order">
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
					<s:iterator value="#order.orderItem_set" var="items">
						<tr>
							<td width="60">
								<img src="${pageContext.request.contextPath}/<s:property value="#items.orderItem_product.product_photo"/>">
							</td>
							<td>
								<a target="_blank"><s:property value="#items.orderItem_product.product_name"/></a>
							</td>
							<td>$<s:property value="#items.orderItem_product.product_store_price"/></td>
							<td class="quantity" width="60">
								<input type="text" name="quantity" value="<s:property value='#items.orderItem_count'/>" maxlength="4">
									<div>
										<span class="increase">&nbsp;</span> <span class="decrease">&nbsp;</span>
									</div>
							</td>
							<td width="140">
								<span class="subtotal">$<s:property value="#items.orderItem_subtotal"/></span>
							</td>
							<td><a href="${pageContext.request.contextPath}/order_removeOrderItem?delete_orderItem_id=<s:property value='#items.orderItem_id'/>&order_id=<s:property value='model.order_id'/>" class="delete">Delete</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
					Total Price: <strong id="effectivePrice">$<s:property value="#order.order_total_price"/></strong><br>
					Payment Status:
					<s:if test="#order.order_status == 1">
						<strong><font color="green">Paid</font></strong>
					</s:if>
					<s:if test="#order.order_status == 0">
						<strong id="effectivePrice">Not Paid</strong>
					</s:if>
					<s:if test="#order.order_status == 2">
						<strong><font color="green">Not Delivered</font></strong>
					</s:if>
					<s:if test="#order.order_status == 3">
						<strong><font color="green">Delivered</font></strong>
					</s:if>
				</div>
			</s:iterator>
		</div>
		
	</div>
<%@ include file="/jsp/tail.jsp"%>
</body>
</html>