<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>

	<form action="/casadocodigo/produtos" method="post">
		<div>
			<form:errors path="produto.titulo" method="POST"/>
			<label>Titulo</label>
			<input type="text" name="produto.titulo">
		</div>
		<div>
			<label>Descrição</label>
			<textarea rows="10" cols="20" name="produto.descricao"></textarea>
		</div>
		<div>
			<label>Páginas</label>
			<input type="text" name="produto.paginas">
		</div>
		<c:forEach items="${tipos}" var="tipoPreco">
			<div>
				<label>${tipoPreco}</label>
				<input type="text" name="precos[${status.index}].valor">
				<input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}">
			</div>
		</c:forEach>
		<button type="submit">Cadastrar</button>
	</form>

</body>
</html>