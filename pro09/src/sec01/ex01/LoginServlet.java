package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * hidden 태그를 이용한 웹페이지 연동 테스트
 * */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
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
			   data	+= "아이디:"+user_id+"<br>";
			   data	+= "패스워드:"+user_pwd+"<br>";
			   data	+= "주소:"+user_address+"<br>";
			   data	+= "email:"+user_email+"<br>";
			   data	+= "휴대전화:"+user_hp+"<br>";
			   data	+= "</body></html>";	   
		
		out.print(data);
	}

	
	
	

	

	
}
