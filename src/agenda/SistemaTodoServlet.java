package agenda;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SistemaTodoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String acao = request.getParameter("logica");
		ContatoDao dao = new ContatoDao();
		
		if (acao.equals("AdiciocaContato")) {
			Contato contato = new Contato();
			contato.setNome(request.getParameter("nome"));
			contato.setEndereco(request.getParameter("endereco"));
			contato.setEmail(request.getParameter("email"));
			dao.adiciona(contato);
			
			RequestDispatcher rd = request.getRequestDispatcher("/contatoAdicionado.jsp");
			rd.forward(request, response);
		}else if (acao.equals("ListaContatos")) {
			
		}else if (acao.equals("RemoveContato")) {
			
		}
	}
}
