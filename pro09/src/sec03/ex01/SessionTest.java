package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out =  resp.getWriter();
		
		HttpSession session = req.getSession(); //세션 생성
		
		
		out.print("세션 아이디:"+session.getId()+"<br>"); 
		out.print("최초 세션 생성시간:"+new Date(session.getCreationTime())+"<br>");
		out.print("최근 세션 접근시간:"+new Date(session.getLastAccessedTime())+"<br>");
		out.print("기본 세션 유효시간:"+session.getMaxInactiveInterval()+"<br>");
		
		session.setMaxInactiveInterval(5); //초로 재설정
		
		out.print("세션 유효시간:"+session.getMaxInactiveInterval()+"<br>");
		
		if(session.isNew()) {
			out.print("새 세션이 만들어 졌습니다.");
		}
	}
	
}
