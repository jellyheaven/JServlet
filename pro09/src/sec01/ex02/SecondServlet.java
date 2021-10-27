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
			out.print("이미 로그인 상태 입니다.<br><br>");
			out.print("첫번째 서블릿에서 넘겨준 아이디 :"+user_id+"<br>");
			out.print("첫번째 서블릿에서 넘겨준 패스워드 :"+user_pwd+"<br>");
			out.print("첫번째 서블릿에서 넘겨준 주소 :"+user_address+"<br>");
			
		}else {
			out.print("로그인 하지 않았습니다.<br>");
			out.print("다시 로그인 하세요.<br>");
			out.print("<a href = '/pro09/login.html' >로그인창으로 이동하기 </a> ");
		}
		
		
		
		out.print("</body></html>");
		
	}
	
}
