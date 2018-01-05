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
		
			<div class="step step1">
				<ul>
					
					<li  class="current"></li>
					<li ><s:actionmessage/></li>
				</ul>
			</div>
	
		
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
					<!-- better to use order but order is same as cart -->
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
								<input type="text" name="quantity" value="<s:property value='value.count'/>" maxlength="4">
									<div>
										<span class="increase">&nbsp;</span> <span class="decrease">&nbsp;</span>
									</div>
							</td>
							<td width="140">
								<span class="subtotal">$<s:property value="value.subtotal"/></span>
							</td>
							<td><a href="${pageContext.request.contextPath}/cart_removeCartItem?product_id=<s:property value='value.product.product_id'/>" class="delete">Delete</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
					Totao Price: <strong id="effectivePrice">$<s:property value="#session.cart.total"/></strong>
				</div>
			<form id="orderForm" action="./order_payOrder.action" method="post">
				<input type="hidden" name="model.order_id" value="<s:property value="model.order_id"/>"/>
				<div class="span24">
					<p>
							Receive Address:<input name="order_address" type="text" value="" style="width:350px" />
								<br />
							Receiver Name:&nbsp;&nbsp;&nbsp;：<input name="order_receiver" type="text" value="" style="width:150px" />
								<br /> 
							Contact Info:<input name="order_phone" type="text"value="" style="width:150px" />

						</p>
						<hr />
						<p>
							<strong>Please select a bank to Pay:</strong><br/>
							<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>ICBC
							<img src="${pageContext.request.contextPath}/bank_img/icbc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>BOC
							<img src="${pageContext.request.contextPath}/bank_img/bc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>ABC
							<img src="${pageContext.request.contextPath}/bank_img/abc.bmp" align="middle"/>
							<br/>
							<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>BOCO
							<img src="${pageContext.request.contextPath}/bank_img/bcc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>PINGANBANK
							<img src="${pageContext.request.contextPath}/bank_img/pingan.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>CCB
							<img src="${pageContext.request.contextPath}/bank_img/ccb.bmp" align="middle"/>
							<br/>
							<input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>CEB
							<img src="${pageContext.request.contextPath}/bank_img/guangda.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>CMBCHINA
							<img src="${pageContext.request.contextPath}/bank_img/cmb.bmp" align="middle"/>
						</p>
						<hr />
						<p style="text-align:right">
							<a href="javascript:document.getElementById('orderForm').submit();">
								<img src="${pageContext.request.contextPath}/images/confirm.jpg" width="204" height="51" border="0" />
							</a>
						</p>
				</div>
			</form>
		</div>
		
	</div>
<%@ include file="/jsp/tail.jsp"%>
</body>
</html>