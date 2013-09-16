package agenda;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MinhaServlet extends HttpServlet {
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
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
	}
}
