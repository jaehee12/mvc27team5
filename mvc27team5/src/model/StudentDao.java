/*[김재희]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbConnection;

public class StudentDao {
	
	/*student를 매개변수로 받아 insertStudent메서드를 실행해 student의 id와 pw를 데이터베이스에 추가하는 메서드*/
	public void insertStudent(Student student) {
		System.out.println("insertStudent StudentDao.java");
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			// DbConnection클래스의 dbConn메서드를 실행해 connection 변수에 담는다.
			// String타입의 변수 sql에 insert쿼리문을 넣는다
			// connection참조변수에 prepareStatement의 메서드를 실행하고 sql에 담은 insert쿼리문을 실행위한 준비를 하고
			// Student클래스의 student변수의 주소를 찾아가 셋팅되었던 studentId,studentPw를 get메서드를 실행해 가져와서
			// statement참조변수의 set메서드에 매개변수로 물음표에 각각 셋팅한다.
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
	
	/* 
	 * 매개변수 int startRow -> select 결과물의 시작행
	 * 매개변수 int pagePerRow -> select 결과물의 갯수
	 * Student 리스트를 조회
	   DB연결 후 SELECT 쿼리문 실행준비와 쿼리문실행후 그결과를 리스트에 추가해 담은후 리턴한다.*/	
	public ArrayList<Student> selectStudentlist(int startRow, int pagePerRow) {
		System.out.println("selectStudent StudentDao.java");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Student student = null;
		ArrayList<Student> list = new ArrayList<Student>();
			
		try {
			connection = DbConnection.dbConn();
			// student의 리스트를 어디서부터 어디까지 조회할 것이지
			String sql = "SELECT * FROM student LIMIT ?, ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, startRow);
			statement.setInt(2, pagePerRow);
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

	// student의 총 갯수를 카운트 하는 메서드
	public int studentTotalRowCount() {
		System.out.println("stuentTotalRowCount StudentDao.java");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int count = 0;
		// 총 리스트의 갯수 가져오기
		String sql = "SELECT count(*) from student";
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				// resultSet의 get메서드를 사용해 가져온 정보들을 count에 저장 
				count = resultSet.getInt(1);
				System.out.println(count + "<--count StudentDao.java");
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
		return count;
	}
	
	/* int타입의 studentNo를 매개변수로 받아 removeStudent메서드 실행해 
	 * 데이터베이스에 있는 선택된 student를 삭제하는 메서드 */ 
	public void removeStudent(int studentNo) {//Student student
		System.out.println("deleteStudent StudentDao.java");
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DbConnection.dbConn();
			String sql = "DELETE FROM student WHERE student_no = ?";
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
	}
	
	
	/* studentNo를 매개변수로 받아 선택한 한명의 학생정보를 수정화면에 조회해주는 메서드
	 * 그 결과를 student에 셋팅해 리턴한다 */
	public Student selectOneStudent(int studentNo) {
		System.out.println("selectOneStudent StudentDao.java");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Student student = null;
		try {
			connection = DbConnection.dbConn();
			String sql = "SELECT student_no AS studentNo, student_id AS studentId, student_pw AS studentPw FROM student WHERE student_no=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentNo);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				System.out.println("쿼리실행 결과 있는가? selectOneStudent");
				student = new Student();
				student.setStudentNo(resultSet.getInt("studentNo"));
				student.setStudentId(resultSet.getString("studentId"));
				student.setStudentPw(resultSet.getString("studentPw"));
				System.out.println(student + "<-- student selectOneStudent");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (SQLException e) {}
		}
		return student;
	}
	
	
	
	/* student를 매개변수로 받아 수정화면에서 입력한 Student 정보를 업데이트 하는 메서드*/
	public void modifyStudent(Student student) {
		System.out.println("modifyStudent StudentDao.java");
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE student SET student_pw=? WHERE student_no=?";
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getStudentPw());
			statement.setInt(2, student.getStudentNo());
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

	
	/*String타입의 studentId를 매개변수로 받아 student id를 체크하는 메서드*/
	public boolean sIdCheck(String studentId) {
		System.out.println("sIdCheck StudentDao.java");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean result = false;
		String sql = "SELECT student_id AS studentId FROM student WHERE student_id = ?";
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setString(1, studentId);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				result = true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if(statement != null) try { statement.close(); } catch(SQLException ex) {}
			if(connection != null) try { connection.close(); } catch(SQLException ex) {}
		}

		return result;
	}
	
	
}
