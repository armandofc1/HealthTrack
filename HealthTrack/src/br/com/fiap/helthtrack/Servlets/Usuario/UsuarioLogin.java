package br.com.fiap.helthtrack.Servlets.Usuario;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.helthtrack.controllers.UsuarioController;
import br.com.fiap.helthtrack.model.entities.*;
import br.com.fiap.helthtrack.model.enums.Sexo;

/**
 * Servlet implementation class UsuarioLogin
 */
@WebServlet("/UsuarioLogin")
public class UsuarioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioLogin() {
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
		String usuarioLogin = request.getParameter("inputEmail");
		String senha = request.getParameter("inputPassword");
		
		UsuarioController controller = new UsuarioController();
		Usuario usuario = new Usuario();
		try {
			usuario = controller.login(usuarioLogin, senha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("usuario", usuario);
		
		if(usuario.getLogin() != null && !usuario.getLogin().isEmpty()) {
			response.sendRedirect("Home");
		}else {
			response.sendRedirect("index.jsp");
		}
	}

}
