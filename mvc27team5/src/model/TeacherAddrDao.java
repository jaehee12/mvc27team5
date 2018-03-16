/*[유국화]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbConnection;

public class TeacherAddrDao {	
	
	/*
	 * 티처 주소 리스트 출력하는 메서드
	 * 매개변수
	 */
	public ArrayList<TeacherAddr> selectTeacherAddrList() {
		System.out.println("---selectTeacherAddrList TeacherAddrDao model---");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TeacherAddr teacheraddr = null;		
		ArrayList<TeacherAddr> list = null;
		String sql = "SELECT  * FROM teacher_addr";
		try {
			conn = DbConnection.dbConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();		
			list = new ArrayList<TeacherAddr>();
			while(rs.next()) {
				teacheraddr = new TeacherAddr();
				teacheraddr.setTeacherAddrNo(rs.getInt("teacher_addr_no"));
				teacheraddr.setTeacherNo(rs.getInt("teacher_no"));
				teacheraddr.setAddress(rs.getString("teacher_addr"));
				list.add(teacheraddr);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
			if(conn != null) try { conn.close(); } catch (SQLException e) { }
		}
		return list;
	}
	
	/*
	 * 티처 주소 삭제하는 메서드
	 * 매개변수  
	 */
	public void removeTeacherAddr(int teacher_addr_no) {
		System.out.println("---removeTeacherAddr TeacherAddrDao model---");
		Connection conn = null;
		PreparedStatement pstmt = null;	
		String sql = "DELETE FROM teacher_addr WEHRE teacher_addr_no=?";	
		try {
			conn = DbConnection.dbConn();
			pstmt = conn.prepareStatement(sql);					
			pstmt.setInt(1, teacher_addr_no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
			if(conn != null) try { conn.close(); } catch (SQLException e) { }
		}
	}
		
	/*
	 * 선택한 티처 주소추가하는 메서드	
	 * 매개변수 teacherNo, teacherAddr를 입력받는다.
	 */
	public void insertTeacherAddr(int teacherNo, String teacherAddr) {
		System.out.println("---insertTeacherAddr TeacherAddrDao model---");		
		Connection conn = null;
		PreparedStatement pstmt = null;	
		TeacherAddr teacheraddr = null;	
		String sql = "INSERT INTO teacher_addr (teacher_no, address) VALUES (?,?)";	
		try {
			conn = DbConnection.dbConn();
			pstmt = conn.prepareStatement(sql);
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
