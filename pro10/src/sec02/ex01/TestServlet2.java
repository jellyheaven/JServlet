package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		String context = req.getContextPath(); //컨텍스트 경로 
		String url = req.getRequestURL().toString();	//url 정보
		String mapping = req.getServletPath(); //서블릿 매핑 경로
		String uri = req.getRequestURI(); //Uri 정보
		
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Test Servlet2</title>");		
		out.print("</head>");
		out.print("<body >");
		out.print("<b>TestServlet2입니다.</b><br>");
		out.print("<b>컨텍스트 이름 : "+context+"</b><br>");
		out.print("<b>전체 경로 : "+url+"</b><br>");
		out.print("<b>매핑 이름 : "+mapping+"</b><br>");
		out.print("<b>URI : "+uri+"</b><br>");
		
		out.print("</body>");		
		out.print("</html>");
	}
	
}
