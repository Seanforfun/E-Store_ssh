<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript">
	function addLevel2() {
		window.location.href = "${pageContext.request.contextPath}/level2_addPre";
	}
</script>
</HEAD>
<body>
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<TBODY>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>Product List</strong></TD>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><s:actionerror/></TD>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<table cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

							<td align="center" width="12%">Id</td>
							<td align="center" width="12%">Name</td>
							<td align="center" width="12%">Market_price</td>
							<td align="center" width="12%">Store_price</td>
							<td align="center" width="12%">Photo</td>
							<td align="center" width="12%">Belonging</td>
							<td width="14%" align="center">Modify</td>
							<td width="14%" align="center">Delete</td>
						</tr>
						<s:iterator value="#pageBean.list" var="product">
							<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="12%"><s:property value="#product.product_id" /></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="12%"><s:property value="#product.product_name" /></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="12%"><s:property value="#product.product_market_price" /></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="12%"><s:property value="#product.product_store_price" /></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="12%"><img src="${pageContext.request.contextPath }/<s:property value='#product.product_photo' />" height="100px" width="100px"/></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="12%"><s:property value="#product.product_belonging.level2_name" /></td>
								<td align="center" style="HEIGHT: 22px">
									<s:a namespace="/" action="product_editByIdPre">
										<s:param name="product_id" value="%{#product.product_id}" />
										<s:param name="product_name" value="%{#product.product_name}"/>
										<img
											src="${pageContext.request.contextPath}/images/i_edit.gif"
											border="0" style="CURSOR: hand">
									</s:a>
								</td>
								<td align="center" style="HEIGHT: 22px">
									<s:a namespace="/" action="product_deleteById?">
										<s:param name="product_id" value="%{#product.level2_id}" />
										<s:param name="product_name" value="%{#product.level2_name}"/>
										<img src="${pageContext.request.contextPath}/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</s:a></td>
							</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
			<tr>
				<td align="right">
					<s:iterator begin="1" end="#pageBean.totalPageNum" step="1" var="i">
						<s:if test="#pageBean.currentPage == #i">
								<span class="currentPage"><s:property value="#i"/></span>
						</s:if>
						<s:else>
								<a href="${pageContext.request.contextPath }/level2_adminFindAllByPage?page=<s:property value="#i"/>"><s:property value="#i"/></a>
						</s:else>
					</s:iterator>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="right">
					<button type="button" id="add" name="add" value="Add"
						class="button_add" onclick="addLevel2()">Add</button>
				</td>
			</tr>
		</TBODY>
	</table>
</body>
</HTML>

