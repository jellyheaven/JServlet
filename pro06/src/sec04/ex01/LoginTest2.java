package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginTest2")
public class LoginTest2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out =  resp.getWriter();
		
		if(user_id != null && (user_id.length() != 0) ) {
			if(user_id.equals("admin")) {
				out.print("<html>");
				out.print("<body>");
				out.print("�����ڷ� �α��� �ϼ̴ϴ�.<br>");
				out.print("<input type='button' value ='ȸ������ �����ϱ�' > ");
				out.print("<input type='button' value ='ȸ������ �����ϱ�' ><br>");
				out.print("</body>");
				out.print("</html>");
			}else {
				out.print("<html>");
				out.print("<body>");
				out.print(user_id+"���� �α��� �ϼ̴ϴ�.");
				out.print("</body>");
				out.print("</html>");
			}
			
		}else {
			out.print("<html>");
			out.print("<body>");
			out.print("���̵� �Է��ϼ���.!!<br>");
			out.print("<a href='http://localhost:8080/pro06/test01/login.html' >�α��� â���� �̵�</a>");
			out.print("</body>");
			out.print("</html>");
		}
	}
}
