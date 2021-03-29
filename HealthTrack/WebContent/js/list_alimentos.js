$(document).ready(function() {
	$('#grid').DataTable();
});

function SelecionarRegisro(valor){
	$("#registroSelecionado").val(valor);
}

function Excluir(){
	location.href = "AlimentoRemover?codigo="+$("#registroSelecionado").val();
}