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
		
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("���� ���α׷� �Դϴ�.", "utf-8"));
		
		//cookie.setMaxAge(24*60*60); //�Ϸ� ��ȿ �Ⱓ ����
		cookie.setMaxAge(-1); //������Ű : ���� ������ �ƴ� ������ �޸� ���� ��. 
		
		resp.addCookie(cookie); //��Ű �߰� 
		
		out.print("���� �ð�: "+d +"<br>");
		out.print("���ڿ��� Cookie�� �����մϴ�.");
		
	}
	
}
