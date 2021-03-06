<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags"%>

<layout:genericpage>
	<jsp:attribute name="breadcrumb">
				<li class="breadcrumb-item active" aria-current="page">Atividades Físicas</li>
	</jsp:attribute>
	<jsp:attribute name="sessao">Atividades Físicas</jsp:attribute>
    <jsp:attribute name="js">
    	<script src="lib/DataTables/datatables.min.js"></script>
		<script src="js/list_atividades.js"></script>
    </jsp:attribute>
	<jsp:body>
			<div class="ht-header-table">
                <a class="btn btn-primary" aria-pressed="true" href="add_atividade_fisica.jsp">Adicionar</a>
            </div>
            
			<input type="hidden" id="registroSelecionado" name="registroSelecionado">    
			<table id="grid" class="table table-striped table-sm">
		        <thead>
		            <tr>
                        <th class="ht-data-table">Data</th>
                        <th>Tipo</th>
                        <th>Nome</th>
                        <th>Calorias</th>
                        <th class="ht-bt-table"></th>
		            </tr>
		        </thead>
		        <jsp:include page="/AtividadeFisicaListar"/>
		    </table>

        <div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="excluirModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="excluirModalLabel">Atenção</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                    </div>
                    <div class="modal-body">
                        Tem certeza que deseja excluir?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
                        <button type="button" class="btn btn-primary" onclick="Excluir()">Sim</button>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</layout:genericpage>