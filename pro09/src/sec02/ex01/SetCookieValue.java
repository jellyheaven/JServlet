package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setcookie")
public class SetCookieValue extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		//Calendar todate = Calendar.getInstance();
		Date d = new Date();
		
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("서블릿 프로그램 입니다.", "utf-8"));
		
		//cookie.setMaxAge(24*60*60); //하루 유효 기간 지정
		cookie.setMaxAge(-1); //세션쿠키 : 파일 저장이 아닌 브라우저 메모리 저장 함. 
		
		resp.addCookie(cookie); //쿠키 추가 
		
		out.print("현재 시간: "+d +"<br>");
		out.print("문자열을 Cookie에 저장합니다.");
		
	}
	
}
