package br.com.fiap.helthtrack.Servlets.AtividadeFisica;

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

import br.com.fiap.helthtrack.controllers.AtividadeFisicaController;
import br.com.fiap.helthtrack.model.entities.*;

/**
 * Servlet implementation class AtividadeFisicaCadastrar
 */
@WebServlet("/AtividadeFisicaCadastrar")
public class AtividadeFisicaCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtividadeFisicaCadastrar() {
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
		int codigoTipo = Integer.parseInt(request.getParameter("atividadeTipo"));
		double calorias = Double.parseDouble(request.getParameter("atividadeCalorias"));
		Date dataMedicao = new Date();
		try {
			dataMedicao = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("atividadeDataHora"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		
		AtividadeFisica atividade = new AtividadeFisica();
		atividade.setCodigoUsuario(usuario.getCodigoUsuario());
		atividade.setNome(request.getParameter("atividadeNome"));
		atividade.setDescricao(request.getParameter("atividadeDescricao"));
		atividade.setTipo(new TipoAtividadeFisica(codigoTipo,"",true));
	    atividade.setGastoCalorico(calorias);
	    atividade.setDataMedicao(dataMedicao);
	    
		AtividadeFisicaController controller = new AtividadeFisicaController(); 
		controller.cadastrar(atividade);
	    
		response.sendRedirect("list_atividades.jsp");
	}

}
