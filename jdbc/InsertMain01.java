package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager; //Conncetion 객체를 사용하기 위한 패키지 임포트
//DriverManager 패키지에서 Connection 객체를 얻어 올 것 이다.
import java.sql.SQLException;
import java.sql.Statement;
//statement 객체를 가져오기 위한 패키지

//Q. id:hong 이고 name:홍길동 인 레코드를 db의 t_test 테이블에 삽입하고 싶다.
/*
 * 작업순서
 * 1. 드라이버 로딩
 * 2. DB 접속 및 Connection 얻어오기
 * 3. sql 실행 객체 얻어오기\
 * 4. 쿼리 실행 및 결과 얻어오기
 * 5. 접속 종료
 * 
 * *) 자동으로 커밋이 된다.
 *    트랜잭션을 하기 위해서는 autocommit을 false 값으로 지정해줘야한다.
*/
public class InsertMain01 {
	public static void main(String[] args) {

		Connection conn = null; // try와 finally 블럭에서 모두 사용하기 위해서 위쪽에 객체를 선언한다.
		Statement stmt = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공...");
			// 2. DB 접속 및 Connection 객체 얻기
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			// connection 객체는 new connection 이렇게 해서 가져오지 않는다.
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn:" + conn);
			// 3. sql 실행객체 얻어오기
			stmt = conn.createStatement();  //쿼리를 담을 수 있는 statement 생성하기
			// createStatement()를 이용해서 statement 객체 얻어오기

			String sql = "INSERT INTO T_TEST(ID,NAME) VALUES('hong','홍길동')";

			// 4. sql 실행 및 결과 얻어오기
			int cnt = stmt.executeUpdate(sql); // 행의 개수가 리턴된다.
			System.out.println("총" + cnt + "개 행이 삽입되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 에러가 나든 안나든 연결 종료는 꼭 실행되어야함
			// 객체 2개 얻어옴 (connection 과 statement) => 얻어온 객체 모두 다 접속 종료를 해야함
			// 얻어온 순서와 반대로 close를 해주어야한다.
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
