$(document).ready(function() {

    Validacoes.Init();

    $("#formLogin").on('submit', function(event) {
        return Validacoes.ValidarForm();
    });
	
});

var Validacoes = {
    campoEmail: null,
    campoSenha: null,
    
    Init: function() {

        Validacoes.campoEmail = $('#inputEmail');
        Validacoes.campoSenha = $('#inputPassword');

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

        Validacoes.campoEmail.blur(function() {
            Validacoes.ValidarEmail();
        });

        Validacoes.campoSenha.blur(function() {
            Validacoes.ValidarSenha();
        });
    },
    Clear: function() {
		Validacoes.campoEmail.val('');
		Validacoes.campoSenha.val('');
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
		Validacoes.CloseToolTip(campo);
	},
    ValidarEmail2: function() {
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
    
    ValidarEmail: function() {
        var campo = Validacoes.campoEmail;
        if (campo.val() == '') {
            var msg = 'O Login é obrigatório!';
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
            var msg = 'A Senha é obrigatória!';
			Validacoes.CriticaToolTip(campo,msg);
            return false;
        } else {
            campo.tooltip("hide");
        }
        return true;
    },
	
    ValidarForm: function() {
        var validarEmail = Validacoes.ValidarEmail();
        var validarSenha = Validacoes.ValidarSenha();

        if (!validarEmail || !validarSenha) {
            return false;
        }
        return true;
    },
	
	ModalMensagem: function(msg){
		$('#modalMensagem').find('.modal-body').html(msg);
		$('#modalMensagem').modal('show');
	}
};