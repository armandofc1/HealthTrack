package br.com.fiap.helthtrack.controllers;

import br.com.fiap.helthtrack.model.dao.PressaoArterialDao;
import br.com.fiap.helthtrack.model.entities.*;

import java.util.List;
import java.util.ArrayList;
import java.text.ParseException;

import br.com.fiap.helthtrack.infra.*;

public class PressaoArterialController {

	public PressaoArterialController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<PressaoArterial> listar() throws ParseException{
		List<PressaoArterial> lista = new ArrayList<PressaoArterial>();
		PressaoArterialDao daoPressaoArterial = DAOFactory.getPressaoArterialDAO();
		lista = daoPressaoArterial.listar();
		return lista;
	}
	
	public void cadastrar(PressaoArterial pressao) {
		PressaoArterialDao daoPressaoArterial = DAOFactory.getPressaoArterialDAO();
		daoPressaoArterial.cadastrar(pressao);
	}
	
	public void atualizar(PressaoArterial pressao) {
		PressaoArterialDao daoPressaoArterial = DAOFactory.getPressaoArterialDAO();
		daoPressaoArterial.atualizar(pressao);
	}
	
	public void remover(int codigo) {
		PressaoArterialDao daoPressaoArterial = DAOFactory.getPressaoArterialDAO();
		daoPressaoArterial.remover(codigo);
	}
	
	public PressaoArterial buscarPorCodigo(int codigo) {	
		PressaoArterialDao daoPressaoArterial = DAOFactory.getPressaoArterialDAO();
		return daoPressaoArterial.buscarPorCodigo(codigo);
	}
	
	public PressaoArterial ultimaPressao(int codigo) {	
		PressaoArterialDao daoPressaoArterial = DAOFactory.getPressaoArterialDAO();
		return daoPressaoArterial.ultimaPressao(codigo);
	}
}
