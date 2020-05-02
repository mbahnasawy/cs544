package cs544.exercise16_2;

import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
@Component
public class OpenSessionInViewFilter implements Filter {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSf(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO implement actual session in view filter code
		Transaction tx = null;
		
		try {
			
			tx = sessionFactory.getCurrentSession().beginTransaction();
			chain.doFilter(request, response);
			tx.commit();
			
		}catch(RuntimeException ex) {
			try {
				ex.printStackTrace();
				tx.rollback();
			}catch (RuntimeException rbEx) {
				// TODO: handle exception
				System.out.println("Could not rollback transaction " + rbEx); 
				rbEx.printStackTrace();
				 
			}
			
			throw ex;
		}
		
		// pass the request along the filter chain
		System.out.println("receiving request");
		//chain.doFilter(request, response);
		System.out.println("sending response");
	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
