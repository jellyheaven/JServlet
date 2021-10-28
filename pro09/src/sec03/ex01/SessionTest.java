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
		
		HttpSession session = req.getSession(); //���� ����
		
		
		out.print("���� ���̵�:"+session.getId()+"<br>"); 
		out.print("���� ���� �����ð�:"+new Date(session.getCreationTime())+"<br>");
		out.print("�ֱ� ���� ���ٽð�:"+new Date(session.getLastAccessedTime())+"<br>");
		out.print("�⺻ ���� ��ȿ�ð�:"+session.getMaxInactiveInterval()+"<br>");
		
		session.setMaxInactiveInterval(5); //�ʷ� �缳��
		
		out.print("���� ��ȿ�ð�:"+session.getMaxInactiveInterval()+"<br>");
		
		if(session.isNew()) {
			out.print("�� ������ ����� �����ϴ�.");
		}
	}
	
}
