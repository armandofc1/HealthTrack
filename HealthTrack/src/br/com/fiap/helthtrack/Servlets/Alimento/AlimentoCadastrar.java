package br.com.fiap.helthtrack.Servlets.Alimento;

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

import br.com.fiap.helthtrack.controllers.AlimentoController;
import br.com.fiap.helthtrack.model.entities.*;

/**
 * Servlet implementation class AlimentoCadastrar
 */
@WebServlet("/AlimentoCadastrar")
public class AlimentoCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlimentoCadastrar() {
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
		int codigoTipo = Integer.parseInt(request.getParameter("alimentoTipo"));
		double calorias = Double.parseDouble(request.getParameter("alimentoCalorias"));
		Date dataConsumo = new Date();
		try {
			dataConsumo = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("alimentoDataHora"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		
		Alimento alimento = new Alimento();
		alimento.setCodigoUsuario(usuario.getCodigoUsuario());
		alimento.setNome(request.getParameter("alimentoNome"));
		alimento.setDescricao(request.getParameter("alimentoDescricao"));
		alimento.setTipo(new TipoAlimentacao(codigoTipo,"",true));
		alimento.setCalorias(calorias);
		alimento.setDataConsumo(dataConsumo);
	    
		AlimentoController controller = new AlimentoController(); 
		controller.cadastrar(alimento);
	    
		response.sendRedirect("list_alimentos.jsp");
	}

}
