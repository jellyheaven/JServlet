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
		
		
		//���信 ���� ���
		PrintWriter out = resp.getWriter();
		String 	data = "<html>";
				data += "<body>";
				data += "���̵�"+user_id+"<br>";
				data += "��й�ȣ"+user_pw+"<br>";
				data += "�ּ�:"+user_addr+"<br>";
				data += "<body>";
				data += "</html>";
		out.print(data);
	}

}
