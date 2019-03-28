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
			<td style="width: 10%">#</td>
			<td style="width: 50%">Nome</td>
			<td style="width: 20%">Categoria</td>
			<td style="width: 10%">Editar</td>
			<td style="width: 10%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${services}" var="service">
			<tr data-id="${service.id}">
				<td>${service.id}</td>
				<td>${service.description}</td>
				<td><button type="button" class="btn btn-warning btn-edite">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-delete">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">Servicos cadastrados: <span id="quantidade-services">${services.size()}</span></td>
		</tr>
	</tfoot>
</table>