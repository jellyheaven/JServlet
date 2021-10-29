package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login2")
public class LoginTest extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		String user_id = req.getParameter("user_id");
		String user_pwd = req.getParameter("user_pwd");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pwd);
		
		HttpSession session = req.getSession();
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		}
		
		out.print("<html>");
		out.print("<head>");
		out.print("<script type = 'text/javascript' >");
		out.print(" setTimeout('history.go(0);', 5000)");		
		out.print("</script>");
		out.print("</head>");
		out.print("<body>");
		out.print("아이디는 "+loginUser.user_id+"<br>");
		out.print("총 접속자수는 "+loginUser.total_user+"<br>");
		out.print("</body>");
		out.print("</html>");
	}

	
}
