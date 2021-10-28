package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login3")
public class SessionTest4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doHandle(req,resp);
	}	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doHandle(req,resp);
		
	}
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		
		//���� ���� ����
		if(session.isNew()) {
			if(user_id != null) {
				session.setAttribute("user_id", user_id);
				out.print("<a href='login3'>�α��� ���� Ȯ��</a>");
			}else {
				out.print("<a href='login2.html'>�ٽ� �α��� �ϼ���!!</a>");
				session.invalidate();
			}
		}else{
			//���� �����ϸ�
			user_id = (String) session.getAttribute("user_id");
			
			if(user_id != null && user_id.length() != 0) {
				out.print("�ȳ��ϼ���. "+user_id +"��!!");
			}else {
				out.print("<a href='login2.html'>�ٽ� �α��� �ϼ���!!</a>");
				session.invalidate();
			}
		}
	}
	
}
