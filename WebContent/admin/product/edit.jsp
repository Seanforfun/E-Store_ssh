<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script language="javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
	</HEAD>
	<body>
		<s:form id="userAction_save_do" name="Form1" namespace="/" action="product_editById2Post" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<s:hidden name="product_id" value="%{#existProduct.product_id}" id="userID"/>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>Edit Product</STRONG>
						</strong>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						Product name:
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textfield name="product_name" value="%{#existProduct.product_name}" id="" cssClass="bg" />
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						Product market price:
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textfield name="product_market_price" value="%{#existProduct.product_market_price}" id="" cssClass="bg" />
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						Product store price:
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textfield name="product_store_price" value="%{#existProduct.product_store_price}" id="" cssClass="bg" />
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						Product belonging:
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:select list="level2s" name="level2_name" value="%{#existProduct.product_belonging.level2_name}"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						Hot:
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:radio list="%{#{'1':'Hot', '0':'Not Hot' } }" name="product_ishot" value="%{#existProduct.product_ishot}"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Photo:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:file name="upload"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						Product desc:
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textarea name="product_desc" cols="30" rows="3" id="userAction_save_do_remark" style="WIDTH: 96%" value="%{#existProduct.product_desc}"/>
					</td>
				</tr>
				<TR>
					<td align="center" colSpan="4" class="sep1">
						<img src="${pageContext.request.contextPath}/images/shim.gif">
					</td>
				</TR>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<s:submit id="" name="submit" value="Submit" cssClass="button_ok"/>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="&#37325;&#32622;" class="button_cancel">Reset</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="Return"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</s:form>




	</body>
</HTML>