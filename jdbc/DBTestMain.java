package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 작업 순서 
 * 1.드라이버 로딩
 * 2. db접속 및 연결 객체 얻어오기
 * 3. statement 클래스
 */
public class DBTestMain {
	public static void main(String[] args) {
		try {
			//1단계: 드라이버 로딩
 		Class.forName("oracle.jdbc.driver.OracleDriver"); //예외처리 필요
 		System.out.println("드라이버 로딩 완료");
 		//2단계 :db접속
 		Connection conn = DriverManager.getConnection(
 				"jdbc:oracle:thin:@192.168.119.119:1521:dink",
 				"scott", //아이디
 				"tiger"  //패스워드
 				);
 		System.out.println("db 접속성공:"+conn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
