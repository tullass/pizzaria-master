<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
<table
	class="table able-striped ">
	<thead>
		<tr>
			<th >Descricao</th>
			<th >Editar</th>
			<th >Deletar</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${subjects}" var="subject">
			<tr data-id="${subject.id}">
				<td>${subject.description}</td>
				<td><button type="button" class="btn btn-warning btn-edite">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-delete">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td>Disciplinas existentes: <span id="quantidade-subjects">${subjects.size()}</span></td>
		</tr>
	</tfoot>
</table>
</div>