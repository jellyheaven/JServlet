package sec06.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadAppConfig
 */
@WebServlet(name = "loadConfig", urlPatterns = {"/loadConfig"}, loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {

	private ServletContext context;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoadAppConfig 의 init 메서드 호출");
		
		context = config.getServletContext();
		
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		context.setAttribute("menu_member", menu_member);
		context.setAttribute("menu_order", menu_order);
		context.setAttribute("menu_goods", menu_goods);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		String menu_member = (String) context.getAttribute("menu_member"); 
		String menu_order = (String) context.getAttribute("menu_order");
		String menu_goods = (String) context.getAttribute("menu_goods");
		
		out.print("<html><body>");
		out.print("<table border='1'>");
		out.print("<tr><td>메뉴이름</td></tr>");
		out.print("<tr><td>"+menu_member+"</td></tr>");
		out.print("<tr><td>"+menu_order+"</td></tr>");
		out.print("<tr><td>"+menu_goods+"</td></tr>");
		out.print("</table>");
		out.print("</body></html>");
	}

}
