// [김재희]
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbConnection;


public class StudentDao {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	Student student = null;
	
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
	//Student 리스트를 조회
	//리턴값이 ArrayList<Student>이다
	public ArrayList<Student> selectStudentlist() {
		ArrayList<Student> list = new ArrayList<Student>();
			// DB연결 후 쿼리문 실행준비와 쿼리문실행후 그결과를  리스트에 추가해 담은후 리턴한다 닫아준다.
		try {
			connection = DbConnection.dbConn();
			String sql = "SELECT * FROM student";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				student = new Student();
				student.setStudentNo(resultSet.getInt("student_no"));
				student.setStudentId(resultSet.getString("student_id"));
				student.setStudentPw(resultSet.getString("student_pw"));
				list.add(student);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) try {resultSet.close();} catch (SQLException e) {}
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (SQLException e) {}
		}
		return list;
	}

	
	//Student 삭제
	public int removeStudent(int studentNo) {//Student student
		System.out.println("deleteStudent StudentDao.java");
		try {
			connection = DbConnection.dbConn();
			String sql = "DELETE FROM student WHERE student_no=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentNo);
			statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (SQLException e) {}
		}
		return 0;
	}
	
	
	// 수정화면에 한명의 학생젖보 조회
	public Student selectOneStudent(int studentNo) {
		System.out.println("selectOneStudent StudentDao.java");
		try {
			connection = DbConnection.dbConn();
			String sql = "SELECT * FROM student WHERE student_no=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentNo);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				student = new Student();
				student.setStudentNo(resultSet.getInt("student_no"));
				student.setStudentId(resultSet.getString("student_id"));
				student.setStudentPw(resultSet.getString("student_pw"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) try {resultSet.close();} catch (SQLException e) {}
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (SQLException e) {}
		}
		return student;
	}
	
	
	
	//Student 정보를 업데이트
	public int modifyStudent(Student student) {
		System.out.println("updateStudent StudentDao.java");
		try {
			//Db연결 후 업데이트 하는 쿼리문을 sql에 담아서 쿼리실행을 위하 준비후 셋팅
			//쿼리실행 후 닫아준다.
			connection = DbConnection.dbConn();
			String sql = "UPDATE student SET student_id=?,student_pw=? WHERE student_no=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getStudentId());
			statement.setString(2, student.getStudentPw());
			statement.setInt(3, student.getStudentNo());
			statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (SQLException e) {}
		}
		
		return 0;
	}
	
	}
