<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Tìm kiếm</title>
</head>
<body>
<h2>Trang tìm kiếm</h2>
<p>Xin chào, ${username}!</p>
<form action="Search.do" method="get">
  <div>
    <label for="searchTerm">Từ khóa:</label>
    <input type="text" id="searchTerm" name="searchTerm">
  </div>
  <div>
    <button type="submit">Tìm kiếm</button>
  </div>
</form>
<div>
  <a href="Logout.do">Đăng xuất</a>
</div>
</body>
</html>