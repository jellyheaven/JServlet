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

@WebServlet("/logout")
public class LogoutTest extends HttpServlet {
	
	ServletContext ctx;
	
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
		
		ctx = getServletContext();
		
		HttpSession session = req.getSession();
		
		String user_id = req.getParameter("user_id");
		
		session.invalidate(); //세션 소멸
		
		List user_list = (ArrayList)ctx.getAttribute("user_list");
		
		user_list.remove(user_id);
		ctx.removeAttribute("user_list");
		ctx.setAttribute("user_list", user_list);
		
		out.print("<br> 로그아웃했습니다.");
	}
	
}
