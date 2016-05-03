package classes;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("ok") != null){
			String usuario = req.getParameter("user");
			String senha = req.getParameter("senha");
		
			req.getSession().setAttribute("us", usuario);
			req.getSession().setAttribute("se", senha);
			
			resp.sendRedirect("login.jsp");
		}
		else{
			resp.sendRedirect("index.jsp");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.jsp");
	}
	
}
