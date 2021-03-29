package br.com.fiap.helthtrack.Tests;
import br.com.fiap.helthtrack.model.dao.AtividadeFisicaDao;
import br.com.fiap.helthtrack.model.dao.AlimentoDao;
import br.com.fiap.helthtrack.model.dao.PesoDao;
import br.com.fiap.helthtrack.model.dao.PressaoArterialDao;
import br.com.fiap.helthtrack.model.dao.UsuarioDao;
import br.com.fiap.helthtrack.model.entities.*;
import br.com.fiap.helthtrack.model.enums.Sexo;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.fiap.helthtrack.controllers.PesoController;
import br.com.fiap.helthtrack.infra.*;

public class DaoTest {

	public static void main(String[] args) throws ParseException {
		
		Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse("1984-04-28");
		Usuario pessoa = new Usuario(2,"armandofc1","Armando","Costa",Sexo.Masculino, dataNascimento, 1.72, "foto.png", new Date(), true);
		pessoa.setSenha("pass123");
		//UsuarioDao daoUsuario = DAOFactory.getUsuarioDAO();
		//daoUsuario.cadastrar(pessoa);
		
		//Usuário
		System.out.println("Usuário:");
		System.out.println("----------------------------------");
		System.out.println("Login:"+pessoa.getLogin());
		System.out.println("Nome: "+pessoa.getNome() + " Sobrenome: "+pessoa.getSobrenome());
		System.out.println("Sexo: "+pessoa.getSexo().name());
		System.out.println(pessoa.getSexo().getValor());
		System.out.println("Idade: "+pessoa.idade());
		System.out.println("Altura: "+pessoa.getAltura());
		
		//Pesos
		Peso peso1 = new Peso();
		peso1.setCodigoUsuario(pessoa.getCodigoUsuario());
		peso1.setAfericao(85.6);
		peso1.setDataMedicao(new Date());

		Peso peso2 = new Peso();
		peso2.setCodigoUsuario(pessoa.getCodigoUsuario());
		peso2.setAfericao(92.5);
		peso2.setDataMedicao(new Date());
		
		Peso peso3 = new Peso();
		peso3.setCodigoUsuario(pessoa.getCodigoUsuario());
		peso3.setAfericao(69.5);
		peso3.setDataMedicao(new Date());
		
		Peso peso4 = new Peso();
		peso4.setCodigoUsuario(pessoa.getCodigoUsuario());
		peso4.setAfericao(98.5);
		peso4.setDataMedicao(new Date());
		
		Peso peso5 = new Peso();
		peso5.setCodigoUsuario(pessoa.getCodigoUsuario());
		peso5.setAfericao(75.5);
		peso5.setDataMedicao(new Date());

		PesoDao daoPeso = DAOFactory.getPesoDAO();
		//daoPeso.cadastrar(peso1);
		//daoPeso.cadastrar(peso2);
		//daoPeso.cadastrar(peso3);
		//daoPeso.cadastrar(peso4);
		//daoPeso.cadastrar(peso5);
		
		List<Peso> listaPesos = daoPeso.listar();
		
		System.out.println("Pesos:");
	    for (Peso peso : listaPesos) {
            System.out.println(peso.getAfericao());
        }
	    
	    //Pressoes
	    PressaoArterial pressao1 = new PressaoArterial();
	    pressao1.setCodigoUsuario(pessoa.getCodigoUsuario());
	    pressao1.setDiastolica(13.2);
	    pressao1.setSistolica(8.7);
	    pressao1.setDataMedicao(new Date());
	    
	    PressaoArterial pressao2 = new PressaoArterial();
	    pressao2.setCodigoUsuario(pessoa.getCodigoUsuario());
	    pressao2.setDiastolica(15.2);
	    pressao2.setSistolica(9.7);
	    pressao2.setDataMedicao(new Date());
	    
	    PressaoArterial pressao3 = new PressaoArterial();
	    pressao3.setCodigoUsuario(pessoa.getCodigoUsuario());
	    pressao3.setDiastolica(12.2);
	    pressao3.setSistolica(10.7);
	    pressao3.setDataMedicao(new Date());
	    
	    PressaoArterial pressao4 = new PressaoArterial();
	    pressao4.setCodigoUsuario(pessoa.getCodigoUsuario());
	    pressao4.setDiastolica(12.2);
	    pressao4.setSistolica(10.7);
	    pressao4.setDataMedicao(new Date());
	    
	    PressaoArterial pressao5 = new PressaoArterial();
	    pressao5.setCodigoUsuario(pessoa.getCodigoUsuario());
	    pressao5.setDiastolica(12.2);
	    pressao5.setSistolica(10.7);
	    pressao5.setDataMedicao(new Date());
	    
	    PressaoArterialDao daoPressao = DAOFactory.getPressaoArterialDAO();    
	    //daoPressao.cadastrar(pressao1);
	  //  daoPressao.cadastrar(pressao2);
	   // daoPressao.cadastrar(pressao3);
	   // daoPressao.cadastrar(pressao4);
	   // daoPressao.cadastrar(pressao5);
	    
	    List<PressaoArterial> listaPressoes = daoPressao.listar();
	    
		System.out.println("Pressões:");
	    for (PressaoArterial pressao : listaPressoes) {
            System.out.println("Diastolica: "+ pressao.getDiastolica() + " Sistolica: " + pressao.getSistolica());
        }
	    
	    //Alimentos
	    Alimento alimento1 = new Alimento();
	    alimento1.setCodigoUsuario(pessoa.getCodigoUsuario());
	    alimento1.setNome("macarrão");
	    alimento1.setDescricao("prato principal");
	    alimento1.setTipo(new TipoAlimentacao(2,"ALMOÇO",true));
	    alimento1.setDataConsumo(new Date());
	    alimento1.setCalorias(500);
	    
	    Alimento alimento2 = new Alimento();
	    alimento2.setCodigoUsuario(pessoa.getCodigoUsuario());
	    alimento2.setNome("Ovos mexidos");
	    alimento2.setDescricao("desjejum");
	    alimento2.setTipo(new TipoAlimentacao(1,"CAFÉ",true));
	    alimento2.setDataConsumo(new Date());
	    alimento2.setCalorias(800);
	    
	   AlimentoDao daoAlimento = DAOFactory.getAlimentoDAO();  
	   // daoAlimento.cadastrar(alimento1);
	   // daoAlimento.cadastrar(alimento2);
	    
	    List<Alimento> listaAlimentos = daoAlimento.listar();
	    
		System.out.println("Alimentos:");
	    for (Alimento alimento : listaAlimentos) {
	    	System.out.println(alimento.getNome() + " calorias: " + alimento.getCalorias());
        }
	    
	    //Atividade Física
	    AtividadeFisica atividade1 = new AtividadeFisica();
	    atividade1.setCodigoUsuario(pessoa.getCodigoUsuario());
	    atividade1.setNome("Corrida");
	    atividade1.setDescricao("Voltas no parque");
	    atividade1.setTipo(new TipoAtividadeFisica(3,"ALTA INTENSIDADE",true));
	    atividade1.setGastoCalorico(500.50);
	    atividade1.setDataMedicao(new Date());
	    
	    AtividadeFisica atividade2 = new AtividadeFisica();
	    atividade2.setCodigoUsuario(pessoa.getCodigoUsuario());
	    atividade2.setNome("Natação");
	    atividade2.setDescricao("100 metros");
	    atividade2.setTipo(new TipoAtividadeFisica(2,"INTENSIDADE MODERADA",true));
	    atividade2.setGastoCalorico(456.50);
	    atividade2.setDataMedicao(new Date());
	    
	    AtividadeFisica atividade3 = new AtividadeFisica();
	    atividade3.setCodigoUsuario(pessoa.getCodigoUsuario());
	    atividade3.setNome("Xadrez");
	    atividade3.setDescricao("duas partidas");
	    atividade3.setTipo(new TipoAtividadeFisica(1,"BAIXA INTENSIDADE",true));
	    atividade3.setGastoCalorico(300);
	    atividade3.setDataMedicao(new Date());
	    
	    AtividadeFisicaDao daoAtividadeFisica = DAOFactory.getAtividadeFisicaDAO();
	    
	    //daoAtividadeFisica.cadastrar(atividade1);
	   // daoAtividadeFisica.cadastrar(atividade2);
	   // daoAtividadeFisica.cadastrar(atividade3);
	    
	    List<AtividadeFisica> listaAtividadeFisica = daoAtividadeFisica.listar();
	    
		System.out.println("Atividades Físicas:");
	    for (AtividadeFisica atividade : listaAtividadeFisica) {
	    	System.out.println(atividade.getNome() + " calorias: " + atividade.getGastoCalorico());
        }

		PesoController controller = new PesoController();
		List<Peso> listaPesos1 = new ArrayList<Peso>();
		listaPesos1 = controller.listar();
		
	}

}
