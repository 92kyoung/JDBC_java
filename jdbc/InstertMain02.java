package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/*
 * Q. 아래의 동작을 수행하는 코드를 만들어보자.
 * 아이디 입력:~~
 * 이름 입력:~~~
 * 1개 행을 삽입하였습니다.
 */
public class InstertMain02 {
	public static void main(String[] args) {

		Connection conn = null; // try와 finally 블럭에서 모두 사용하기 위해서 위쪽에 객체를 선언한다.
		Statement stmt = null;

		try {
	        //1단계
			Class.forName("oracle.jdbc.driver.OracleDriver"); //여기서 에러가 나는지 한번 확인하고 다음 단계로 넘어간다.
			System.out.println("드라이버 로딩 성공..."); 
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			
			//2단계
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn:" + conn); //이게 잘나오면 db 연결 오케이~!
			
		
            //3단계			
			Scanner sc = new Scanner(System.in);
			System.out.print("아이디를 입력하세요:");
			String id = sc.nextLine();
			
	
			System.out.print("이름을 입력하세요:");
			String name= sc.nextLine();
			
			String sql = "INSERT INTO T_TEST(ID,NAME) VALUES(\'" + id + "\',\'" + name + "\')"; //id와 name 양 쪽으로 작은 따옴표가 들어가야한다. 
			                                                                                    //sql에서는 문자열을 작은 따옴표로 구분하기 때문이다. 
	               
			stmt = conn.createStatement();
			
			//4단계
			int cnt = stmt.executeUpdate(sql); // 상입된 행의 개수가 리턴된다.
			System.out.println("총 " + cnt + "개 행이 삽입되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 에러가 나든 안나든 연결 종료는 꼭 실행되어야함
			//5단계
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
