package br.com.fiap.helthtrack.controllers;

import br.com.fiap.helthtrack.infra.*;
import br.com.fiap.helthtrack.model.dao.PesoDao;
import br.com.fiap.helthtrack.model.entities.*;

import java.util.List;
import java.util.ArrayList;
import java.text.ParseException;


public class PesoController {

	public PesoController() {
		super();
	}

	public List<Peso> listar() throws ParseException{
		List<Peso> lista = new ArrayList<Peso>();		
		PesoDao daoPeso = DAOFactory.getPesoDAO();
		lista = daoPeso.listar();
		return lista;
	}
	
	public void cadastrar(Peso peso) {
		PesoDao daoPeso = DAOFactory.getPesoDAO();
		daoPeso.cadastrar(peso);
	}
	
	public void atualizar(Peso peso) {
		PesoDao daoPeso = DAOFactory.getPesoDAO();
		daoPeso.atualizar(peso);
	}
	
	public void remover(int codigo) {
		PesoDao daoPeso = DAOFactory.getPesoDAO();
		daoPeso.remover(codigo);
	}
	
	public Peso buscarPorCodigo(int codigo) {	
		PesoDao daoPeso = DAOFactory.getPesoDAO();
		return daoPeso.buscarPorCodigo(codigo);
	}
	
	public Peso ultimoPeso(int codigo) {	
		PesoDao daoPeso = DAOFactory.getPesoDAO();
		return daoPeso.ultimoPeso(codigo);
	}

}
