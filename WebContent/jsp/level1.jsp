<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="span24">
	<ul class="mainNav">
		<li><a href="${pageContext.request.contextPath}/index">Main
				page</a> |</li>
		<s:iterator value="#session.level1List" var="level1">
			<li>
				<a href="${pageContext.request.contextPath }/product_findProductBylevel1_id?level1_id=<s:property value="#level1.level1_id"/>&pageNum=1"><s:property value="#level1.level1_name" />
						</a>|
			</li>
		</s:iterator>
	</ul>
</div>