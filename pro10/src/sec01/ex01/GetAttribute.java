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

@WebServlet("/get")
public class GetAttribute extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		ServletContext ctx = getServletContext();
		HttpSession session = req.getSession();
		
		String s_ctx = (String)ctx.getAttribute("context");		
		String s_session = (String)session.getAttribute("session");
		String s_req = (String)req.getAttribute("request");
		
		out.print("context °ª"+s_ctx+"<br>");
		out.print("session °ª"+s_session+"<br>");
		out.print("request °ª"+s_req+"<br>");
	}
	
}
