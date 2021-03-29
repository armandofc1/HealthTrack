$(document).ready(function() {

    Validacoes.Init();

    $("#formAddPeso").on('submit', function(event) {
        return Validacoes.ValidarForm();
    });
	
	$('.datepicker').datepicker({
		format: 'dd/mm/yyyy',
		language: 'pt-BR'
	});
});

var Validacoes = {
    campoPeso: null,
    campoData: null,

    msgErro: '',

    Init: function() {
        $("#alertFormErros").alert();
        $("#alertFormErros").hide();

        Validacoes.campoPeso = $('#pesoValor');
        Validacoes.campoData = $('#pesoDataHora');

        Validacoes.campoPeso.tooltip({
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

        Validacoes.campoPeso.blur(function() {
            Validacoes.ValidarPeso();
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
    ValidarPeso: function() {
        var campo = Validacoes.campoPeso;
        if (campo.val() == '') {
            var msg = 'O Peso é obrigatório!';
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
		
        var validarPeso = Validacoes.ValidarPeso();
        var validarData = Validacoes.ValidarData();

        if (!validarPeso || !validarData) {
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