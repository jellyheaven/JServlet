package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member01")
public class MemberServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		//db 접근
		MemberDAO dao = new MemberDAO();
		
		List<MemberVO> list = dao.listMembers();
		
		out.print("<html><body>");
		
		out.print("<table border='1'><tr align='center' bgcolor='lightgreen'> ");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
		
		for (int i = 0; i < list.size(); i++) {
			MemberVO memberVO = list.get(i);
			
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			out.print("<tr><td>"+id+"</td><td>"+pwd+"</td><td>"+name+"</td><td>"+email+"</td><td>"+joinDate+"</td></tr>");
		}
		
		out.print("</table></body></html>");
	}

}
