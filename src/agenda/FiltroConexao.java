package agenda;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.mysql.jdbc.Connection;

public class FiltroConexao implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException{
		try {
			Connection connection = (Connection) new ConnectionFactory().getConnection();
			
			request.setAttribute("conexao", connection);
			
			chain.doFilter(request, response);
			
			connection.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
