<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h4>Danh sách loài hoa trình bày theo dạng bảng</h4>
<span style="color:blue">${msg}</span>
<p><a href="index.jsp?page=add" class="btn btn-primary">Thêm mới</a></p>
<table class="table table-bordered">
	<tr>
		<th>Mã số</th>
		<th>Tên hoa</th>
		<th>Giá</th>
		<th>Ảnh</th>
		<th>Ngày tạo</th>
		<th>Tình trạng</th>
		<th></th>
	</tr>
	<c:forEach items="${flowers}" var="f">
		<tr>
			<td>${f.flowerId}</td>
			<td>${f.flowerName}</td>
			<td>${f.price}</td>
			<td><img src="images/${f.picture}" width="100"/></td>
			<td><f:formatDate value="${f.createDate}" pattern="dd/MM/yyyy"/> </td>
			<td><c:choose>
				<c:when test="${f.active==true}">
					Còn hàng
				</c:when>
				<c:otherwise>
					Hết hàng
				</c:otherwise>
			</c:choose>
			</td>
			<th>
				<a href="FlowerServlet?action=edit&flowerid=${f.flowerId}" class="btn btn-info">Sửa</a>
				<a href="FlowerServlet?action=delete&flowerid=${f.flowerId}" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không?')">Xóa</a>
				<a href="FlowerServlet?action=detail&flowerid=${f.flowerId}" class="btn btn-success">Chi tiết</a>
			</th>
		</tr>
	</c:forEach>
</table>