package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Filter API ���� �׽�Ʈ*/

@WebServlet("/login")
public class LoginTest extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		String user_name = req.getParameter("user_name");
		String user_pwd = req.getParameter("user_pwd");
		
		out.print("<html><body>");
		out.print("���̵�� : " +user_name+"<br>");
		out.print("��й�ȣ�� : " +user_pwd+"<br>");
		out.print("</body></html>");
				
	}	
}
