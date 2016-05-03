<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<%
		String us = "", se="";
		if(session.getAttribute("us") != null){
			 us = (String) session.getAttribute("us");
		}
		
		if(session.getAttribute("se") != null){
			se = (String) session.getAttribute("se");
		}
	 %>
<form action="login">
	<table>
		<tr>
			<td>Usuário: </td>
			<td><input type="text" name="user" size="10"> <%=us %></td>
		</tr>
		<tr>
			<td>Senha: </td>
			<td><input type="password" name="senha" size="10"><%=se %></td>
		</tr>
		<tr>
			<td><input type="submit" name="ok" value="Ok" ></td>
			<td><input type="submit" name="voltar"  value="Voltar"></td>
		</tr>
	</table>
</form>
</body>
</html>