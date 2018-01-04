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
							<a href="${pageContext.request.contextPath }/product_findProductBylevel1_id?level1_id=<s:property value="#level1.level1_id"/>&pageNum=1"><s:property value="#level1.level1_name" /></a>
						</dt>
						<s:iterator value="#level1.level2_set" var="level2s">
							<dd>
								<a href="${pageContext.request.contextPath }/product_findProductBylevel2_id?level2_id=<s:property value="#level2s.level2_id"/>&pageNum=1"><s:property value="#level2s.level2_name" /></a>
							</dd>
						</s:iterator>
					</dl>
				</s:iterator>
			</div>
		</div>
		<div class="span18 last">
				<div id="result" class="result table clearfix">
					<ul>
						<s:iterator value="#pageBean.list" var="p">
							<li>
								<a href="${pageContext.request. contextPath}/product_findProductById?product_id=<s:property value='#p.product_id'/>">
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
					<s:if test="level == 1">
						<s:if test="#pageBean.currentPage != 1">
							<span class="firstPage"><a href="${pageContext.request.contextPath }/product_findProductByLevel?pageNum=1&level_id=<s:property value='level1_id'/>&level=1"></a></span>
							<span class="previousPage"><a href="${pageContext.request.contextPath }/product_findProductByLevel?pageNum=<s:property value='#pageBean.currentPage-1'/>&level_id=<s:property value='level1_id'/>&level=1"></a>&nbsp;</span>
						</s:if>
						<s:iterator var="i" begin="1" step="1" end="#pageBean.totalPageNum">
							<s:if test="#pageBean.currentPage == #i">
								<span class="currentPage"><s:property value="#i"/></span>
							</s:if>
							<s:else>
								 <a href="${pageContext.request.contextPath }/product_findProductByLevel?pageNum=<s:property value='#i'/>&level_id=<s:property value='level1_id'/>&level=1"><s:property value="#i"/></a>
							</s:else>
						</s:iterator>
						<s:if test="#pageBean.currentPage != #pageBean.totalPageNum">
							 <a class="nextPage" href="${pageContext.request.contextPath }/product_findProductByLevel?pageNum=<s:property value='#pageBean.currentPage+1'/>&level_id=<s:property value='level1_id'/>&level=1">&nbsp;</a>
							 <a class="lastPage" href="${pageContext.request.contextPath }/product_findProductByLevel?pageNum=<s:property value='#pageBean.totalPageNum'/>&level_id=<s:property value='level1_id'/>&level=1">&nbsp;</a>
						</s:if>
					</s:if>
					<s:elseif test="level == 2">
						<s:if test="#pageBean.currentPage != 1">
							<span class="firstPage"><a href="${pageContext.request.contextPath }/product_findProductByLevel?pageNum=1&level_id=<s:property value='level2_id'/>&level=2"></a></span>
							<span class="previousPage"><a href="${pageContext.request.contextPath }/product_findProductByLevel?pageNum=<s:property value='#pageBean.currentPage-1'/>&level_id=<s:property value='level2_id'/>&level=2"></a>&nbsp;</span>
						</s:if>
						<s:iterator var="i" begin="1" step="1" end="#pageBean.totalPageNum">
							<s:if test="#pageBean.currentPage == #i">
								<span class="currentPage"><s:property value="#i"/></span>
							</s:if>
							<s:else>
								 <a href="${pageContext.request.contextPath }/product_findProductByLevel?pageNum=<s:property value='#i'/>&level_id=<s:property value='level2_id'/>&level=2"><s:property value="#i"/></a>
							</s:else>
						</s:iterator>
						<s:if test="#pageBean.currentPage != #pageBean.totalPageNum">
							 <a class="nextPage" href="${pageContext.request.contextPath }/product_findProductByLevel?pageNum=<s:property value='#pageBean.currentPage+1'/>&level_id=<s:property value='level2_id'/>&level=2">&nbsp;</a>
							 <a class="lastPage" href="${pageContext.request.contextPath }/product_findProductByLevel?pageNum=<s:property value='#pageBean.totalPageNum'/>&level_id=<s:property value='level2_id'/>&level=2">&nbsp;</a>
						</s:if>
					</s:elseif>
				</div>
		</div>		
	</div>
	<%@ include file="/jsp/tail.jsp"%>
</body>
</html>