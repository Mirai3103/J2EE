<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Sửa hoa</h3>
<form action="FlowerServlet?action=update" method="post" enctype="multipart/form-data">
<input type="hidden" name="pictureOld" value="${flower.picture}"/>
	<table>
		<tr>
			<td>Mã hoa</td>
			<td><input type="text" name="flowerid"
				value="${flower.flowerId}" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>Tên hoa</td>
			<td><input type="text" name="flowername"
				value="${flower.flowerName}" /></td>
		</tr>
		<tr>
			<td>Đơn vị tính</td>
			<td><input type="text" name="unit" value="${flower.unit}" /></td>
		</tr>
		<tr>
			<td>Giá</td>
			<td><input type="text" name="price" value="${flower.price}" /></td>
		</tr>
		<tr>
			<td>Giá cũ</td>
			<td><input type="text" name="priceold"
				value="${flower.priceOld}" /></td>
		</tr>
		<tr>
			<td>Mô tả ngắn</td>
			<td><textarea name="brief">${flower.brief}  </textarea></td>
		</tr>
		<tr>
			<td>Mô tả đầy đủ</td>
			<td><textarea name="description">${flower.description}  </textarea></td>
		</tr>
		<tr>
			<td>Ảnh</td>
			<td><input type="file" name="picture"/></td>
		</tr>
		<tr>
			<td>Tình trạng</td>
			<td><c:if test="${flower.isActive()==true}">
					<input type="checkbox" name="active" checked="checked" />
				</c:if> <c:if test="${flower.isActive()==false}">
					<input type="checkbox" name="active" />
				</c:if> Còn hàng</td>
		</tr>
		<tr>
			<td colspan="2"><button>Lưu</button></td>
		</tr>
	</table>
</form>
<script>
	CKEDITOR.replace('description')
</script>