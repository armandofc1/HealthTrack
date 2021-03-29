package br.com.fiap.helthtrack.Servlets.AtividadeFisica;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.helthtrack.controllers.AtividadeFisicaController;
import br.com.fiap.helthtrack.model.entities.*;

/**
 * Servlet implementation class AtividadeFisicaListar
 */
@WebServlet("/AtividadeFisicaListar")
public class AtividadeFisicaListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtividadeFisicaListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AtividadeFisicaController controller = new AtividadeFisicaController();
		List<AtividadeFisica> lista = new ArrayList<AtividadeFisica>();

		try {
			lista = controller.listar();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
	    for (AtividadeFisica atividade : lista) {
	    	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
	    	String dataMedicao = fmt.format(atividade.getDataMedicao());
	    	
	    	out.println("<tr>"); 
			out.println("<td>"+dataMedicao+"</td>"); 
			out.println("<td>"+atividade.getTipo().getNome()+"</td>");
			out.println("<td>"+atividade.getNome()+"</td>");
			out.println("<td>"+atividade.getGastoCalorico()+"</td>");
			
	    	out.println("<td>"); 
			out.println("<a class=\"btn btn-outline-primary btn-sm\" aria-pressed=\"true\" href=\"AtividadeFisicaAtualizar?codigo="+atividade.getCodigoAtividadeFisica()+"\">Editar</a>"); 
			out.println("<button type=\"button\" class=\"btn btn-outline-primary btn-sm\" onclick=\"SelecionarRegisro('"+atividade.getCodigoAtividadeFisica()+"');\" aria-pressed=\"true\" data-toggle=\"modal\" data-target=\"#excluirModal\">Excluir</button>");
			out.println("</td>"); 
			out.println("</tr>"); 
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
