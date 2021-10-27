package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getcookie")
public class GetCookieValue extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		Cookie[] allvalue = req.getCookies();
		
		for (int i = 0; i < allvalue.length; i++) {
			if (allvalue[i].getName().equals("cookieTest")) {
				out.print("<h2>Cookie 값 가져오기 :"+URLDecoder.decode(allvalue[i].getValue(), "utf-8") +"</h2>");
			}
			
		}
	}
	
}
