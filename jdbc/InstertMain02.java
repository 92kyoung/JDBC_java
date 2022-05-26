package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/*
 * Q. �Ʒ��� ������ �����ϴ� �ڵ带 ������.
 * ���̵� �Է�:~~
 * �̸� �Է�:~~~
 * 1�� ���� �����Ͽ����ϴ�.
 */
public class InstertMain02 {
	public static void main(String[] args) {

		Connection conn = null; // try�� finally ������ ��� ����ϱ� ���ؼ� ���ʿ� ��ü�� �����Ѵ�.
		Statement stmt = null;

		try {
	        //1�ܰ�
			Class.forName("oracle.jdbc.driver.OracleDriver"); //���⼭ ������ ������ �ѹ� Ȯ���ϰ� ���� �ܰ�� �Ѿ��.
			System.out.println("����̹� �ε� ����..."); 
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			
			//2�ܰ�
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn:" + conn); //�̰� �߳����� db ���� ������~!
			
		
            //3�ܰ�			
			Scanner sc = new Scanner(System.in);
			System.out.print("���̵� �Է��ϼ���:");
			String id = sc.nextLine();
			
	
			System.out.print("�̸��� �Է��ϼ���:");
			String name= sc.nextLine();
			
			String sql = "INSERT INTO T_TEST(ID,NAME) VALUES(\'" + id + "\',\'" + name + "\')"; //id�� name �� ������ ���� ����ǥ�� �����Ѵ�. 
			                                                                                    //sql������ ���ڿ��� ���� ����ǥ�� �����ϱ� �����̴�. 
	               
			stmt = conn.createStatement();
			
			//4�ܰ�
			int cnt = stmt.executeUpdate(sql); // ���Ե� ���� ������ ���ϵȴ�.
			System.out.println("�� " + cnt + "�� ���� ���ԵǾ����ϴ�");
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // ������ ���� �ȳ��� ���� ����� �� ����Ǿ����
			//5�ܰ�
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
