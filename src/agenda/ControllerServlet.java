package agenda;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ControllerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String parametro = req.getParameter("logica");
		String nomeDaClasse = "agenda." + parametro;
		
		try{
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeDaClasse);
			
			Logica logica = (Logica) classe.newInstance();
			logica.executa(req , res);
		}catch (Exception e){
			throw new ServletException("A logica de negocios causou uma exeção",e);
		}
	}
}
