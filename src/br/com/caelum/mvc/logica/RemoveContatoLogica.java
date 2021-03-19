package br.com.caelum.mvc.logica;

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
		
		ContatoDao dao = new ContatoDao();
		
		boolean hasDeleted = dao.exclui(contato);
		
		if(hasDeleted) {
			System.out.println("Excluindo contato...");
		} else {
			System.out.println("Exclusão não realizada");
		}
		
		return "lista-contatos.jsp";
	}

}
