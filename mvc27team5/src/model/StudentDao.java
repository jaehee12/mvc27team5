// [김재희]
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbConnection;


public class StudentDao {
	Connection connection = null;
	PreparedStatement statement = null;
	
	// model패키지의 Student클래스 타입의 student를 매개변수로 insertStudent메서드를 실행해 student의 id와 pw를 insert한다
	public void insertStudent(Student student) {
		try {
			// DbConnection클래스의 dbConn메서드를 실행해 connection 변수에 담는다.
			// String타입의 변수 sql에 insert쿼리문을 넣는다
			// connection참조변수에 prepareStatement의 메서드를 실행하고 sql에 담은 insert쿼리문을 실행위한 준비를 하고
			// Student클래스의 student변수의 주소를 찾아가 셋팅되었던 studentId,studentPw를 get메서드를 실행해 가져와서
			// statement차모벼수의 set메서드에 매개변수로 물음표에 각각 셋팅한다.
			// 그리고 statement참조변수에 executeUpdate메서드를 실행해 갱신해준다.
			
			connection = DbConnection.dbConn();
			System.out.println(connection + "<-- connection StudentDao.java");
			String sql = "INSERT INTO student (student_id, student_pw) VALUES(?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getStudentId());
			statement.setString(2, student.getStudentPw());
			statement.executeUpdate();	
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (SQLException e) {}
		}
			
	}
	
	public ArrayList<Student> selectAllStudent() {
		
		return null;
	}
	
}
