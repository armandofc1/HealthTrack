
$(document).ready(function() {
    Validacoes.Init();

    $("#formAddAlimento").on('submit', function(event) {
        return Validacoes.ValidarForm();
    });
	
	$('.datepicker').datepicker({
		format: 'dd/mm/yyyy',
		language: 'pt-BR'
	});
});

var Validacoes = {
    campoAlimentoNome: null,
	campoAlimentoTipo: null,
	campoAlimentoCalorias: null,
    campoData: null,

    msgErro: '',

    Init: function() {
        $("#alertFormErros").alert();
        $("#alertFormErros").hide();

        Validacoes.campoAlimentoNome = $('#alimentoNome');
        Validacoes.campoAlimentoTipo = $('#alimentoTipo');
		Validacoes.campoAlimentoCalorias = $('#alimentoCalorias');
        Validacoes.campoData = $('#alimentoDataHora');

        Validacoes.campoAlimentoNome.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });
		
		Validacoes.campoAlimentoTipo.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });

		Validacoes.campoAlimentoCalorias.tooltip({
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

        Validacoes.campoAlimentoNome.blur(function() {
            Validacoes.ValidarAlimentoNome();
        });

		Validacoes.campoAlimentoTipo.blur(function() {
            Validacoes.ValidarAlimentoTipo();
        });
		
		Validacoes.campoAlimentoCalorias.blur(function() {
            Validacoes.ValidarAlimentoCalorias();
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
	ValidarAlimentoNome: function() {
        var campo = Validacoes.campoAlimentoNome;
        if (campo.val() == '') {
            var msg = 'O Nome alimento é obrigatório!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },
	
    ValidarAlimentoTipo: function() {
        var campo = Validacoes.campoAlimentoTipo;
        if (campo.val() == '') {
            var msg = 'O Tipo é obrigatório!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },
	
	ValidarAlimentoCalorias: function() {
        var campo = Validacoes.campoAlimentoCalorias;
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
		
        var validarAlimentoNome = Validacoes.ValidarAlimentoNome();
		var validarAlimentoTipo = Validacoes.ValidarAlimentoTipo();
		var validarAlimentoCalorias = Validacoes.ValidarAlimentoCalorias();
        var validarData = Validacoes.ValidarData();

        if (!validarAlimentoNome || !validarAlimentoTipo || !validarAlimentoCalorias || !validarData) {
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