<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Julio Cezar Dourado">
<meta name="viewport" content="width=device-width">
<title>Produto comprado</title>
</head>
<body>
	<form action="">
		<input type="hidden" name="id">
		<table>
			
			<tr>
				<td>Produto: </td>
				<td><select name="produto"></select></td>
			</tr>
			
			<tr>
				<td>Quantidade: </td>
				<td><input type="number" name="qtd" size="4"></td>
			</tr>
			
			<tr>
				<td>Custo Unitário: </td>
				<td><input type="number" name="custoUnitario" size="4" disabled></td>
			</tr>
			
			<tr>
				<td>Custo Total: </td>
				<td><input type="number" name="custoTotal" size="4" disabled></td>
			</tr>
			
			<tr>
				<td>Frete:  </td>
				<td><input type="number" name="frete" size="4" disabled></td>
			</tr>
			
			<tr>
				<td>Impostos: </td>
				<td><input type="number" name="impostos" size="4" disabled></td>
			</tr>
			
			<tr>
				<td>Estado de Destino: </td>
				<td><input type="text" name="estado" size="20"></td>
			</tr>
			
			<tr>
				<td>Preço final: </td>
				<td><input type="number" name="precoFinal" size="4" disabled></td>
			</tr>
			
		</table>
		
		<input type="submit" name="cmd" value="Inserir" >
		<input type="submit" name="cmd" value="Atualizar" >
		<input type="submit" name="cmd" value="Remover" >
		<input type="submit" name="cmd" value="Pesquisar" >
	
	</form>

</body>
</html>