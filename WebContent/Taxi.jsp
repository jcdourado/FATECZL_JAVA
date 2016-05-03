<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="root.Taxi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Gestão de taxi</h1>
	
	<form action="./TaxiController" method="post">
		<table>
			<tr>	
				<td>Registro:</td>
				<td><input type="text" name="registro"></td>
			</tr>
			<tr>	
				<td>Alvara:</td>
				<td><input type="text" name="alvara"></td>
			</tr>
			<tr>	
				<td>CNH:</td>
				<td><input type="text" name="cnh"></td>
			</tr>
			<tr>	
				<td>Validade:</td>
				<td><input type="date" name="validade"></td>
			</tr>
			<tr>	
				<td>Registro:</td>
				<td><input type="text" name="registro"></td>
			</tr>
			<tr>	
				<td>Nome:</td>
				<td><input type="text" name="nome"></td>
			</tr>
			<tr>	
				<td><input type="submit" value="Inserir" name="cmd"></td>
				<td><input type="submit" value="Pesquisar" name="cmd"></td>
			</tr>
		</table>
		
		<% List<Taxi> listaEncontrados = (List<Taxi>)session.getAttribute("ENCONTRADOS");
			if(listaEncontrados != null && !listaEncontrados.isEmpty()){
		%>
		
		<table>
			<tr>
				<td>Registro</td>
				<td>Nome</td>
				<td>Alvara</td>
				<td>CNH</td>
				<td>Validade</td>
				<td>Acoes</td>
			</tr>
			<%
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				for(Taxi t : listaEncontrados){
			%>
			<tr>
				<td><%=t.getRegistro() %></td>
				<td><%=t.getNome() %></td>
				<td><%=t.getAlvara() %></td>
				<td><%=t.getCnh() %></td>
				<td><%=sdf.format(t.getValidade()) %></td>
				<td><a href="./TaxiController?registro=<%=t.getRegistro()%>&cmd=Remover">Remover</a><td>					
			<% } %>
		</table>
		
		<% } %>
			
	</form>


	
	<%
		Object o = session.getAttribute("msg");
		if(o != null && o instanceof String){
			String msg = (String)o;
	%>
		<h3><%=msg %></h3>
	<%
		session.setAttribute("msg",null);
		}
	%>
</body>
</html>