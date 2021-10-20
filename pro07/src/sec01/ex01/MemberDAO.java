package sec01.ex01;
//DB 연결하는 클래스 

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	private Statement stmt;
	private Connection conn;
	
	public List<MemberVO> listMembers(){
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			
			String query ="select * from t_member";
			System.out.println(query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
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
			stmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//DB 접근 메소드 
	private void connDB() {
		try {
			//드라이브 정보 설정
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공!");
			
			//db 접근
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			//sql 문을 실행 준비 
			stmt = conn.createStatement();
			System.out.println("statement 생성 성공"); 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("에러메세지:"+e.getMessage());
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("에러메세지:"+e.getMessage());
		}
	}
}
