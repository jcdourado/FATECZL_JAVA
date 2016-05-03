package root;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EscolaSambaController")
public class EscolaSambaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String numAlas = request.getParameter("numAlas");
		String qtdComponentes = request.getParameter("qtdComponentes");
		String totalPontos = request.getParameter("totalPontos");
		String apresentacao = request.getParameter("apresentacao");
		
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("Cadastrar")){
			EscolaSamba escola = new EscolaSamba();
			escola.setId(Integer.parseInt(id));
			escola.setNome(nome);
			escola.setNumeroAlas(Integer.parseInt(numAlas));
			escola.setQtdComponentes(Integer.parseInt(qtdComponentes));
			escola.setTotalPontos(Float.parseFloat(totalPontos));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				escola.setApresentacao(sdf.parse(apresentacao));
			} catch (ParseException e) {
				escola.setApresentacao(null);
				e.printStackTrace();
			}	
			
			EscolaSambaDAO dao = new EscolaSambaDAO();
			try {
				dao.adicionar(escola);
				getServletContext().setAttribute("msg", "Escola adicionada com sucesso!");
			} catch (SQLException e) {
				getServletContext().setAttribute("msg", "Erro na adição!");
				e.printStackTrace();
			}
		}
		
		try {
			response.sendRedirect("Carnaval.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
