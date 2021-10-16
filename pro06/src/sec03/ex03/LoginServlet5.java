package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		String user_addr = req.getParameter("user_address");
		
		
		//응답에 대한 출력
		PrintWriter out = resp.getWriter();
		String 	data = "<html>";
				data += "<body>";
				data += "아이디"+user_id+"<br>";
				data += "비밀번호"+user_pw+"<br>";
				data += "주소:"+user_addr+"<br>";
				data += "<body>";
				data += "</html>";
		out.print(data);
	}

}
