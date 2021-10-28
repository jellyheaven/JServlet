package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/show")
public class ShowMember extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		String id ="" , pwd ="";
		boolean isLogon = false;
		
		HttpSession session = req.getSession(false); //�̹� ������ ���� �ϸ� ��ȯ ������ null
		
		if(session != null) {
			isLogon = (boolean) session.getAttribute("isLogon");
			
			if(isLogon == true) {
				id = (String) session.getAttribute("login.id");
				pwd = (String) session.getAttribute("login.pwd");
				out.print("<html><body>");
				out.print("���̵� : "+id+"<br>");
				out.print("��й�ȣ : "+pwd+"<br>");
				out.print("</body></html>");
			}else {
				resp.sendRedirect("login3.html");
			}
		}else{
			resp.sendRedirect("login3.html");
		}
	}

	
	
	
}
