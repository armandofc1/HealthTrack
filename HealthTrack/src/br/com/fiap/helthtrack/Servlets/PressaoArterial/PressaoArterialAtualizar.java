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
import br.com.fiap.helthtrack.model.entities.PressaoArterial;
import br.com.fiap.helthtrack.model.entities.Usuario;

/**
 * Servlet implementation class PressaoArterialAtualizar
 */
@WebServlet("/PressaoArterialAtualizar")
public class PressaoArterialAtualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PressaoArterialAtualizar() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		PressaoArterial pressao = new PressaoArterial();	
		PressaoArterialController controller = new PressaoArterialController(); 
	    pressao = controller.buscarPorCodigo(codigo);

    	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");    
    	String dataMedicao = fmt.format(pressao.getDataMedicao());
		
		request.setAttribute("codigo", pressao.getCodigoPressaoArterial());
		request.setAttribute("pressaoDiastolica", pressao.getDiastolica());
		request.setAttribute("pressaoSistolica", pressao.getSistolica());
		request.setAttribute("pressaoDataHora", dataMedicao);
		
		request.getRequestDispatcher("edit_pressao.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
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
		pressao.setCodigoPressaoArterial(codigo);
		pressao.setCodigoUsuario(usuario.getCodigoUsuario());
		pressao.setDiastolica(diastolica);
		pressao.setSistolica(sistolica);
		pressao.setDataMedicao(dataMedicao);
	    
		PressaoArterialController controller = new PressaoArterialController();
		controller.atualizar(pressao);
	    
		response.sendRedirect("list_pressao.jsp");
	}

}
