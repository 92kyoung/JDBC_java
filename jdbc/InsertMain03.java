package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * preparedStatement 사용해보기
 * -실제로는 statement 보다 preparedStatement를 더 많이 사용한다. 
 *
 */
public class InsertMain03 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url,user,password);
	
		    String id = "ku";
		    String name= "구길동";
		    
		    String sql = "insert into t_test(id,name) values(?,?)"; //?는 그 자리에 뭔가 값이 들어갈 것이라는 뜻을 의미한다. 
		                                              //이런 ?물음표 형태는 prepareStatement()만 해석할 수 있다.
		   pstmt = conn.prepareStatement(sql); //statement와는 달리 prepareStatement는 여기서 sql을 집어넣는다. 
		   pstmt.setString(1,id);//첫번째 ? 자리에 id 라는 문자열을 집어 넣을 거야
		   pstmt.setString(2,name);
		   
		  
		   int cnt = pstmt.executeUpdate();
		   System.out.println(cnt+"개의 행이 삽입되었습니다. ");
		} catch (Exception e) {
		
			e.printStackTrace();
		
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
			
		}
	}
}
