/*[유국화]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbConnection;

public class TeacherAddrDao {	
	Connection conn = null;
	PreparedStatement pstmt = null;	
	TeacherAddr teacheraddr = null;	
	
	/**
	 * 선택한 티처 주소추가하는 메서드
	 * @param teacherNo
	 * @return teacheraddr
	 */
	public void insertTeacherAddr(int teacherNo, String teacherAddr) {
		System.out.println("---insertTeacherAddr TeacherAddrDao model---");		
		String sqlinsert = "INSERT INTO teacher_addr (teacher_no, address) VALUES (?,?)";	
		try {
			conn = DbConnection.dbConn();
			pstmt = conn.prepareStatement(sqlinsert);
			pstmt.setInt(1, teacherNo);
			pstmt.setString(2, teacherAddr);
			pstmt.executeUpdate();				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
			if(conn != null) try { conn.close(); } catch (SQLException e) { }
		}
		
	}
}
