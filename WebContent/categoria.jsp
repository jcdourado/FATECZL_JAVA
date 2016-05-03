<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Julio Cezar Dourado">
<meta name="viewport" content="width=device-width">
<title>Categoria</title>
</head>
<body>
	<form action="">
		<input type="hidden" name="id">
		<table>
		
			<tr>
				<td>Nome: </td>
				<td><input type="text" name="nome" size="20"></td>
			</tr>
			
		</table>
		
		<input type="submit" name="cmd" value="Inserir" >
		<input type="submit" name="cmd" value="Atualizar" >
		<input type="submit" name="cmd" value="Remover" >
		<input type="submit" name="cmd" value="Pesquisar" >
	</form>
</body>
</html>