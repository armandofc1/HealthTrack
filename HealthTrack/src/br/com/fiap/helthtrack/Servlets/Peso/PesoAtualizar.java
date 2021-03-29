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
 * Servlet implementation class PesoAtualizar
 */
@WebServlet("/PesoAtualizar")
public class PesoAtualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesoAtualizar() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		Peso peso = new Peso();		
		PesoController controller = new PesoController();
		peso = controller.buscarPorCodigo(codigo);
		
    	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");    
    	String dataMedicao = fmt.format(peso.getDataMedicao());
		
		request.setAttribute("codigo", peso.getCodigoPeso());
		request.setAttribute("pesoValor", peso.getAfericao());
		request.setAttribute("pesoDataHora", dataMedicao);
		request.getRequestDispatcher("edit_peso.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
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
		peso.setCodigoPeso(codigo);
		peso.setCodigoUsuario(usuario.getCodigoUsuario());
		peso.setAfericao(afericao);
		peso.setDataMedicao(dataMedicao);
		
		PesoController controller = new PesoController();
		controller.atualizar(peso);
		
		response.sendRedirect("list_peso.jsp");
	}

}
