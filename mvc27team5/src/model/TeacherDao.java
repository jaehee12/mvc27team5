package model;

import db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TeacherDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Teacher teacher = null;
	
	// Teacher입력 처리 메서드
	public void insertTeacher(Teacher teacher) {	
		DbConnection db = new DbConnection();
		try {
			conn = db.dbConn();	
			String sql = "INSERT INTO `teacher` (`teacher_id`, `teacher_pw`) VALUES (?,?)";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getTeacherId());
			pstmt.setString(2, teacher.getTeacherPw());	
			pstmt.executeUpdate();		
			pstmt.close();		
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
}
