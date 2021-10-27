package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		String user_id  = req.getParameter("user_id");
		String user_pwd  = req.getParameter("user_pwd");
		String user_address  = req.getParameter("user_address");
		
		
		out.print("<html><body>");
		if(user_id != null && user_id.length() != 0) {
			out.print("�̹� �α��� ���� �Դϴ�.<br><br>");
			out.print("ù��° �������� �Ѱ��� ���̵� :"+user_id+"<br>");
			out.print("ù��° �������� �Ѱ��� �н����� :"+user_pwd+"<br>");
			out.print("ù��° �������� �Ѱ��� �ּ� :"+user_address+"<br>");
			
		}else {
			out.print("�α��� ���� �ʾҽ��ϴ�.<br>");
			out.print("�ٽ� �α��� �ϼ���.<br>");
			out.print("<a href = '/pro09/login.html' >�α���â���� �̵��ϱ� </a> ");
		}
		
		
		
		out.print("</body></html>");
		
	}
	
}
