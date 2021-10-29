package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class SetAttribute extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		String ctxMesg = "context�� ���ε��˴ϴ�."; 
		String sesMesg = "session�� ���ε��˴ϴ�."; 
		String reqMesg = "request�� ���ε��˴ϴ�.";
		
		ServletContext ctx = getServletContext();
		
		HttpSession session = req.getSession();
		
		ctx.setAttribute("context", ctxMesg);
		session.setAttribute("session", sesMesg);
		req.setAttribute("request", sesMesg);
		
		out.print("���ε��� �����մϴ�.");
		 
	}
	
}
