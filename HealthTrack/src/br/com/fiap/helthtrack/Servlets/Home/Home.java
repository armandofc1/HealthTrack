package br.com.fiap.helthtrack.Servlets.Home;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.helthtrack.controllers.PesoController;
import br.com.fiap.helthtrack.controllers.PressaoArterialController;
import br.com.fiap.helthtrack.model.entities.*;
import br.com.fiap.helthtrack.model.enums.Sexo;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		
    	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");    
		
    	PesoController controllerPeso = new PesoController();
		Peso peso = controllerPeso.ultimoPeso(usuario.getCodigoUsuario());
		
		PressaoArterialController controllerPressao = new PressaoArterialController();
		PressaoArterial pressao = controllerPressao.ultimaPressao(usuario.getCodigoUsuario());
		
    	String dataMedicaoPressao = fmt.format(pressao.getDataMedicao());
		String usuarioPressao = pressao.getDiastolica() + "/" + pressao.getSistolica() + " mmHg "+dataMedicaoPressao;

        String usuarioIMC = IMC(usuario, peso) + Situacao(usuario, peso);
		
		request.setAttribute("usuarioNomeCompleto", usuario.getNome() +" " + usuario.getSobrenome());
		request.setAttribute("usuarioIdade", usuario.idade());
		request.setAttribute("usuarioIMC", IMC(usuario, peso));
		request.setAttribute("usuarioSituacao", usuarioIMC);
		request.setAttribute("usuarioPressao", usuarioPressao);
		request.getRequestDispatcher("home.jsp").forward(request,response);
	}
	
	protected double IMC(Usuario usuario, Peso peso) {
		double imc = peso.getAfericao() / (usuario.getAltura()*usuario.getAltura());
		return imc;
	}
	
	protected String Situacao(Usuario usuario, Peso peso) {
		String usuarioIMC = "";
    	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String dataMedicaoPeso = fmt.format(peso.getDataMedicao());
		
		double imc = IMC(usuario, peso);
        if (imc < 19.1 && usuario.getSexo().equals(Sexo.Feminino)) {
        	usuarioIMC = imc + " abaixo do peso "+dataMedicaoPeso;
        } else if (imc > 19.1 && imc < 25.8 && usuario.getSexo().equals(Sexo.Feminino)) {
        	usuarioIMC = imc + " peso ideal"+dataMedicaoPeso;
        } else if (imc > 25.8 && imc < 27.3 && usuario.getSexo().equals(Sexo.Feminino)) {
        	usuarioIMC = imc + " marginalmente acima do peso"+dataMedicaoPeso;
        } else if (imc > 27.3 && imc < 32.3 && usuario.getSexo().equals(Sexo.Feminino)) {
        	usuarioIMC = imc + " acima do peso ideal"+dataMedicaoPeso;
        } else if (imc > 32.3 && usuario.getSexo().equals(Sexo.Feminino)) {
        	usuarioIMC = imc + " obeso"+dataMedicaoPeso;
        } else if (imc < 20.7 && usuario.getSexo().equals(Sexo.Masculino)) {
        	usuarioIMC = imc + " abaixo do peso"+dataMedicaoPeso;
        } else if (imc > 20.7 && imc < 26.4 && usuario.getSexo().equals(Sexo.Masculino)) {
        	usuarioIMC = imc + " peso ideal"+dataMedicaoPeso;
        } else if (imc > 26.4 && imc < 27.8 && usuario.getSexo().equals(Sexo.Masculino)) {
        	usuarioIMC = imc + " acima do peso"+dataMedicaoPeso;
        } else if (imc > 27.8 && imc < 31.1 && usuario.getSexo().equals(Sexo.Masculino)) {
        	usuarioIMC = imc + " peso ideal"+dataMedicaoPeso;
        } else if (imc > 31.1 && usuario.getSexo().equals(Sexo.Masculino)) {
        	usuarioIMC = imc + " obeso"+dataMedicaoPeso;
        }
		return usuarioIMC;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
