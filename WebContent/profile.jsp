<%@page import="java.io.PrintWriter"%>
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<title>Home</title>
</head>
<body>
	<%
		HttpSession reqSession = request.getSession();
	PrintWriter user = response.getWriter();
	user.println("Olá, " + reqSession.getAttribute("login"));
	%>

	<form action="ServletConfirm" method="post" class="form">
		Nome <input type="text" name="name"> 
		
		Data de Nascimento <input	type="text" name="dob" placeholder="dd/mm/aaaa"> 
		
		Endereço <input type="text"	name="address"> 
		
		Tefefone <input type="tel" name="phone">

		<div class="buttons">
			<input type="submit" value="Cadastrar"> 
			<input type="reset"	value="Limpar">
		</div>

	</form>
</body>
</html>