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
		
		String context = req.getContextPath(); //���ؽ�Ʈ ��� 
		String url = req.getRequestURL().toString();	//url ����
		String mapping = req.getServletPath(); //���� ���� ���
		String uri = req.getRequestURI(); //Uri ����
		
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Test Servlet2</title>");		
		out.print("</head>");
		out.print("<body >");
		out.print("<b>TestServlet2�Դϴ�.</b><br>");
		out.print("<b>���ؽ�Ʈ �̸� : "+context+"</b><br>");
		out.print("<b>��ü ��� : "+url+"</b><br>");
		out.print("<b>���� �̸� : "+mapping+"</b><br>");
		out.print("<b>URI : "+uri+"</b><br>");
		
		out.print("</body>");		
		out.print("</html>");
	}
	
}
