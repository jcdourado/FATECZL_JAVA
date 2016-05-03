<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Carnaval</title>
</head>
<body>
	<form action="./EscolaSambaController" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="number" name="id"></td>		
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome"></td>		
			</tr>
			<tr>
				<td>Numero de Alas:</td>
				<td><input type="number" name="numAlas"></td>		
			</tr>
			<tr>
				<td>Quantidade de Componentes:</td>
				<td><input type="number" name="qtdComponentes" ></td>		
			</tr>
			<tr>
				<td>Total de Pontos:</td>
				<td><input type="number" name="totalPontos"></td>		
			</tr>
			<tr>
				<td>Apresentação:</td>
				<td><input type="date" name="apresentacao" placeholder="mm/dd/yyyy"></td>		
			</tr>
		</table>
		<input type="submit" value="Cadastrar" name="cmd">
		<input type="submit" value="Pesquisar" name="cmd">
	</form>

	<%
		Object o = getServletContext().getAttribute("msg");
		if(o != null && o instanceof String){
			String msg = (String)o;
	%> 		
			<h1> <%=msg %></h1>
	<%
		}
		session.setAttribute("msg",null);
	%>
</body>
</html>