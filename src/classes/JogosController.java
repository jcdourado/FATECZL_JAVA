package classes;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JogosController")
public class JogosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JogosDAO dao = new JogosDAO();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(cmd.equals("Registrar")){
			Jogo j = new Jogo();
			j.setNome(request.getParameter("nome"));
			j.setDificuldade(Integer.parseInt(request.getParameter("dificuldade")));
			try {
				dao.adicionar(j);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			String nome = request.getParameter("nome");
			try {
				Jogo j = dao.pesquisar(nome);
				request.getSession().setAttribute("jogo", j);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		response.sendRedirect("jogos.jsp");
		
	}

}
