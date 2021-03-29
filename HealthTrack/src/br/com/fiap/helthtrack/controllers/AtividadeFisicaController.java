package br.com.fiap.helthtrack.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.helthtrack.infra.*;
import br.com.fiap.helthtrack.model.dao.AtividadeFisicaDao;
import br.com.fiap.helthtrack.model.entities.*;

public class AtividadeFisicaController {

	public AtividadeFisicaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<AtividadeFisica> listar() throws ParseException{
		List<AtividadeFisica> lista = new ArrayList<AtividadeFisica>();
		AtividadeFisicaDao daoAtividadeFisica = DAOFactory.getAtividadeFisicaDAO();
		lista = daoAtividadeFisica.listar();
		return lista;
	}
	
	public void cadastrar(AtividadeFisica atividade) {
		AtividadeFisicaDao daoAtividadeFisica = DAOFactory.getAtividadeFisicaDAO();
		daoAtividadeFisica.cadastrar(atividade);
	}
	
	public void atualizar(AtividadeFisica atividade) {
		AtividadeFisicaDao daoAtividadeFisica = DAOFactory.getAtividadeFisicaDAO();
		daoAtividadeFisica.atualizar(atividade);
	}
	
	public void remover(int codigo) {
		AtividadeFisicaDao daoAtividadeFisica = DAOFactory.getAtividadeFisicaDAO();
		daoAtividadeFisica.remover(codigo);
	}
	
	public AtividadeFisica buscarPorCodigo(int codigo) {	
		AtividadeFisicaDao daoAtividadeFisica = DAOFactory.getAtividadeFisicaDAO();
		return daoAtividadeFisica.buscarPorCodigo(codigo);
	}
}
