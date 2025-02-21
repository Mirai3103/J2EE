<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h4>CHI TIẾT HOA</h4>
<div class="row" style="border: 1px gray solid;border-radius:5px;">
	<div class="col-3">
		<img src="images/${flower.picture}" width="95%" />
	</div>
	<div class="col-9">
		<p>${flower.flowerName}</p>
		<p>
			<span style="text-decoration: line-through; color: red">Giá
				cũ: <f:formatNumber value="${flower.priceOld}" /></span> Giá mới:
			<f:formatNumber value="${flower.price}" />
			đ
		</p>
		<p>${flower.brief}</p>
	</div>
	<div class="col-12">
		<h4>Mô tả</h4>
		<p>${flower.description}</p>
	</div>
</div>