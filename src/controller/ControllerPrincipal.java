package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControllerPrincipal")
public class ControllerPrincipal extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if(cmd.equals("Produto")){
			resp.sendRedirect("produto.jsp");
		}else if(cmd.equals("Usuário")){
			resp.sendRedirect("usuario.jsp");
		}else if(cmd.equals("Categoria")){
			resp.sendRedirect("categoria.jsp");
		}else{
			resp.sendRedirect("produtoComprado.jsp");
		}
	}
}
