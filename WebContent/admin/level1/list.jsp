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
	function addUser() {
		window.location.href = "${pageContext.request.contextPath}/admin/level1/add.jsp";
	}
</script>
</HEAD>
<body>
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<TBODY>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>Level1
						Menu</strong></TD>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<table cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

							<td align="center" width="18%">Level1_id</td>
							<td align="center" width="17%">Level1_name</td>
							<td width="7%" align="center">Modify</td>
							<td width="7%" align="center">Delete</td>
						</tr>
						<s:iterator value="level1list" var="level1">

							<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="18%"><s:property value="#level1.level1_id" /></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%"><s:property value="#level1.level1_name" /></td>
								<td align="center" style="HEIGHT: 22px">
									<s:a namespace="/" action="level1_editByIdPre">
										<s:param name="level1_id" value="%{#level1.level1_id}" />
										<s:param name="level1_name" value="%{#level1.level1_name}"/>
										<img
											src="${pageContext.request.contextPath}/images/i_edit.gif"
											border="0" style="CURSOR: hand">
									</s:a>
								</td>
								<td align="center" style="HEIGHT: 22px">
									<s:a namespace="/" action="level1_deleteById?">
										<s:param name="level1_id" value="%{#level1.level1_id}" />
										<s:param name="level1_name" value="%{#level1.level1_name}"/>
										<img src="${pageContext.request.contextPath}/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</s:a></td>
							</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="right">
					<button type="button" id="add" name="add" value="Add"
						class="button_add" onclick="addUser()">Add</button>

				</td>
			</tr>
		</TBODY>
	</table>
</body>
</HTML>

