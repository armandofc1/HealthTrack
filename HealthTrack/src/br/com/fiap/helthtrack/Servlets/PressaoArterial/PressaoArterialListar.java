package br.com.fiap.helthtrack.Servlets.PressaoArterial;

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

import br.com.fiap.helthtrack.controllers.PressaoArterialController;
import br.com.fiap.helthtrack.model.entities.*;

/**
 * Servlet implementation class PressaoArterialListar
 */
@WebServlet("/PressaoArterialListar")
public class PressaoArterialListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PressaoArterialListar() {
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PressaoArterialController controller = new PressaoArterialController();
		List<PressaoArterial> lista = new ArrayList<PressaoArterial>();

		try {
			lista = controller.listar();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
	    for (PressaoArterial pressao : lista) {
	    	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
	    	String dataMedicao = fmt.format(pressao.getDataMedicao());
	    	String classificacao = "Normal";
	    	
	    	out.println("<tr>"); 
			out.println("<td>"+dataMedicao+"</td>"); 
			out.println("<td>"+pressao.getSistolica()+" mmHg</td>");
			out.println("<td>"+pressao.getDiastolica()+" mmHg</td>");
			out.println("<td>"+classificacao+"</td>");
			
	    	out.println("<td>"); 
			out.println("<a class=\"btn btn-outline-primary btn-sm\" aria-pressed=\"true\" href=\"PressaoArterialAtualizar?codigo="+pressao.getCodigoPressaoArterial()+"\">Editar</a>"); 
			out.println("<button type=\"button\" class=\"btn btn-outline-primary btn-sm\" onclick=\"SelecionarRegisro('"+pressao.getCodigoPressaoArterial()+"');\" aria-pressed=\"true\" data-toggle=\"modal\" data-target=\"#excluirModal\">Excluir</button>");
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
