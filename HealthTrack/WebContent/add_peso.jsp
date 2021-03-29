<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags"%>

<layout:genericpage>
	<jsp:attribute name="breadcrumb">
				<li class="breadcrumb-item"><a href="list_peso.jsp">Peso</a></li>
				<li class="breadcrumb-item active" aria-current="page">Adicionar</li>
	</jsp:attribute>
	<jsp:attribute name="sessao">Cadastrar Peso</jsp:attribute>
    <jsp:attribute name="js">
		<script src="js/add_peso.js"></script>
    </jsp:attribute>
	<jsp:body>
            <div class="alert alert-danger alert-dismissible" id="alertFormErros" role="alert">
                <strong>Atenção!</strong> <span id="formErros"></span>
            </div>
            <form id="formAddPeso" action="PesoCadastrar" method="post">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="pesoValor">Peso:</label>
							<input type="text" class="form-control" name="pesoValor" id="pesoValor" onkeypress="return Utils.isNumberKey(event,this)" placeholder="Peso">
						</div>
						<div class="form-group">
							<label for="pesoDataHora">Data e hora:</label>
							<input type="type="text" class="form-control datepicker" name="pesoDataHora" id="pesoDataHora" placeholder="dd/mm/aaaa">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<button type="submit" id="btnCadastrar" class="btn btn-primary  ml-2 mb-2 mr-0 float-right">Cadastrar</button>
						<button type="reset" class="btn btn-secondary ml-2 mb-2 mr-0 float-right">Cancelar</button>
					</div>
				</div>
			</form>
    </jsp:body>
</layout:genericpage>