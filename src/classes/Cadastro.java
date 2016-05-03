package classes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastro")
public class Cadastro extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("ok") != null){
			String user = req.getParameter("user");
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			String tel = req.getParameter("tel");
			String pass = req.getParameter("senha");
			
			req.getSession().setAttribute("us", user);
			req.getSession().setAttribute("no", nome);
			req.getSession().setAttribute("em", email);
			req.getSession().setAttribute("te", tel);
			req.getSession().setAttribute("pa", pass);
			
			resp.sendRedirect("cadastro.jsp");
		}
		else{
			resp.sendRedirect("index.jsp");;
		}
	}
}
