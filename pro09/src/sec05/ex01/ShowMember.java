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
		
		HttpSession session = req.getSession(false); //이미 세션이 존재 하면 반환 없으면 null
		
		if(session != null) {
			isLogon = (boolean) session.getAttribute("isLogon");
			
			if(isLogon == true) {
				id = (String) session.getAttribute("login.id");
				pwd = (String) session.getAttribute("login.pwd");
				out.print("<html><body>");
				out.print("아이디 : "+id+"<br>");
				out.print("비밀번호 : "+pwd+"<br>");
				out.print("</body></html>");
			}else {
				resp.sendRedirect("login3.html");
			}
		}else{
			resp.sendRedirect("login3.html");
		}
	}

	
	
	
}
