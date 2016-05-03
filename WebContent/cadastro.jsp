<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Cadastro</title>
</head>
<body>
	<%
	
			String user = "";
			String nome = "";
			String email = "";
			String tel = "";
			String pass = "";
			
			if(session.getAttribute("us") != null){
				user =(String) session.getAttribute("us");
			}
	
			if(session.getAttribute("no") != null){
				nome =(String) session.getAttribute("no");
			}
			
			if(session.getAttribute("em") != null){
				email =(String) session.getAttribute("em");
			}
			
			if(session.getAttribute("te") != null){
				tel =(String) session.getAttribute("te");
			}
			
			if(session.getAttribute("pa") != null){
				pass =(String) session.getAttribute("pa");
			}
	
	 %>
<form action="cadastro">
	<table>
		<tr>
			<td>Usuário: </td>
			<td><input type="text" name="user" size="10"><%=user %> </td>
		</tr>
		<tr>
			<td>Nome Completo: </td>
			<td><input type="text" name="nome" size="20"><%=nome %> </td>
		</tr>
		<tr>
			<td>email: </td>
			<td><input type="email" name="email" size="15"><%=email %> </td>
		</tr>
		<tr>
			<td>Telefone: </td>
			<td><input type="number" name="tel" size="10"><%=tel %> </td>
		</tr>
		<tr>
			<td>Senha: </td>
			<td><input type="password" name="senha" size="10"><%=pass %> </td>
		</tr>
		<tr>
	
		<tr>
			<td><input type="submit" name="ok" value="Ok">
				<input type="submit" name="voltar" value="Voltar">
			</td>
		</tr>
	</table>
	
</form>

</body>
</html>