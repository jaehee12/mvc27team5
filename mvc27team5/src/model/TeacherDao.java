/*[유국화]*/
package model;

import db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class TeacherDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Teacher teacher = null;
	ArrayList list = null;
	
	/**
	 * teacher 리스트를 DB에서 불러와 화면에 보여주는 메서드
	 * @return list
	 */
	public ArrayList<Teacher> selectAllTeacher() {
		String sql = "SELECT  teacher_no AS teacherNo,  teacher_id AS teacherId,  teacher_pw AS teacherPw FROM 'teacher'";
		try {
			conn = DbConnection.dbConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getTeacherId());
			pstmt.setString(2, teacher.getTeacherPw());	
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				teacher = new Teacher();
				teacher.setTeacherNo(rs.getInt("teacherNo"));
				teacher.setTeacherId(rs.getString("teacherId"));
				teacher.setTeacherPw(rs.getString("teacherPw"));
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
	
	/**
	 * teacher의 데이터(id, pw)를 DB에 입력하는 메서드
	 * @param teacher
	 * @return result
	 */
	public int insertTeacher(Teacher teacher) {	
		int result = 0;
		String sql = "INSERT INTO `teacher` (`teacher_id`, `teacher_pw`) VALUES (?,?)";	
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
