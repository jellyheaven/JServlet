package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doHandle(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doHandle(req,resp);
	}
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		MemberDAO dao = new MemberDAO();
		
		String command = req.getParameter("command");		
		
		//추가 
		if(command != null && command.equals("addMember")) {
			System.out.println("회원정보 등록 !!");
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			
			MemberVO memberVo = new MemberVO();
			memberVo.setId(id);
			memberVo.setPwd(pwd);
			memberVo.setName(name);
			memberVo.setEmail(email);
			
			dao.addMember(memberVo);
			
		} else if(command != null && command.equals("delMember")) {
			System.out.println("회원정보 삭제!!");
			
			String id = req.getParameter("id");
			
			dao.delMember(id);
		}
		
		
		List memberlist = dao.listMembers();
		req.setAttribute("memberList", memberlist);
		
		//dispatch 포워딩 처리
		
		RequestDispatcher dispatch = req.getRequestDispatcher("viewMembers");
		
		dispatch.forward(req, resp);
		
	}
	
}
