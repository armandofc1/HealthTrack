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
 * Servlet implementation class AtividadeFisicaAtualizar
 */
@WebServlet("/AtividadeFisicaAtualizar")
public class AtividadeFisicaAtualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtividadeFisicaAtualizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		AtividadeFisica atividade = new AtividadeFisica();
		AtividadeFisicaController controller = new AtividadeFisicaController();  
	    
		atividade = controller.buscarPorCodigo(codigo);
		
    	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");    
    	String dataMedicao = fmt.format(atividade.getDataMedicao());
		
		request.setAttribute("codigo", atividade.getCodigoAtividadeFisica());
		request.setAttribute("atividadeNome", atividade.getNome());
		request.setAttribute("atividadeDescricao", atividade.getDescricao());
		request.setAttribute("atividadeTipo", atividade.getTipo().getCodigoTipoAtividadeFisica());
		request.setAttribute("atividadeCalorias", atividade.getGastoCalorico());
		request.setAttribute("atividadeDataHora", dataMedicao);
		
		request.getRequestDispatcher("edit_atividade_fisica.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
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
		atividade.setCodigoAtividadeFisica(codigo);
		atividade.setCodigoUsuario(usuario.getCodigoUsuario());
		atividade.setNome(request.getParameter("atividadeNome"));
		atividade.setDescricao(request.getParameter("atividadeDescricao"));
		atividade.setTipo(new TipoAtividadeFisica(codigoTipo,"",true));
	    atividade.setGastoCalorico(calorias);
	    atividade.setDataMedicao(dataMedicao);
	    
		AtividadeFisicaController controller = new AtividadeFisicaController();  
		controller.atualizar(atividade);
	    
		response.sendRedirect("list_atividades.jsp");
	}

}
