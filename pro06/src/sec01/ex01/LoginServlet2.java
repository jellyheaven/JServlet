package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String str_id = request.getParameter("user_id");
		String str_pw = request.getParameter("user_pw");
		
		PrintWriter out = response.getWriter();
		
		String data = "";
		
		data += "<!DOCTYPE html>";
		data += "<html>";
		data += "<head>";
		data += "<meta charset=\"UTF-8\">";
		data += "<title>�α���������</title>";
		data += "</head>";
		data += "<body>";
		data += "���̵� : "+str_id+"<br>";
		data += "�н����� : "+str_pw;
		data += "</body>";
		data += "</html>";		
				
		out.print(data);
	}


	public void init(ServletConfig config) throws ServletException {
		
	}

	
	public void destroy() {
		
	}	

}
