package sec05.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	
	private Connection conn;
	private DataSource dataFactory;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
		try {
			//Context.xml ��Ĺ DataSource ����
			Context ctx = new InitialContext(); 
			Context envCtx =  (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envCtx.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isExisted(MemberVO memberVO){
		boolean result = false;
		
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		
		try {
			conn = dataFactory.getConnection();
			
			String query = "select decode(count(*) , 1 , 'true', 'false') as result ";
				   query += "from t_member where id = ? and pwd = ? ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			result =Boolean.parseBoolean(rs.getString("result"));
			
			System.out.println("result="+result);	   
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//��� �����ֱ�
	public List<MemberVO> listMembers(){
		
		List<MemberVO> list= new ArrayList<MemberVO>();
		
		try {
			conn = dataFactory.getConnection(); //db ����
			
			String query = "select * from t_member";
			System.out.println("PreparedStatement: "+ query);
			
			pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				list.add(vo);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	
	//����� �߰�
	public void addMember(MemberVO memberVO) {
		try {
			conn = dataFactory.getConnection(); //datasource ����
			
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String query =  "insert into t_member ";
				   query += "(id, pwd, name, email) ";
				   query += "values(?,?,?,?)";
			
			System.out.println("prepareStatememt: "+ query);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
		
	//����� ����
	public void delMember(String id) {
		try {
			conn = dataFactory.getConnection();
			
			String query = "delete from t_member where id = ?";
			
			System.out.println("prepareStatememt"+ query);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
