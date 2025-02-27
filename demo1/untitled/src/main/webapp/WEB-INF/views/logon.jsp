<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập hệ thống</h2>
<c:if test="${param.error == 'true'}">
  <div style="color: red;">Sai tên đăng nhập hoặc mật khẩu</div>
</c:if>
<form action="Logon.do" method="post">
  <div>
    <label for="username">Tên đăng nhập:</label>
    <input type="text" id="username" name="username" required>
  </div>
  <div>
    <label for="password">Mật khẩu:</label>
    <input type="password" id="password" name="password" required>
  </div>
  <div>
    <button type="submit">Đăng nhập</button>
  </div>
</form>
</body>
</html>