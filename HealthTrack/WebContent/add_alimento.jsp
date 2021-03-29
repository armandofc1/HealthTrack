<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags"%>

<layout:genericpage>
	<jsp:attribute name="breadcrumb">
				<li class="breadcrumb-item"><a href="list_alimentos.jsp">Alimentos</a></li>
				<li class="breadcrumb-item active" aria-current="page">Adicionar</li>
	</jsp:attribute>
	<jsp:attribute name="sessao">Cadastrar Alimento</jsp:attribute>
    <jsp:attribute name="js">
		<script src="js/add_alimento.js"></script>
    </jsp:attribute>
	<jsp:body>
            <div class="alert alert-danger alert-dismissible" id="alertFormErros" role="alert">
                <strong>Atenção!</strong> <span id="formErros"></span>
            </div>
            <form id="formAddAlimento" action="AlimentoCadastrar" method="post">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="alimentoNome">Nome Alimento:</label>
							<input type="text" class="form-control" name="alimentoNome" id="alimentoNome" placeholder="Alimento">
						</div>
						<div class="form-group">
							<label for="alimentoTipo">Tipo:</label>
							<select class="form-control" name="alimentoTipo" id="alimentoTipo">
							<option value=""></option>
							<option value="1">Café da manhã</option>
							<option value="2">Almoço</option>
							<option value="3">Lanche</option>
							<option value="4">Jantar</option>
							<option value="5">Ceia</option>
							</select>
						</div>
						<div class="form-group">
							<label for="alimentoDescricao">Descrição:</label>
							<textarea class="form-control" name="alimentoDescricao" id="alimentoDescricao" rows="3"></textarea>
						</div>
						<div class="form-group">
							<label for="alimentoCalorias">Número de calorias:</label>
							<input type="text" class="form-control" name="alimentoCalorias" id="alimentoCalorias" onkeypress="return Utils.isNumberKey(event,this)" placeholder="calorias">
						</div>
						<div class="form-group">
							<label for="alimentoDataHora">Data e hora:</label>
							<input type="text" class="form-control datepicker" name="alimentoDataHora" id="alimentoDataHora" placeholder="dd/mm/aaaa">
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