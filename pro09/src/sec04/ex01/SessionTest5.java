package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/* ũ�ӿ��� ��Ű ��� �����ϰ� �׽�Ʈ �ؾ���*/
@WebServlet("/login4")
public class SessionTest5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
				String url = resp.encodeURL("login4"); //������ ����� �� ������
				
				out.print("<a href="+url+">�α��� ���� Ȯ��</a>");
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
