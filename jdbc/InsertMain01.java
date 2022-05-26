package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager; //Conncetion ��ü�� ����ϱ� ���� ��Ű�� ����Ʈ
//DriverManager ��Ű������ Connection ��ü�� ��� �� �� �̴�.
import java.sql.SQLException;
import java.sql.Statement;
//statement ��ü�� �������� ���� ��Ű��

//Q. id:hong �̰� name:ȫ�浿 �� ���ڵ带 db�� t_test ���̺� �����ϰ� �ʹ�.
/*
 * �۾�����
 * 1. ����̹� �ε�
 * 2. DB ���� �� Connection ������
 * 3. sql ���� ��ü ������\
 * 4. ���� ���� �� ��� ������
 * 5. ���� ����
 * 
 * *) �ڵ����� Ŀ���� �ȴ�.
 *    Ʈ������� �ϱ� ���ؼ��� autocommit�� false ������ ����������Ѵ�.
*/
public class InsertMain01 {
	public static void main(String[] args) {

		Connection conn = null; // try�� finally ������ ��� ����ϱ� ���ؼ� ���ʿ� ��ü�� �����Ѵ�.
		Statement stmt = null;

		try {
			// 1. ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����...");
			// 2. DB ���� �� Connection ��ü ���
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			// connection ��ü�� new connection �̷��� �ؼ� �������� �ʴ´�.
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn:" + conn);
			// 3. sql ���ఴü ������
			stmt = conn.createStatement();  //������ ���� �� �ִ� statement �����ϱ�
			// createStatement()�� �̿��ؼ� statement ��ü ������

			String sql = "INSERT INTO T_TEST(ID,NAME) VALUES('hong','ȫ�浿')";

			// 4. sql ���� �� ��� ������
			int cnt = stmt.executeUpdate(sql); // ���� ������ ���ϵȴ�.
			System.out.println("��" + cnt + "�� ���� ���ԵǾ����ϴ�");
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // ������ ���� �ȳ��� ���� ����� �� ����Ǿ����
			// ��ü 2�� ���� (connection �� statement) => ���� ��ü ��� �� ���� ���Ḧ �ؾ���
			// ���� ������ �ݴ�� close�� ���־���Ѵ�.
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
