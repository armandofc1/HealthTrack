<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags"%>

<layout:genericpage>
	<jsp:attribute name="breadcrumb">
				<li class="breadcrumb-item"><a href="list_atividades.jsp">Atividades Físicas</a></li>
				<li class="breadcrumb-item active" aria-current="page">Adicionar</li>
	</jsp:attribute>
	<jsp:attribute name="sessao">Cadastrar Atividade Física</jsp:attribute>
    <jsp:attribute name="js">
		<script src="js/add_atividade_fisica.js"></script>
    </jsp:attribute>
	<jsp:body>
			<div class="alert alert-danger alert-dismissible" id="alertFormErros" role="alert">
                <strong>Atenção!</strong> <span id="formErros"></span>
            </div>
            <form id="formAddAtividade" action="AtividadeFisicaCadastrar" method="post">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="atividadeNome">Nome da atividade:</label>
							<input type="text" class="form-control" name="atividadeNome" id="atividadeNome" placeholder="Atividade">
						</div>
						<div class="form-group">
							<label for="atividadeTipo">Tipo</label>
							<select class="form-control" name="atividadeTipo" id="atividadeTipo">
							<option value=""></option>
							<option value="1">Aeróbico</option>
							<option value="2">Anaróbico</option>
							<option value="3">Funcional</option>
							<option value="4">Cárdio Vascular</option>
							</select>
						</div>
						<div class="form-group">
							<label for="atividadeDescricao">Descrição:</label>
							<textarea class="form-control" name="atividadeDescricao" id="atividadeDescricao" rows="3"></textarea>
						</div>
						<div class="form-group">
							<label for="atividadeCalorias">Número de calorias:</label>
							<input type="text" class="form-control" name="atividadeCalorias" id="atividadeCalorias" onkeypress="return Utils.isNumberKey(event,this)" placeholder="Calorias">
						</div>
						<div class="form-group">
							<label for="atividadeDataHora">Data e hora:</label>
							<input type="text" class="form-control datepicker" name="atividadeDataHora" id="atividadeDataHora" placeholder="dd/mm/aaaa">
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