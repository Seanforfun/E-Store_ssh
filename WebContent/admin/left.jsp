<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Menu</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">Expend all</a> | <a href="javascript: d.closeAll();">Close all</a>
	<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
		<!--
		d = new dTree('d');
		d.add(0,-1,'E-store admin menu');
		d.add("01",0,'User Manage','${pageContext.request.contextPath}','','mainFrame');
		d.add("01-1","01",'User Manage','${pageContext.request.contextPath}','','mainFrame');
		d.add("02",0,'Product manage','','','mainFrame');
		d.add("02-1","02",'Product manage-1','${pageContext.request.contextPath}/product_adminFindAllByPage?page=1','','mainFrame');
		d.add("03",0,'Order manage','','','mainFrame');
		d.add("04",0,'Level1 manage','','','mainFrame');
		d.add("04-1","04",'Level1 manage','${pageContext.request.contextPath}/level1_adminFindAll','','mainFrame');
		d.add("05",0,'Level2 manage','','','mainFrame');
		d.add("05-1","05",'Level2 manage','${pageContext.request.contextPath}/level2_adminFindAllByPage?page=1','','mainFrame');
		
		document.write(d);
		//-->
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
