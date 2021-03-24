package br.com.caelum.agenda.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*") // define onde ser� aplicado o filtro (todas requisi��es)
public class FiltroTempoDeExecucao implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// c�digo que executa antes de seguir para a servlet
		long tempoInicial = System.currentTimeMillis();

		// prossegue para servlet
		chain.doFilter(request, response);

		// c�digo que executa ap�s execu��o da servlet
		long tempoFinal = System.currentTimeMillis();

		String uri = ((HttpServletRequest) request).getRequestURI();
		String parametros = ((HttpServletRequest) request).getParameter("logica");

		System.out.println("Tempo de requisi��o de " + uri + "?logica=" + parametros + " demorou(ms):"
				+ (tempoFinal - tempoInicial));
	}

}
