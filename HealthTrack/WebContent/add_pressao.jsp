<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags"%>

<layout:genericpage>
	<jsp:attribute name="breadcrumb">
				<li class="breadcrumb-item"><a href="list_pressao.jsp">Pressão</a></li>
				<li class="breadcrumb-item active" aria-current="page">Adicionar</li>
	</jsp:attribute>
	<jsp:attribute name="sessao">Cadastrar Pressão</jsp:attribute>
    <jsp:attribute name="js">
		<script src="js/add_pressao.js"></script>
    </jsp:attribute>
	<jsp:body>
            <div class="alert alert-danger alert-dismissible" id="alertFormErros" role="alert">
                <strong>Atenção!</strong> <span id="formErros"></span>
            </div>
            <form id="formAddPressao" action="PressaoArterialCadastrar" method="post">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="pressaoSistolica">Pressão sistólica:</label>
							<input type="text" class="form-control" name="pressaoSistolica" id="pressaoSistolica" onkeypress="return Utils.isNumberKey(event,this)" placeholder="sistólica">
						</div>
						<div class="form-group">
							<label for="pressaoDiastolica">Pressão diastólica:</label>
							<input type="text" class="form-control" name="pressaoDiastolica" id="pressaoDiastolica" onkeypress="return Utils.isNumberKey(event,this)" placeholder="diastólica">
						</div>
						<div class="form-group">
							<label for="pressaoDataHora">Data e hora:</label>
							<input type="text" class="form-control datepicker" name="pressaoDataHora" id="pressaoDataHora" placeholder="dd/mm/aaaa">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<button type="submit" class="btn btn-primary  ml-2 mb-2 mr-0 float-right">Cadastrar</button>
						<button type="reset" class="btn btn-secondary ml-2 mb-2 mr-0 float-right">Cancelar</button>
					</div>
				</div>
			</form>
    </jsp:body>
</layout:genericpage>