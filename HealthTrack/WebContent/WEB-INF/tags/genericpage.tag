<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="sessao" fragment="true" %>
<%@attribute name="breadcrumb" fragment="true" required="false" %>
<%@attribute name="js" fragment="true" required="false" %>

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
    <link href="lib/DataTables/datatables.min.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" />
</head>

<body>
    <header>
        <!-- Fixed navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-primary">
            <a class="navbar-brand" href="Home">
                <div class="glyphicon glyphicon-scale logo_login"></div>HEALTH TRACK
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Navegação">
				<span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="nav nav-pills mr-auto">
                    <li class="nav-item ht-nav-item">
                        <a class="btn btn-outline-light btn-sm" aria-pressed="true" href="list_alimentos.jsp">Alimentos</a>
                    </li>
                    <li class="nav-item ht-nav-item">
                        <a class="btn btn-outline-light btn-sm" aria-pressed="true" href="list_atividades.jsp">Atividades Físicas</a>
                    </li>
                    <li class="nav-item ht-nav-item">
                        <a class="btn btn-outline-light btn-sm" aria-pressed="true" href="list_peso.jsp">Peso</a>
                    </li>
                    <li class="nav-item ht-nav-item">
                        <a class="btn btn-outline-light btn-sm" aria-pressed="true" href="list_pressao.jsp">Pressão</a>
                    </li>
                </ul>
                <a class="btn btn-outline-light btn-sm my-2 my-sm-0" aria-pressed="true" href="UsuarioSair">Sair</a>
            </div>
        </nav>
    </header>

    <!-- Begin page content -->
    <main role="main" class="container ht-main">
        <div class="container">
			<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
				<jsp:invoke fragment="breadcrumb"/>
			  </ol>
			</nav>
        	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        	<h3><jsp:invoke fragment="sessao"/></h3>
    		</div>
			<jsp:doBody/>          
        </div>
    </main>

    <footer class="ht-footer">
        <div class="container">
            <span>&copy; HEALTH TRACK-2018</span>
        </div>
    </footer>

    <script src="lib/jquery-3.2.1.slim.min.js"></script>
    <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="lib/datepicker/js/bootstrap-datepicker.js"></script>
	<script src="lib/datepicker/js/locales/bootstrap-datepicker.pt-BR.js"></script>
	<script src="js/common.js"></script>
	<jsp:invoke fragment="js"/>	
	
</body>

</html>