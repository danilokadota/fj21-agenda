package agenda;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {
	@Override
	public void executa (HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("executando primeira logica e redirecionando..." );
		RequestDispatcher rd = request.getRequestDispatcher("primeira-logica.jsp");
		rd.forward(request, response);
	}
}
