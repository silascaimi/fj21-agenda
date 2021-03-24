package br.com.caelum.agenda.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*") // define onde será aplicado o filtro (todas requisições)
public class FiltroTempoDeExecucao implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// código que executa antes de seguir para a servlet
		long tempoInicial = System.currentTimeMillis();

		// prossegue para servlet
		chain.doFilter(request, response);

		// código que executa após execução da servlet
		long tempoFinal = System.currentTimeMillis();

		String uri = ((HttpServletRequest) request).getRequestURI();
		String parametros = ((HttpServletRequest) request).getParameter("logica");

		System.out.println("Tempo de requisição de " + uri + "?logica=" + parametros + " demorou(ms):"
				+ (tempoFinal - tempoInicial));
	}

}
