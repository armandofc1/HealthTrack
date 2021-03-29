<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags"%>

<layout:home>
	<jsp:attribute name="sessao">Home</jsp:attribute>
	<jsp:body>
            <div class="alert alert-primary" role="alert">
                <div class="row">
                    <div class="col align-items-center px-1">
                        <img src="images/default-user.png"
						class="rounded-circle mx-auto d-block"
						title="Armando Fereira Costa" />
                    </div>
                </div>

                <div class="row">
                    <div class="col px-1 text-center">
                        <strong><h4>${requestScope.usuarioNomeCompleto}</h4></strong>
                    </div>
                </div>
                <div class="row">
                    <div class="col-5 px-1 text-right">
                        Idade:
                    </div>
                    <div class="col px-1 text-left">
                        ${requestScope.usuarioIdade} anos
                    </div>
                </div>
                <div class="row">
                    <div class="col-5 px-1 text-right">
                        IMC:
                    </div>
                    <div class="col px-1 text-left">
                        ${requestScope.usuarioIMC}
                    </div>
                </div>
                <div class="row">
                    <div class="col-5 px-1 text-right">
                        Situação:
                    </div>
                    <div class="col px-1 text-left">
                        ${requestScope.usuarioSituacao}
                    </div>
                </div>
                <div class="row">
                    <div class="col-5 px-1 text-right">
                        Pressão:
                    </div>
                    <div class="col px-1 text-left">
                        ${requestScope.usuarioPressao}
                    </div>
                </div>
                <div class="row">
                    <div class="col p-1 d-flex">
                        <a class="btn btn-primary ml-auto"
						aria-pressed="true" href="alterar_dados_usuario.jsp">Alterar dados do usuário</a>
                    </div>
                </div>
            </div>
    </jsp:body>
</layout:home>