package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login5")
public class LoginServlet extends HttpServlet {

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
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId(user_id);
		memberVO.setPwd(user_pw);
		
		MemberDAO dao = new MemberDAO();
		
		boolean result = dao.isExisted(memberVO);
		
		if(result) {
			//���� 
			HttpSession session = req.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pw);
			
			out.print("<html><body>");
			out.print("�ȳ��ϼ���."+user_id +"��!! <br>");
			out.print("<a href='show'> ȸ������ ���� </a>");
			out.print("</body></html>");
		}else {
			out.print("<html><body>");
			out.print("ȸ�� ���̵� Ʋ���ϴ�. <br>");
			out.print("<a href='login3.html'> �ٽ� �α��� �ϱ�  </a>");
			out.print("</body></html>");
		}
	}
	
}
