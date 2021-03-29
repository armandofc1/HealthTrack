package br.com.fiap.helthtrack.Servlets.Peso;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.helthtrack.controllers.PesoController;
import br.com.fiap.helthtrack.model.entities.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Servlet implementation class PesoListarServlet
 */
@WebServlet("/PesoListar")
public class PesoListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PesoListar() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PesoController controller = new PesoController();
		List<Peso> lista = new ArrayList<Peso>();

		try {
			lista = controller.listar();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
	    for (Peso peso : lista) {
	    	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");    
	    	String dataMedicao = fmt.format(peso.getDataMedicao());
	    	
	    	out.println("<tr>"); 
			out.println("<td>"+dataMedicao+"</td>"); 
			out.println("<td>"+peso.getAfericao()+"</td>"); 
	    	out.println("<td>"); 
			out.println("<a class=\"btn btn-outline-primary btn-sm\" aria-pressed=\"true\" href=\"PesoAtualizar?codigo="+peso.getCodigoPeso()+"\">Editar</a>"); 
			out.println("<button type=\"button\" class=\"btn btn-outline-primary btn-sm\" onclick=\"SelecionarRegisro('"+peso.getCodigoPeso()+"');\" aria-pressed=\"true\" data-toggle=\"modal\" data-target=\"#excluirModal\">Excluir</button>");
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
