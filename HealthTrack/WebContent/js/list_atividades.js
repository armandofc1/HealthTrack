$(document).ready(function() {
	$('#grid').DataTable();
});

function SelecionarRegisro(valor){
	$("#registroSelecionado").val(valor);
}

function Excluir(){
	location.href = "AtividadeFisicaRemover?codigo="+$("#registroSelecionado").val();
}