package sec03.ex02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet4
 */
@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGet �޼ҵ� ȣ��");
		doHandle(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doPost �޼ҵ� ȣ��");
		doHandle(request, response);
		
	}
	
	//�ΰ� ȣ���� �� �ְ� ó�� 
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doHandle �޼ҵ� ȣ��");
		
		request.setCharacterEncoding("utf-8");		
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		
		System.out.println("���̵�:"+user_id);
		System.out.println("��й�ȣ:"+user_pw);
	}
	

}
