
$(document).ready(function() {
    Validacoes.Init();

    $("#formAddPressao").on('submit', function(event) {
        return Validacoes.ValidarForm();
    });
	
	$('.datepicker').datepicker({
		format: 'dd/mm/yyyy',
		language: 'pt-BR'
	});
});

var Validacoes = {
    campoPressaoSistolica: null,
	campoPressaoDiastolica: null,
    campoData: null,

    msgErro: '',

    Init: function() {
        $("#alertFormErros").alert();
        $("#alertFormErros").hide();

        Validacoes.campoPressaoSistolica = $('#pressaoSistolica');
        Validacoes.campoPressaoDiastolica = $('#pressaoDiastolica');
        Validacoes.campoData = $('#pressaoDataHora');

        Validacoes.campoPressaoSistolica.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });
		
		Validacoes.campoPressaoDiastolica.tooltip({
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

        Validacoes.campoPressaoSistolica.blur(function() {
            Validacoes.ValidarPressaoSistolica();
        });

		Validacoes.campoPressaoDiastolica.blur(function() {
            Validacoes.ValidarPressaoDiastolica();
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
	
	ValidarPressaoSistolica: function() {
        var campo = Validacoes.campoPressaoSistolica;
        if (campo.val() == '') {
            var msg = 'A Pressão sistólica é obrigatória!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },
	
    ValidarPressaoDiastolica: function() {
        var campo = Validacoes.campoPressaoDiastolica;
        if (campo.val() == '') {
            var msg = 'A Pressão diastólica é obrigatória!';
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
		
        var validarPressaoSistolica = Validacoes.ValidarPressaoSistolica();
		var validarPressaoDiastolica = Validacoes.ValidarPressaoDiastolica();
        var validarData = Validacoes.ValidarData();

        if (!validarPressaoSistolica || !validarPressaoDiastolica || !validarData) {
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