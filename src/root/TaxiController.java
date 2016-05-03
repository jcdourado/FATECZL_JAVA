package root;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TaxiController")
public class TaxiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String registro = request.getParameter("registro");
		String alvara = request.getParameter("alvara");
		String cnh = request.getParameter("cnh");
		String validade = request.getParameter("validade");
		String nome = request.getParameter("nome");

		// ver se ja existe a lista

		Object o = getServletContext().getAttribute("lista");
		List<Taxi> list = new ArrayList<Taxi>();
		if(o != null && o instanceof ArrayList<?>){
			list = (List<Taxi>)o;
		}
		HttpSession session = request.getSession();

		String cmd = request.getParameter("cmd");
		
		if("Inserir".equals(cmd)){
			Taxi t = new Taxi();
			t.setAlvara(alvara);
			t.setCnh(cnh);
			t.setNome(nome);
			t.setRegistro(registro);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				t.setValidade(sdf.parse(validade));
			} catch (ParseException e) {
				t.setValidade(null);
				e.printStackTrace();
			} 
			
			list.add(t);

			session.setAttribute("msg", "Taxi inserido com sucesso!, há " + list.size() + " taxis no BD.");
		} else if ("Pesquisar".equals(cmd)) {
			List<Taxi> novaLista = new ArrayList<Taxi>();
			for(Taxi t : list){
				if(t != null && t.getNome() != null && t.getNome().contains(nome)){
					novaLista.add( t ); 
				}
			}
			session.setAttribute("ENCONTRADOS", novaLista);
		}
		
		getServletContext().setAttribute("lista", list);
		
		response.sendRedirect("Taxi.jsp");
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String registro = request.getParameter("registro");
		String cmd = request.getParameter("cmd");
		Object o = getServletContext().getAttribute("lista");
		List<Taxi> list = new ArrayList<Taxi>();
		if(o != null && o instanceof ArrayList<?>){
			list = (List<Taxi>)o;
		}
		HttpSession session = request.getSession();
		if ("Remover".equals(cmd)) { 
			List<Taxi> novaLista = (List<Taxi>)session.getAttribute("ENCONTRADOS");
			if (novaLista != null && novaLista.size() > 0) {
				Iterator<Taxi> it = novaLista.iterator();
				
				while(it.hasNext()){
					Taxi t = it.next();
					if(t != null && t.getRegistro() != null && 
									t.getRegistro().equals(registro)){
						it.remove();
						list.remove( t );
					}
				}
			}
		}
		response.sendRedirect("Taxi.jsp");
	}

}
