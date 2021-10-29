package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


//@WebFilter("/*")
public class EncoderFilter implements Filter {

	ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.print("utf-8 ���ڵ� ....");
		
		context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.print("doFilter ȣ��");
		
		req.setCharacterEncoding("utf-8");
		
		String context = ((HttpServletRequest)req).getContextPath();
		String pathinfo = ((HttpServletRequest)req).getRequestURI();
		String realPath = req.getRealPath(pathinfo);
		
		String msg = "Context ���� : "+ context;
		       msg +="\n URI ���� :" + pathinfo;
		       msg +="\n ������ ���� :" + realPath;
		       
		System.out.println(msg);
		 
		chain.doFilter(req, resp); //�������ͷ� �ѱ�� �۾��� ����
	}

   

}
