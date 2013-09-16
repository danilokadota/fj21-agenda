package agenda;

import java.sql.Connection;
import java.sql.SQLException;



public class TestaConexao extends ConnectionFactory{

	public static void main (String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("conexao aberta");
		connection.close();
	}

}