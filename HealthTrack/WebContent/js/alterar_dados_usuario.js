$(document).ready(function() {

    Validacoes.Init();

    $("#formEditUsuario").on('submit', function(event) {
        return Validacoes.ValidarForm();
    });
	
	$('.datepicker').datepicker({
		format: 'dd/mm/yyyy',
		language: 'pt-BR'
	});

});

var Validacoes = {
    campoNome: null,
    campoSobreNome: null,
    campoDtNascimento: null,
    campoAltura: null,
    campoEmail: null,
    campoSenha: null,
    campoConfirmarSenha: null,

    msgErro: '',

    Init: function() {
        $("#alertFormErros").alert();
        $("#alertFormErros").hide();

        Validacoes.campoNome = $('#usuNome');
        Validacoes.campoSobreNome = $('#usuSobreNome');
        Validacoes.campoDtNascimento = $('#usuDtNascimento');
        Validacoes.campoAltura = $('#usuAltura');
        Validacoes.campoEmail = $('#usuEmail');
        Validacoes.campoSenha = $('#usuSenha');
        Validacoes.campoConfirmarSenha = $('#usuConfirmarSenha');

        Validacoes.campoNome.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top',
			animation: true,
			delay: {show: 200, hide: 100}
        });

        Validacoes.campoSobreNome.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });

        Validacoes.campoDtNascimento.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });

        Validacoes.campoAltura.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });

        Validacoes.campoEmail.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });

        Validacoes.campoSenha.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });

        Validacoes.campoConfirmarSenha.tooltip({
            trigger: 'manual',
            title: function() {
                return $(this).attr('title');
            },
            placement: 'top'
        });

        Validacoes.campoNome.blur(function() {
            Validacoes.ValidarNome();
        });

        Validacoes.campoSobreNome.blur(function() {
            Validacoes.ValidarSobremoNome();
        });

        Validacoes.campoDtNascimento.blur(function() {
            Validacoes.ValidarDtNascimento();
        });

        Validacoes.campoAltura.blur(function() {
            Validacoes.ValidarAltura();
        });

        Validacoes.campoEmail.blur(function() {
            Validacoes.ValidarEmail();
        });

        Validacoes.campoSenha.blur(function() {
            Validacoes.ValidarSenha();
        });

        Validacoes.campoConfirmarSenha.blur(function() {
            Validacoes.ValidarConfirmarSenha();
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
    ValidarNome: function() {
        var campo = Validacoes.campoNome;
        if (campo.val() == '') {
            var msg = 'O Nome é obrigatório!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else if (campo.val().length < 4) {
            var msg = 'Nome de no mínimo de 3 caracteres!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },

    ValidarSobremoNome: function() {
        var campo = Validacoes.campoSobreNome;
        if (campo.val() == '') {
            var msg = 'O Sobrenome é obrigatório!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else if (campo.val().length < 4) {
            var msg = 'Sobrenome de no mínimo de 3 caracteres!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },
    ValidarDtNascimento: function() {
        var campo = Validacoes.campoDtNascimento;
        if (campo.val() == '') {
            var msg = 'A Data de nascimento é obrigatória!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },
    ValidarAltura: function() {
        var campo = Validacoes.campoAltura;
        if (campo.val() == '') {
            var msg = 'A Altura é obrigatória!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },
    ValidarEmail: function() {
        var campo = Validacoes.campoEmail;
		var parse_email = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (campo.val() == '') {
            var msg = 'O Email é obrigatório!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        }else if(!parse_email.test(campo.val())){
            var msg = 'O Email inválido!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
		} else {
            campo.tooltip("hide");
        }
        return true;
    },
    ValidarSenha: function() {
        var campo = Validacoes.campoSenha;
        if (campo.val() == '') {
            var msg = 'A senha é obrigatória!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },
    ValidarConfirmarSenha: function() {
        var campo = Validacoes.campoConfirmarSenha;
        if (campo.val() == '') {
            var msg = 'A Confirmação da senha é obrigatória!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else if (Validacoes.campoSenha.val() != '' && (Validacoes.campoSenha.val() != campo.val())) {
            var msg = 'A Confirmação está diferente da Senha!';
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
        var validarNome = Validacoes.ValidarNome();
        var validarSobremoNome = Validacoes.ValidarSobremoNome();
        var validarDtNascimento = Validacoes.ValidarDtNascimento();
        var validarAltura = Validacoes.ValidarAltura();
        var validarEmail = Validacoes.ValidarEmail();
        var validarSenha = Validacoes.ValidarSenha();
        var validarConfirmarSenha = Validacoes.ValidarConfirmarSenha();

        if (!validarNome || !validarSobremoNome || !validarDtNascimento || !validarAltura || !validarEmail || !validarSenha || !validarConfirmarSenha) {
            Validacoes.FormErros();
            return false;
        }else{
			Validacoes.ModalMensagem('Alterado com sucesso!');
			$("#alertFormErros").hide();
		}
		
        return true;
    },
	
	ModalMensagem: function(msg){
		$('#modalMensagem').find('.modal-body').html(msg);
		$('#modalMensagem').modal('show');
	}

};