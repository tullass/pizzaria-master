<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div >
	<div >
		<div class="container">
			<form id="form-teste" method="post">
				
				<div class="modal-body">
					<label for="name">Nome: </label>
					<input id="name" name="name" class="form-control">
					
					<label for="age">Idade: </label>
					<input id="age" name="age" class="form-control">

				</div>
				<div>
					<button id="btn-save" type="button" class="btn btn-default">Guardar</button>
				</div>
			</form>
		</div>
	</div>
</div>