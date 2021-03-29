<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="HEALTH TRACK, sistema para armazenar dados de saúde e atividades físicas." />
    <meta name="keywords" content="HEALTH TRACK, alimentação, peso, pressão, atividades físicas, saúde, calorias, acompanhamento, imc, medição" />
    <meta name="author" content="Armando Costa" />
    <link rel="icon" href="images/favicon.ico" />
    <title>HEALTH TRACK</title>
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="lib/bootstrap/css/bootstrap-glyphicons.min.css" rel="stylesheet" type="text/css" />
    <link href="css/signin.css" rel="stylesheet" />
</head>

<body class="text-center">

    <form id="formLogin" class="form-signin" action="UsuarioLogin" method="post">
        <div class="alert alert-secondary" role="alert">
            <div class="glyphicon glyphicon-scale logo_login"></div>
            <h1 class="h3 mb-3 font-weight-normal">Health Track</h1>
			<label for="inputEmail" class="sr-only">Login</label>
			<input type="text" name="inputEmail" id="inputEmail" class="form-control" placeholder="Login" required="" autofocus="" />
			<label for="inputPassword" class="sr-only">Senha</label>
			<input type="password" name="inputPassword" id="inputPassword" class="form-control" placeholder="Senha" required="" />
			<div class="row">
				<div class="col"><button type="submit" id="btnEntrar" class="btn btn-sm btn-primary btn-block">Entrar</button></div>
				<div class="col"><button class="btn btn-sm btn-primary btn-block" type="reset">Limpar</button></div>
			</div>
            <div class="row">
                <div class="col">
                    <a class="float-right" aria-pressed="true" data-toggle="modal" data-target="#esqueciModal">Esqueci minha senha</a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p>Não possui uma conta? <br />
                    <a href="add_usuario.jsp">Cadastrar Usuário</a></p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="mt-1 mb-3 text-muted">&copy;2018</p>
            </div>
        </div>
    </form>

    <div class="modal fade" id="esqueciModal" tabindex="-1" role="dialog" aria-labelledby="esqueciModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
		    <form id="formEsqueciSenha">
				<div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="esqueciModalLabel">Esqueci minha senha</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="recipient-name" class="form-control-label">Infome o e-mail do cadastro do usuário:</label>
                         <input type="email" class="form-control" id="recipient-name">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-primary">Enviar Senha</button>
                </div>
            </div>
			</form>
        </div>
    </div>

    <script src="lib/jquery-3.2.1.slim.min.js"></script>
    <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="js/common.js"></script>
	<script src="js/index.js"></script>
</body>

</html>