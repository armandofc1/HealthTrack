package br.com.fiap.helthtrack.Servlets.PressaoArterial;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.helthtrack.controllers.PressaoArterialController;
import br.com.fiap.helthtrack.model.entities.*;

/**
 * Servlet implementation class PressaoArterialCadastrar
 */
@WebServlet("/PressaoArterialCadastrar")
public class PressaoArterialCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PressaoArterialCadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double diastolica = Double.parseDouble(request.getParameter("pressaoDiastolica"));
		double sistolica = Double.parseDouble(request.getParameter("pressaoSistolica"));
		Date dataMedicao = new Date();
		try {
			dataMedicao = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("pressaoDataHora"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		
		PressaoArterial pressao = new PressaoArterial();
		pressao.setCodigoUsuario(usuario.getCodigoUsuario());
		pressao.setDiastolica(diastolica);
		pressao.setSistolica(sistolica);
		pressao.setDataMedicao(dataMedicao);
	    
		PressaoArterialController controller = new PressaoArterialController();
		controller.cadastrar(pressao);
	    
		response.sendRedirect("list_pressao.jsp");
	}

}
