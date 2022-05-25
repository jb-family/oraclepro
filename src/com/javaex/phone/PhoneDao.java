package com.javaex.phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneDao {

	//필드
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "phonedb";
	private String pw = "phonedb";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	
	
	//메소드 Db연결
	public void getConnection() {
		
		try {
			// 1. JDBC 드라이버(Oracle) 로딩
			Class.forName(driver);	
			
			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);
			
			}catch (ClassNotFoundException e) {
				System.out.println("error: 드라이버 로딩 실패 - " + e);
			}catch (SQLException e) {
				System.out.println("error:" + e);
			}
	}
	
	public void close() {
		
			// 5. 자원정리
			try {
			if (rs!= null) {
			rs.close();
			}
			if (pstmt!= null) {
			pstmt.close();
			}
			if (conn != null) {
			conn.close();
			}
			} catch (SQLException e) {
			System.out.println("error:" + e);
			}
		}
	
	
	//메소드 - 일반
	
	//추가기능 메소드 
	public int phoneInsert(PersonVo personVo) {
		
		int count = -1;
		
			try {
				getConnection();
			
			//SQL문준비
			String query = "";
			query += " insert into person ";
			query += " values (seq_person_id.nextval, ?, ?, ?) ";
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());
			
			//실행	
			count = pstmt.executeUpdate();	
				
			// 4.결과처리
			System.out.println(count + "건이 추가되었습니다.");	
				
			} catch (SQLException e) {
			System.out.println("error:" + e);
			} 
			
		close();
		return count;
	}
	
	//수정기능 메소드
	public int phoneUpdate(PersonVo personVo) {
		int count = -1;
		
			try {
				getConnection();
				
			// 3. SQL문준비/ 바인딩/ 실행
			//SQL문준비
			String query = "";
			
			query += " update person ";
			query += " set name = ? ";
			query += "     ,hp = ? ";
			query += "     ,company = ? ";
			query += " where person_id = ? ";
			
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());
			pstmt.setInt(4, personVo.getPersonId());
			
			//실행	
			count = pstmt.executeUpdate();
			
				
			// 4.결과처리
			System.out.println(count + "건이 수정되었습니다.");
				
			}  catch (SQLException e) {
			System.out.println("error:" + e);
			} 
			
		close();
		return count;
		
	}
	
	//삭제기능 메소드	
	public int phoneDelete(PersonVo personVo) {
		int count = -1;
		
		try {
				getConnection();
				
			// 3. SQL문준비/ 바인딩/ 실행
			//SQL문준비
			String query = "";
			query += " delete from person ";
			query += " where person_id = ? ";
				
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, personVo.getPersonId());	
			
			//실행
			count = pstmt.executeUpdate();
				
			// 4.결과처리
			System.out.println(count + "건이 삭제되었습니다.");
			
			} catch (SQLException e) {
			System.out.println("error:" + e);
			} 
		close();
		return count;
	}
	
	//조회기능 메소드
	public List<PersonVo> phoneSelect() {
		List<PersonVo> pList = new ArrayList<PersonVo>();
		try {
			getConnection();
			
			// 3. SQL문준비
			String query = "";
			query += " select  person_id ";
			query += "         ,name ";
			query += "         ,hp ";
			query += "         ,company ";
			query += " from    person ";
				
			//바인딩
			pstmt = conn.prepareStatement(query);
				
			//실행
			rs = pstmt.executeQuery();	
				
			// 4.결과처리
			
			while(rs.next()) {
					
					int personId = rs.getInt(1);
					String name = rs.getString(2);
					String hp = rs.getString(3);
					String company = rs.getString(4);
					
					PersonVo personVo = new PersonVo(personId, name, hp, company);
					
					pList.add(personVo);
			}
			
			} catch (SQLException e) {
			System.out.println("error:" + e);
			} 
		
		close();
		return pList;
	}
	
	
	
}
