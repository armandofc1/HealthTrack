package br.com.fiap.helthtrack.Servlets.Alimento;

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

import br.com.fiap.helthtrack.controllers.AlimentoController;
import br.com.fiap.helthtrack.model.entities.*;

/**
 * Servlet implementation class AlimentoListar
 */
@WebServlet("/AlimentoListar")
public class AlimentoListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlimentoListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlimentoController controller = new AlimentoController();
		List<Alimento> lista = new ArrayList<Alimento>();

		try {
			lista = controller.listar();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
	    for (Alimento alimento : lista) {
	    	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
	    	String dataConsumo = fmt.format(alimento.getDataConsumo());
	    	
	    	out.println("<tr>"); 
			out.println("<td>"+dataConsumo+"</td>"); 
			out.println("<td>"+alimento.getTipo().getNome()+"</td>");
			out.println("<td>"+alimento.getNome()+"</td>");
			out.println("<td>"+alimento.getCalorias()+"</td>");
			
	    	out.println("<td>"); 
			out.println("<a class=\"btn btn-outline-primary btn-sm\" aria-pressed=\"true\" href=\"AlimentoAtualizar?codigo="+alimento.getCodigoAlimentacao()+"\">Editar</a>"); 
			out.println("<button type=\"button\" class=\"btn btn-outline-primary btn-sm\" onclick=\"SelecionarRegisro('"+alimento.getCodigoAlimentacao()+"');\" aria-pressed=\"true\" data-toggle=\"modal\" data-target=\"#excluirModal\">Excluir</button>");
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
