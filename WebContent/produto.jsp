<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Julio Cezar Dourado">
<meta name="viewport" content="width=device-width">
<title>Produto</title>
</head>
<body>
	<form action="" enctype="application/x-www-form-urlencoded">
		<input type="hidden" name="id">
		<table>
			
			<tr>
				<td>Nome: </td>
				<td><input type="text" name="nome" size="20"></td>
			</tr>
			
			<tr>
				<td>Descrição: </td>
				<td><textarea name="descricao" cols="20" rows="2"></textarea></td>
			</tr>
			
			<tr>
				<td>Foto: </td>
				<td><input accept="image/*" type="file" name="foto"></td>
			</tr>
			
			<tr>
				<td>Preço: </td>
				<td><input type="number" name="preco" size="4"></td>
			</tr>
			
			<tr>
				<td>Unidade de medida: </td>
				<td><input type="text" name="unidMedida" size="4"></td>
			</tr>
			
			<tr>
				<td>Medida: </td>
				<td><input type="number" name="medida" size="4"></td>
			</tr>
			
			<tr>
				<td>Categoria: </td>
				<td>
					<select name="categoria"></select>
				</td>
			</tr>
			
			<tr>
				<td>Cidade: </td>
				<td><input type="text" size="20" name="cidade"></td>
			</tr>
			
			<tr>
				<td>Estado: </td>
				<td><input type="text" name="estado" size="20"></td>
			</tr>
			
			<tr>
				<td>País de origem: </td>
				<td><input type="text" name="paisOrigem" size="20"></td>
			</tr>
			
			<tr>	
				<td>Quantidade em estoque: </td>
				<td><input type="number" name="qtdEstoque" size="5"></td>
			</tr>
		</table>
		
		<input type="submit" name="cmd" value="Inserir" >
		<input type="submit" name="cmd" value="Atualizar" >
		<input type="submit" name="cmd" value="Remover" >
		<input type="submit" name="cmd" value="Pesquisar" >
	
	</form>
</body>
</html>