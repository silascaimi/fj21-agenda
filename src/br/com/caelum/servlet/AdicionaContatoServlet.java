package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

// Utiliza anotion WebServlet para mapear o servlet ao invés de configurar no web.xml
// Apenas no Servlet 3
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 885926685202019945L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		// fazendo a conversão da data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
			return;
		}

		// monta o objeto Contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);

		
		//Captura a connection criada no Filter
		Connection con = (Connection) request.getAttribute("connection");
		ContatoDao dao = new ContatoDao(con);
		dao.adiciona(contato);

		// imprime o nome do contato que foi adicionado
		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
	  
	}
	
}