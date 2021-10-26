package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		List memberList = (List) req.getAttribute("memberList");
		
		
		out.print("<html><body>");
		out.print("<table border='1'><tr align='center' bgcolor='lightgreen'> ");
		out.print("<td>���̵�</td><td>��й�ȣ</td><td>�̸�</td><td>�̸���</td><td>������</td><td>����</td></tr>");
		
		for (int i = 0; i < memberList.size(); i++) {
			MemberVO memberVO = (MemberVO) memberList.get(i);
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			out.print("<tr><td>"+id+"</td><td>"+pwd+"</td><td>"+name+"</td><td>"+email+"</td><td>"+joinDate+"</td>");
			out.print("<td><a href = '/pro08/member?command=delMember&id="+id+"' >����</a></td></tr>");
		}
		
		out.print("</table> "
				+ "<a href='/pro08/memberForm.html'>�� ȸ�� ����ϱ� </a>"
				+ "</body>"
				+ "</html>");
	}
	
	
}
