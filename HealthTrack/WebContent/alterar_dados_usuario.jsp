<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags"%>

<layout:genericpage>
	<jsp:attribute name="breadcrumb">
    	<li class="breadcrumb-item active" aria-current="page">Alterar dados do usuário</li>
	</jsp:attribute>
	<jsp:attribute name="sessao">Alterar dados do usuário</jsp:attribute>
    <jsp:attribute name="js">
    	<script src="js/alterar_dados_usuario.js"></script>
    </jsp:attribute>
	<jsp:body>
            <div class="alert alert-danger alert-dismissible" id="alertFormErros" role="alert">
                <strong>Atenção!</strong> <span id="formErros"></span>
            </div>
            <form id="formEditUsuario" action="UsuarioAtualizar" method="post">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="usuNome">Nome:</label>
							<input type="text" class="form-control" name="usuNome" id="usuNome" placeholder="Nome">
						</div>
						<div class="form-group">
							<label for="usuSobreNome">Sobrenome:</label>
							<input type="text" class="form-control" name="usuSobreNome" id="usuSobreNome" placeholder="Sobrenome">
						</div>
						<div class="form-group">
							<label for="usuDtNascimento">Data nascimento:</label>
							<input type="text" class="form-control datepicker" name="usuDtNascimento" id="usuDtNascimento" placeholder="dd/mm/aaaa">
						</div>
						<div class="form-group">
							<label for="usuSexo">Sexo:</label>
							<select class="form-control" name="usuSexo" id="usuSexo">
								<option value="1">Masculino</option>
								<option value="2">Feminino</option>
							</select>
						</div>
						<div class="form-group">
							<label for="usuAltura">Altura (em metros):</label>
							<input type="text" class="form-control" name="usuAltura" id="usuAltura" onkeypress="return Utils.isNumberKey(event,this)" placeholder="Altura">
						</div>
						<div class="form-group">
							<label for="usuEmail">Email:</label>
							<input type="text" class="form-control" name="usuEmail" id="usuEmail" placeholder="Email">
						</div>
						<div class="form-group">
							<label for="usuSenha">Senha:</label>
							<input type="password" class="form-control" name="usuSenha" id="usuSenha">
						</div>
						<div class="form-group">
							<label for="usuConfirmarSenha">Confirmar Senha:</label>
							<input type="password" class="form-control" name="usuConfirmarSenha" id="usuConfirmarSenha">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<button type="submit" class="btn btn-primary  ml-2 mb-2 mr-0 float-right">Alterar</button>
						<button type="reset" class="btn btn-secondary ml-2 mb-2 mr-0 float-right">Cancelar</button>
					</div>
				</div>
			</form>
    </jsp:body>
</layout:genericpage>