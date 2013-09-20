package agenda;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@SuppressWarnings("serial")
public class AdicionandoContatoServlet extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		log("iniciando a servlet");
	}
	
	@Override
	public void destroy(){
		super.destroy();
		log("Destruindo a servlet");
	}
	
	@Override
	protected void service (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		try{
			Date date = new SimpleDateFormat("dd/mm/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		}catch (ParseException e){
			out.println("Erro de Conversão de data");
			return;
		} catch (java.text.ParseException e) {
			out.println("Erro de conversão de data");
			return;
		}
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		Connection connection = (Connection) request
                .getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);
		dao.adiciona(contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("contatoAdicionado.jsp");
		rd.forward(request, response);
	}
}
