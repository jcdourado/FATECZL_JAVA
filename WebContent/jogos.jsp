<%@ page import="classes.Jogo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jogos</title>
</head>
<body>
<% 
	Jogo j = new Jogo();
	int dif = 1;
	if(session.getAttribute("jogo") != null){
		j = (Jogo) session.getAttribute("jogo");
		dif = j.getDificuldade();
	} 
%>

<form action="JogosController">
	<table>
		<tr>
			<td>Nome: </td>
			<td><input type="text" size="20" name="nome" 
			<%	if(j.getNome() != null){ %> 
					value="<%=j.getNome() %>"		
			<%	}  %>
			> </td>
		</tr>
		
		<tr>
		 	<td>Dificuldade: </td>
			<td>
				<select name="dificuldade">
					<option value="1" 
					<% if(dif == 1){ %>
						selected 
					<% } %>>Fácil</option>
					<option value="2"" 
					<% if(dif == 2){ %>
						selected 
					<% } %>>Médio</option>
					<option value="3"" 
					<% if(dif == 3){ %>
						selected 
					<% } %>>Difícil</option>
				</select>
			</td>
		</tr>
	</table>
	
	<input type="submit" name="cmd" value="Registrar">
	<input type="submit" name="cmd" value="Pesquisar">
	
</form>
	


</body>
</html>