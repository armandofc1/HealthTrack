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
    <link href="lib/datepicker/css/datepicker.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" />
</head>

<body>
    <header>
        <!-- Fixed navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-primary">
            <div class="navbar-brand">
				<a class="navbar-brand" href="home.jsp">
					<div class="glyphicon glyphicon-scale logo_login"></div>HEALTH TRACK
				</a>	
            </div>
        </nav>
    </header>

    <!-- Begin page content -->
    <main role="main" class="container ht-main">
        <div class="container">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <h3>Cadastro de Usuário</h3>
            </div>
            <div class="alert alert-danger alert-dismissible" id="alertFormErros" role="alert">
                <strong>Atenção!</strong> <span id="formErros"></span>
            </div>
            <form id="formAddUsuario" action="UsuarioCadastrar" method="post">
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
                            <input type="text" class="form-control" name="usuEmail" id="usuEmail" placeholder="email">
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
                        <button type="submit" class="btn btn-primary  ml-2 mb-2 mr-0 float-right">Cadastrar</button>
						<button type="reset" class="btn btn-secondary ml-2 mb-2 mr-0 float-right">Cancelar</button>
                    </div>
                </div>
            </form>
        </div>
    </main>

    <footer class="ht-footer">
        <div class="container">
            <span>&copy; HEALTH TRACK-2018</span>
        </div>
    </footer>

	<div id="modalMensagem" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
		  <div class="modal-header">
			<h6 class="modal-title" id="exampleModalLabel">HEALTH TRACK</h6>
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span>
			</button>
		  </div>
		  <div class="modal-body"></div>
		</div>
	  </div>
	</div>
	
    <script src="lib/jquery-3.2.1.slim.min.js"></script>
    <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="lib/datepicker/js/bootstrap-datepicker.js"></script>
	<script src="lib/datepicker/js/locales/bootstrap-datepicker.pt-BR.js"></script>
    <script src="js/common.js"></script>
    <script src="js/add_usuario.js"></script>
</body>

</html>