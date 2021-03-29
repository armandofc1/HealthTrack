package br.com.fiap.helthtrack.controllers;

import br.com.fiap.helthtrack.model.dao.UsuarioDao;
import br.com.fiap.helthtrack.model.entities.*;
import java.text.ParseException;

import br.com.fiap.helthtrack.infra.*;

public class UsuarioController {

	public UsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario login(String usuarioLogin, String senha) throws ParseException{
		Usuario usuario = new Usuario();		
		UsuarioDao daoUsuario = DAOFactory.getUsuarioDAO();
		usuario = daoUsuario.login(usuarioLogin, senha);
		return usuario;
	}
}
