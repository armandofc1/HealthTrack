package br.com.fiap.helthtrack.controllers;

import br.com.fiap.helthtrack.infra.*;
import br.com.fiap.helthtrack.model.dao.AlimentoDao;
import br.com.fiap.helthtrack.model.entities.*;

import java.util.List;
import java.util.ArrayList;
import java.text.ParseException;

public class AlimentoController {

	public AlimentoController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Alimento> listar() throws ParseException{
		List<Alimento> lista = new ArrayList<Alimento>();
		AlimentoDao daoAlimento = DAOFactory.getAlimentoDAO();
		lista = daoAlimento.listar();
		return lista;
	}
	
	public void cadastrar(Alimento alimento) {
		AlimentoDao daoAlimento = DAOFactory.getAlimentoDAO();
		daoAlimento.cadastrar(alimento);
	}
	
	public void atualizar(Alimento alimento) {
		AlimentoDao daoAlimento = DAOFactory.getAlimentoDAO();
		daoAlimento.atualizar(alimento);
	}
	
	public void remover(int codigo) {
		AlimentoDao daoAlimento = DAOFactory.getAlimentoDAO();
		daoAlimento.remover(codigo);
	}
	
	public Alimento buscarPorCodigo(int codigo) {	
		AlimentoDao daoAlimento = DAOFactory.getAlimentoDAO();
		return daoAlimento.buscarPorCodigo(codigo);
	}

}
