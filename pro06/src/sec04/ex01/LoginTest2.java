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
				out.print("관리자로 로그인 하셨니다.<br>");
				out.print("<input type='button' value ='회원정보 수정하기' > ");
				out.print("<input type='button' value ='회원정보 삭제하기' ><br>");
				out.print("</body>");
				out.print("</html>");
			}else {
				out.print("<html>");
				out.print("<body>");
				out.print(user_id+"님이 로그인 하셨니다.");
				out.print("</body>");
				out.print("</html>");
			}
			
		}else {
			out.print("<html>");
			out.print("<body>");
			out.print("아이디를 입력하세요.!!<br>");
			out.print("<a href='http://localhost:8080/pro06/test01/login.html' >로그인 창으로 이동</a>");
			out.print("</body>");
			out.print("</html>");
		}
	}
}
