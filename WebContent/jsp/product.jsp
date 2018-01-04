<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery_002.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery_004.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery_003.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

</head>
<body>

<div class="container header">
	<%@ include file="/jsp/header.jsp"%>
	<%@ include file="/jsp/level1.jsp"%>
	<%@ include file="/jsp/level2.jsp"%>
</div>
<div class="container productContent">
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
			
			<div class="productImage">
					<a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="http://image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg" rel="gallery">
						<div class="zoomPad">
							<img style="opacity: 1;" title="" class="medium" src="${pageContext.request.contextPath }/<s:property value='model.product_photo'/>">
								<div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup"></div>
								<div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;" class="zoomWindow">
								<div style="width: 368px;" class="zoomWrapper"><div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div>
								<div style="width: 0%; height: 0px;" class="zoomWrapperImage">
								<img src="%E5%B0%9A%E9%83%BD%E6%AF%94%E6%8B%89%E5%A5%B3%E8%A3%852013%E5%A4%8F%E8%A3%85%E6%96%B0%E6%AC%BE%E8%95%BE%E4%B8%9D%E8%BF%9E%E8%A1%A3%E8%A3%99%20%E9%9F%A9%E7%89%88%E4%BF%AE%E8%BA%AB%E9%9B%AA%E7%BA%BA%E6%89%93%E5%BA%95%E8%A3%99%E5%AD%90%20%E6%98%A5%E6%AC%BE%20-%20Powered%20By%20Mango%20Team_files/6d53c211-2325-41ed-8696-d8fbceb1c199-large.jpg" style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;"></div></div></div><div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div></div>
					</a>
				
			</div>
			<div class="name"><s:property value="model.product_name"/></div>
			<div class="sn">
				<div>serial number: <s:property value="model.product_id"/></div>
			</div>
			<div class="info">
				<dl>
					<dt>Our price:</dt>
					<dd>
						<strong>$ <s:property value="model.product_store_price"/></strong>
							Market price:
							<del>$ <s:property value="model.product_market_price"/></del>
					</dd>
				</dl>
					<dl>
						<dt>Discount:</dt>
						<dd>
								<a target="_blank" title=" flash sale(2014-07-30 ~ 2015-01-01)"> flash sale</a>
						</dd>
					</dl>
					<dl>
						<dt>    </dt>
						<dd>
							<span>    </span>
						</dd>
					</dl>
			</div>
				<div class="action">
					
						<dl class="quantity">
							<dt>Number:</dt>
							<dd>
								<input id="quantity" name="quantity" value="1" maxlength="4" onpaste="return false;" type="text">
								<div>
									<span id="increase" class="increase">&nbsp;</span>
									<span id="decrease" class="decrease">&nbsp;</span>
								</div>
							</dd>
							<dd>
							</dd>
						</dl>
					<div class="buy">
							<input id="addCart" class="addCart" value="Add to cart" type="button">
				
					</div>
				</div>
				<div id="introduction" name="introduction" class="introduction">
					<div class="title">
						<strong>Product Introduction</strong>
					</div>
					<div>
						<s:property value="model.product_desc"/>
					</div>
				</div>
		</div>
	</div>
	<%@ include file="/jsp/tail.jsp"%>
</body>
</html>