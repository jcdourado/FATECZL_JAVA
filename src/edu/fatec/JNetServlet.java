package edu.fatec;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MeuServlet")
public class JNetServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("Oi");
		String nome = req.getParameter("nome");
		String idade = req.getParameter("idade");
		try {
			resp.getWriter().write("<h1 style='color:green'>Olá  " +nome+ " tens "+idade+" </h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
