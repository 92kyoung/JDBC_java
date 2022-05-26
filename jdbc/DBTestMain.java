package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * �۾� ���� 
 * 1.����̹� �ε�
 * 2. db���� �� ���� ��ü ������
 * 3. statement Ŭ����
 */
public class DBTestMain {
	public static void main(String[] args) {
		try {
			//1�ܰ�: ����̹� �ε�
 		Class.forName("oracle.jdbc.driver.OracleDriver"); //����ó�� �ʿ�
 		System.out.println("����̹� �ε� �Ϸ�");
 		//2�ܰ� :db����
 		Connection conn = DriverManager.getConnection(
 				"jdbc:oracle:thin:@192.168.119.119:1521:dink",
 				"scott", //���̵�
 				"tiger"  //�н�����
 				);
 		System.out.println("db ���Ӽ���:"+conn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
