package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * hidden �±׸� �̿��� �������� ���� �׽�Ʈ
 * */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init �޼��� ȣ��");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		String user_id  = req.getParameter("user_id");
		String user_pwd  = req.getParameter("user_pwd");
		String user_address  = req.getParameter("user_address");
		String user_email  = req.getParameter("user_email");
		String user_hp  = req.getParameter("user_hp");
		
		String data  = "<html><body>";
			   data	+= "���̵�:"+user_id+"<br>";
			   data	+= "�н�����:"+user_pwd+"<br>";
			   data	+= "�ּ�:"+user_address+"<br>";
			   data	+= "email:"+user_email+"<br>";
			   data	+= "�޴���ȭ:"+user_hp+"<br>";
			   data	+= "</body></html>";	   
		
		out.print(data);
	}

	
	
	

	

	
}
