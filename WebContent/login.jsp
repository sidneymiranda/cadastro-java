<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<title>Login</title>
</head>
<body>

	<%
		HttpSession requestSession = request.getSession();
	if (requestSession.getAttribute("login") != null && requestSession.getAttribute("password") != null) {
		RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
		rd.forward(request, response);
	}
	%>

	<form action="profile" method="post" class="form">
		Login <input type="text" name="login" required> <br>
		Senha <input type="password" name="password" required> <br>

		<div class="buttons">
			<input type="submit" value="Entrar"> 
			<input type="reset" value="Limpar">
		</div>

	</form>
</body>
</html>