package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * preparedStatement ����غ���
 * -�����δ� statement ���� preparedStatement�� �� ���� ����Ѵ�. 
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
		    String name= "���浿";
		    
		    String sql = "insert into t_test(id,name) values(?,?)"; //?�� �� �ڸ��� ���� ���� �� ���̶�� ���� �ǹ��Ѵ�. 
		                                              //�̷� ?����ǥ ���´� prepareStatement()�� �ؼ��� �� �ִ�.
		   pstmt = conn.prepareStatement(sql); //statement�ʹ� �޸� prepareStatement�� ���⼭ sql�� ����ִ´�. 
		   pstmt.setString(1,id);//ù��° ? �ڸ��� id ��� ���ڿ��� ���� ���� �ž�
		   pstmt.setString(2,name);
		   
		  
		   int cnt = pstmt.executeUpdate();
		   System.out.println(cnt+"���� ���� ���ԵǾ����ϴ�. ");
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
