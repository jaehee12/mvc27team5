/*[유국화]*/
package model;

import db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class TeacherDao {	
	
	/* 
	 * 아이디 체크하는 메서드
	 */
	public boolean tIdCheck(String teacherId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean result = false;
		String sql = "SELECT teacher_id AS teacherId FROM teacher WHERE teacher_id = ?";
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setString(1, teacherId);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				result = true;
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null) try { resultSet.close(); } catch(SQLException ex) { }
			if(statement != null) try { statement.close(); } catch(SQLException ex) { }
			if(connection != null) try { connection.close(); } catch(SQLException ex) { }
		}
		return result;
		
	}
	
	/*
	 * 리스트에서 삭제버튼을 누르면 해당 레코드를 삭제하는 메서드
	 * 매개변수 teacherNo를 입력받고 리턴없음.
	 */
	public void removeTeacher(int teacherNo) {
		System.out.println("---removeTeacher TeacherDao model---");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM teacher WHERE teacher_no=?";
		try {
			conn = DbConnection.dbConn();
			pstmt = conn.prepareStatement(sql);					
			pstmt.setInt(1, teacherNo);
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
	 * 수정화면에서 데이터를 업데이트하는 메서드
	 * (수정화면에서 셋팅된) 객체참조변수 teacher를 입력받는다.
	 */
	public void updateTeacher(Teacher teacher) {
		System.out.println("---UpdateTeacher TeacherDao model---");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE teacher SET teacher_pw=? WHERE teacher_no=?";		
		try {			
			conn = DbConnection.dbConn();			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, teacher.getTeacherPw());
			pstmt.setInt(2, teacher.getTeacherNo());	
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
	 * teacher 리스트에서 수정버튼을 눌러 해당 티처 정보를 조회하여 수정화면을 출력하는 메서드
	 * 매개변수 teacherNo를 입력받고, 쿼리실행결과를 셋팅한 Teacher를 리턴한다.
	 */
	public Teacher selectForUpdateTeacher(int teacherNo) {
		System.out.println("---selectForUpdateTeacher TeacherDao model---");	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Teacher teacher = null;		
		String sql = "SELECT * FROM teacher WHERE teacher_no=?";
		try {
			conn = DbConnection.dbConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teacherNo);
			rs = pstmt.executeQuery();
			teacher = new Teacher();
			if(rs.next()) {				
				teacher.setTeacherNo(rs.getInt("teacher_no"));
				teacher.setTeacherId(rs.getString("teacher_id"));
				teacher.setTeacherPw(rs.getString("teacher_pw"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
			if(conn != null) try { conn.close(); } catch (SQLException e) { }
		}
		return teacher;
	}
	
	/*
	 * teacher 리스트를 화면에 보여주는 메서드
	 * list에 쿼리실행결과 데이터를 셋팅하여 리턴.
	 */
	public ArrayList<Teacher> selectAllTeacher() {
		System.out.println("---selectAllTeacher TeacherDao model---");	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Teacher teacher = null;		
		ArrayList<Teacher> list = null;
		String sql = "SELECT * FROM teacher";
		try {
			conn = DbConnection.dbConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();		
			list = new ArrayList<Teacher>();
			while(rs.next()) {
				teacher = new Teacher();
				teacher.setTeacherNo(rs.getInt("teacher_no"));
				teacher.setTeacherId(rs.getString("teacher_id"));
				teacher.setTeacherPw(rs.getString("teacher_pw"));
				list.add(teacher);
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
	 * teacher의 데이터(id, pw)를 DB에 입력하는 메서드
	 * 입력값이 있는지 없는지 판별하는 쿼리결과를 0 or 1로 리턴
	 */
	public int insertTeacher(Teacher teacher) {	
		System.out.println("---insertTeacher TeacherDao model---");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "INSERT INTO teacher (teacher_id, teacher_pw) VALUES (?,?)";	
		try {
			conn = DbConnection.dbConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getTeacherId());
			pstmt.setString(2, teacher.getTeacherPw());	
			result = pstmt.executeUpdate();				
			
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
