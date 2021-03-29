package br.com.fiap.helthtrack.Servlets.Peso;

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

import br.com.fiap.helthtrack.controllers.PesoController;
import br.com.fiap.helthtrack.model.entities.*;

/**
 * Servlet implementation class PesoCadastrar
 */
@WebServlet("/PesoCadastrar")
public class PesoCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesoCadastrar() {
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
		double afericao = Double.parseDouble(request.getParameter("pesoValor"));
		Date dataMedicao = new Date();
		try {
			dataMedicao = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("pesoDataHora"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		
		Peso peso = new Peso();
		peso.setCodigoUsuario(usuario.getCodigoUsuario());
		peso.setAfericao(afericao);
		peso.setDataMedicao(dataMedicao);
		
		PesoController controller = new PesoController();
		controller.cadastrar(peso);
		
		response.sendRedirect("list_peso.jsp");
	}

}
