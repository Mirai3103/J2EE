<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>Thêm mới hoa</h3>
<form action="FlowerServlet?action=insert" method="post"
	enctype="multipart/form-data">
	<table class="table">
		<tr>
			<td>Mã hoa</td>
			<td><input type="text" name="flowerid" /></td>
		</tr>
		<tr>
			<td>Tên hoa</td>
			<td><input type="text" name="flowername" /></td>
		</tr>
		<tr>
			<td>Đơn vị tính</td>
			<td><input type="text" name="unit" /></td>
		</tr>
		<tr>
			<td>Giá</td>
			<td><input type="text" name="price" value="0" /></td>
		</tr>
		<tr>
			<td>Giá cũ</td>
			<td><input type="text" name="priceold" value="0" /></td>
		</tr>
		<tr>
			<td>Mô tả ngắn</td>
			<td><textarea name="brief"></textarea></td>
		</tr>
		<tr>
			<td>Mô tả đầy đủ</td>
			<td><textarea name="description"></textarea></td>
		</tr>
		<tr>
			<td>Ảnh</td>
			<td><input type="file" name="picture" /></td>
		</tr>
		<tr>
			<td>Tình trạng</td>
			<td><input type="checkbox" name="active" checked="checked" />Còn
				hàng</td>
		</tr>
		<tr>
			<td colspan="2"><button>Lưu</button></td>
		</tr>
	</table>
</form>
<script>
	CKEDITOR.replace('description')
</script>