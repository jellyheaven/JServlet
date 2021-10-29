package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login3")
public class LoginTest extends HttpServlet {
	ServletContext ctx = null;
	List user_list = new ArrayList();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");		
		
		ctx = getServletContext();
		
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();	
		
		String user_id = req.getParameter("user_id");
		String user_pwd = req.getParameter("user_pwd");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pwd);
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			user_list.add(user_id);
			ctx.setAttribute("user_list", user_list);
		}
		
		out.print("<html>");		
		out.print("<body>");
		out.print("아이디는 "+loginUser.user_id+"<br>");
		out.print("총 접속자수는 "+loginUser.total_user+"<br>");
		out.print("접속 아이디 : <br>");
		
		List list = (ArrayList) ctx.getAttribute("user_list");
		
		for (int i = 0; i < list.size(); i++) {
			out.print(list.get(i)+"<br>");
		}
		
		out.print("<a href='logout?user_id="+user_id+"'>로그아웃</a> ");
		out.print("</body>");
		out.print("</html>");
		
	}
	
}
