package agenda;

import java.util.Calendar;

public class TestaInsert {

	public static void main(String[] args)  {
		Contato contato1 = new Contato();
		contato1.setNome("caefdfgdfgdfglum");
		contato1.setEmail("contato@caelum.com.br");
		contato1.setEndereco("R. vergueiro 3185 cj87");
		contato1.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao1 = new ContatoDao();
		
		dao1.adiciona(contato1);
		
		Contato contato2 = new Contato();
		contato2.setNome("danilo");
		contato2.setEmail("contato@danilo.com.br");
		contato2.setEndereco("R. raiz amarela,356");
		contato2.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao2 = new ContatoDao();
		
		dao2.adiciona(contato2);
		
		System.out.println("Gravado!");
	}

}
