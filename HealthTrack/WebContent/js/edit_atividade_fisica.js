
$(document).ready(function() {
    Validacoes.Init();

    $("#formAddAtividade").on('submit', function(event) {
        return Validacoes.ValidarForm();
    });
	
	$('.datepicker').datepicker({
		format: 'dd/mm/yyyy',
		language: 'pt-BR'
	});
	
	$("#atividadeTipo").val($("#tipoCodigo").val());
});

var Validacoes = {
    campoAtividadeNome: null,
	campoAtividadeTipo: null,
	campoAtividadeCalorias: null,
    campoData: null,

    msgErro: '',

    Init: function() {
        $("#alertFormErros").alert();
        $("#alertFormErros").hide();

        Validacoes.campoAtividadeNome = $('#atividadeNome');
        Validacoes.campoAtividadeTipo = $('#atividadeTipo');
		Validacoes.campoAtividadeCalorias = $('#atividadeCalorias');
        Validacoes.campoData = $('#atividadeDataHora');

        Validacoes.campoAtividadeNome.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });
		
		Validacoes.campoAtividadeTipo.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });

		Validacoes.campoAtividadeCalorias.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });
		
        Validacoes.campoData.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });

        Validacoes.campoAtividadeNome.blur(function() {
            Validacoes.ValidarAtividadeNome();
        });

		Validacoes.campoAtividadeTipo.blur(function() {
            Validacoes.ValidarAtividadeTipo();
        });
		
		Validacoes.campoAtividadeCalorias.blur(function() {
            Validacoes.ValidarAtividadeCalorias();
        });
		
        Validacoes.campoData.blur(function() {
            Validacoes.ValidarData();
        });
    },
    Clear: function() {
        Validacoes.MenssagemErro('');
    },
	CloseToolTip: function(campo){
	   setTimeout(function () {
		campo.tooltip('hide');
		campo.css('border-color', '');
	   }, 3000);
	},
	CriticaToolTip: function(campo, msg){
	    campo.attr('title', msg);
        campo.tooltip("show");
		campo.css('border-color', 'red');
		Validacoes.MenssagemErro(msg);
		Validacoes.CloseToolTip(campo);
	},
	ValidarAtividadeNome: function() {
        var campo = Validacoes.campoAtividadeNome;
        if (campo.val() == '') {
            var msg = 'O Nome da atividade é obrigatório!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },
	
    ValidarAtividadeTipo: function() {
        var campo = Validacoes.campoAtividadeTipo;
        if (campo.val() == '') {
            var msg = 'O Tipo da atividade é obrigatório!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },
	
	ValidarAtividadeCalorias: function() {
        var campo = Validacoes.campoAtividadeCalorias;
        if (campo.val() == '') {
            var msg = 'Número de calorias é obrigatório!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },
	
    ValidarData: function() {
        var campo = Validacoes.campoData;
        if (campo.val() == '') {
            var msg = 'A Data é obrigatória!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },
	
    MenssagemErro: function(msg) {
        if (msg == '') {
            Validacoes.msgErro = '';
        } else {
            Validacoes.msgErro += '<br>' + msg;
        }
        return Validacoes.msgErro;
    },

    FormErros: function() {
        if (Validacoes.msgErro != '') {
            $('#formErros').html(Validacoes.msgErro);
            $("#alertFormErros").show();
            Validacoes.MenssagemErro('');
        }
    },

    ValidarForm: function() {
        Validacoes.MenssagemErro('');
		
        var validarAtividadeNome = Validacoes.ValidarAtividadeNome();
		var validarAtividadeTipo = Validacoes.ValidarAtividadeTipo();
		var validarAtividadeCalorias = Validacoes.ValidarAtividadeCalorias();
        var validarData = Validacoes.ValidarData();

        if (!validarAtividadeNome || !validarAtividadeTipo || !validarAtividadeCalorias || !validarData) {
            Validacoes.FormErros();
            return false;
        }else{
			Validacoes.ModalMensagem('Cadastrado com sucesso!');
			$("#alertFormErros").hide();
		}
		
        return true;
    },
	
	ModalMensagem: function(msg){
		$('#modalMensagem').find('.modal-body').html(msg);
		$('#modalMensagem').modal('show');
	}
};