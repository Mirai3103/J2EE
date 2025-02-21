<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h4>Danh sách loài hoa trình bày theo dạng ô</h4>
<div class="row">	<c:forEach items="${flowers}" var="f">
		<div class="col-3">
			<div class="card" style="width: 240px">
				<img class="card-img-top" src="images/${f.picture}"/>
				<div class="card-body">
					<h5 class="card-title">${f.flowerName}</h5>
					<p class="card-text">Giá: ${f.price}</p>
					<a href="#" class="btn btn-primary">Mua</a> <a href="FlowerServlet?action=detail&flowerid=${f.flowerId}" class="btn btn-success">Chi tiết</a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>