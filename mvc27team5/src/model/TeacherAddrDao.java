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
	 * 티처 주소 리스트의 레코드 갯수를 세는 메서드
	 */
	public int teacherAddrCount(int teacherNo) {
		System.out.println("---teacherAddrCount TeacherAddrDao model---");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT Count(*) AS teacherCount FROM teacher_addr WHERE teacher_no=?";
		try {
			conn = DbConnection.dbConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teacherNo);
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				result = rs.getInt("teacherCount");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
			if(conn != null) try { conn.close(); } catch (SQLException e) { }
		}
		return result;
	}
	
	/*
	 * 티처 주소 리스트 출력하는 메서드
	 * 매개변수 teacherNo
	 */
	public ArrayList<TeacherAddr> selectTeacherAddrList(int teacherNo) {
		System.out.println("---selectTeacherAddrList TeacherAddrDao model---");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TeacherAddr teacheraddr = null;		
		ArrayList<TeacherAddr> list = null;
		String sql = "SELECT * FROM teacher_addr WHERE teacher_no=?";
		try {
			conn = DbConnection.dbConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teacherNo);
			rs = pstmt.executeQuery();		
			list = new ArrayList<TeacherAddr>();
			while(rs.next()) {
				teacheraddr = new TeacherAddr();
				teacheraddr.setTeacherAddrNo(rs.getInt("teacher_addr_no"));
				teacheraddr.setTeacherNo(rs.getInt("teacher_no"));
				teacheraddr.setAddress(rs.getString("address"));
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
	public int removeTeacherAddr(String[] removeAddrList) {
		System.out.println("---removeTeacherAddr TeacherAddrDao model---");
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int result = 0;
		String sql = "DELETE FROM teacher_addr WHERE teacher_addr_no=?";	
		try {
			conn = DbConnection.dbConn();
			for(String TeacherAddrNo : removeAddrList) {
				pstmt = conn.prepareStatement(sql);					
				pstmt.setInt(1, Integer.parseInt(TeacherAddrNo));
				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
			if(conn != null) try { conn.close(); } catch (SQLException e) { }
		}
		return result;
	}
		
	/*
	 * 선택한 티처 주소추가하는 메서드	
	 * 매개변수 teacheraddr를 입력받는다.
	 */
	public int insertTeacherAddr(TeacherAddr teacheraddr) {
		System.out.println("---insertTeacherAddr TeacherAddrDao model---");		
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int result = 0;
		String sql = "INSERT INTO teacher_addr (teacher_no, address) VALUES (?,?)";	
		try {
			conn = DbConnection.dbConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teacheraddr.getTeacherNo());
			pstmt.setString(2, teacheraddr.getAddress());
			pstmt.executeUpdate();				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
			if(conn != null) try { conn.close(); } catch (SQLException e) { }
		}
		return result;
	}
}
