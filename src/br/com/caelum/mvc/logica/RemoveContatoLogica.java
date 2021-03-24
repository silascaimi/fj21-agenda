package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class RemoveContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		//Captura a connection criada no Filter
		Connection con = (Connection) req.getAttribute("connection");
		ContatoDao dao = new ContatoDao(con);
		
		boolean hasDeleted = dao.exclui(contato);
		
		if(hasDeleted) {
			System.out.println("Excluindo contato...");
		} else {
			System.out.println("Exclusão não realizada");
		}
		
		return "mvc?logica=ListaContatosLogica";
	}

}
