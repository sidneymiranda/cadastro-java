<%@taglib prefix="custom" uri="WEB-INF/tld/calcAge.tld"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Patient"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<title>Pacientes cadastrados</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/profile.jsp">Novo
		cadastro</a>
	<table class="table">
		<caption>
			<strong>TAELA DE PACIENTES</strong>
		</caption>
		<tr>
			<th>NOME</th>
			<th>DATA DE NASCIMENTO</th>
			<th>IDADE</th>
			<th>ENDEREÇO</th>
			<th>TELEFONE</th>
		</tr>

		<%
			ArrayList<Patient> list = (ArrayList<Patient>) session.getAttribute("listPatient");
		for (Patient patient : list) {
		%>
		<tr>
			<td><%=patient.getName()%></td>
			<td><%=patient.getDob()%></td>
			<td><custom:calcAge dob="<%=patient.getDob()%>" /></td>
			<td><%=patient.getAddress()%></td>
			<td><%=patient.getPhone()%></td>
		</tr>

		<%
			}
		%>
	</table>
</body>
</html>