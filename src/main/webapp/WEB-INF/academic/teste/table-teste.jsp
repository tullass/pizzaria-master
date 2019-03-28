<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<table
	class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr>
			<td>#</td>
			<td>Nome</td>
			<td>Idade</td>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaTestes}" var="t">
			<tr data-id="${t.id}">
				<td>${t.id}</td>
				<td>${t.name}</td>
				<td>${service.age}</td>
				<td><button type="button" class="btn btn-warning btn-edite">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-delete">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	
</table>