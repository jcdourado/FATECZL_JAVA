<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Julio Cezar Dourado">
<meta name="viewport" content="width=device-width">
<title>Usuario</title>
</head>
<body>
	<form action="">
		<input type="hidden" name="id">
		<table>
			
			<tr>
				<td>Nome: </td>
				<td><input type="text" name="nome" placeholder="Nome" size="20"></td>
			</tr>
			
			<tr>
				<td>UserID: </td>
				<td><input type="text" name="userId" placeholder="Usuário" size="20"></td>
			</tr>
			
			<tr>
				<td>Password: </td>
				<td><input type="password" placeholder="12345" name="password" size="20"></td>
			</tr>
			
			<tr>
				<td>Email: </td>
				<td><input type="email" placeholder="Email" name="email" size="20"></td>
			</tr>
			
			<tr>
				<td >Endereço: </td>
				<td>
					<input type="text" placeholder="Logradouro" name="logradpuro" size="20">
					<input type="number" name="número" size="20" placeholder="Número">
					<input type="text" name="complemento" size="20" placeholder="Complemento">
					<input type="text" name="bairro" size="20" placeholder="Bairro">
					<input type="text" name="cidade" size="20" placeholder="Cidade">
					<input type="text" name="estado" size="20" placeholder="Estado">
					<input type="text" name="pais" size="20" placeholder="País">
					<input type="text" name="cep" size="20" placeholder="CEP">
				</td>
			</tr>
			
			<tr>
				<td>Telefone: </td>
				<td>
					<input type="number" placeholder="DDD" name="ddd" size="3">
					<input type="number" placeholder="Número" name="numero" size="10">
					<input type="text" placeholder="Operadora" name="operadora" size="8">
				</td>
			</tr>
		</table>
		
		<input type="submit" name="cmd" value="Inserir" >
		<input type="submit" name="cmd" value="Atualizar" >
		<input type="submit" name="cmd" value="Remover" >
		<input type="submit" name="cmd" value="Pesquisar" >
	
	</form>
			
</body>
</html>