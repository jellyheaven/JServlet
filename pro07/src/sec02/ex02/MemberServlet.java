package sec02.ex02;

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

@WebServlet("/member04")
public class MemberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doHandle(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		doHandle(req, resp);
	}
	
	//post , get 구분없이 처리 
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		MemberDAO dao = new MemberDAO();		
		
		String command = req.getParameter("command");		
		
		//추가 
		if(command != null && command.equals("addMember")) {
			System.out.println("회원정보 등록 !!");
		} else if(command != null && command.equals("delMember")) {
			System.out.println("회원정보 삭제 !!");
		} else {
			List<MemberVO> list = dao.listMembers();  //목록 가져오기
			
			out.print("<html><body>");
			
			out.print("<table border='1'><tr align='center' bgcolor='lightgreen'> ");
			out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
			
			for (int i = 0; i < list.size(); i++) {
				MemberVO memberVO = list.get(i);
				
				String id = memberVO.getId();
				String pwd = memberVO.getPwd();
				String name = memberVO.getName();
				String email = memberVO.getEmail();
				Date joinDate = memberVO.getJoinDate();
				
				out.print("<tr><td>"+id+"</td><td>"+pwd+"</td><td>"+name+"</td><td>"+email+"</td><td>"+joinDate+"</td>");
				out.print("<td><a href = '/pro07/member04?command=delMember&id="+id+"' >삭제</a></td></tr>");
			}
			out.print("</table></body></html>");
		}
		
	}
	
}
