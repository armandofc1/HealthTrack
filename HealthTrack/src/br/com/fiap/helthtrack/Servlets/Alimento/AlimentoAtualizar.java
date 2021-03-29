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
 * Servlet implementation class AlimentoAtualizar
 */
@WebServlet("/AlimentoAtualizar")
public class AlimentoAtualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlimentoAtualizar() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		Alimento alimento = new Alimento();
		
		AlimentoController controller = new AlimentoController();
		alimento = controller.buscarPorCodigo(codigo);
		
    	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");    
    	String dataConsumo = fmt.format(alimento.getDataConsumo());
		
		request.setAttribute("codigo", alimento.getCodigoAlimentacao());
		request.setAttribute("alimentoNome", alimento.getNome());
		request.setAttribute("alimentoDescricao", alimento.getDescricao());
		request.setAttribute("alimentoTipo", alimento.getTipo().getCodigoTipoAlimentacao());
		request.setAttribute("alimentoCalorias", alimento.getCalorias());
		request.setAttribute("alimentoDataHora", dataConsumo);	
		request.getRequestDispatcher("edit_alimento.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
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
		alimento.setCodigoAlimentacao(codigo);
		alimento.setCodigoUsuario(usuario.getCodigoUsuario());
		alimento.setNome(request.getParameter("alimentoNome"));
		alimento.setDescricao(request.getParameter("alimentoDescricao"));
		alimento.setTipo(new TipoAlimentacao(codigoTipo,"",true));
		alimento.setCalorias(calorias);
		alimento.setDataConsumo(dataConsumo);
	    
		AlimentoController controller = new AlimentoController();  
		controller.atualizar(alimento);
	    
		response.sendRedirect("list_alimentos.jsp");
	}

}
