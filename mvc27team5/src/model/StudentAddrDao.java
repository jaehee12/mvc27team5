/*[김재희]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbConnection;

public class StudentAddrDao {
	
	// 학생 주소추가 
	// insertStudentAddr가 무슨 메서드인지 매개변수
	public int insertStudentAddr(StudentAddr studentAddr) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO student_addr (student_no, address)  VALUES(?, ?)";
		int result = 0;
		try {
			//db연결 및 드라이버 로딩
			connection = DbConnection.dbConn();
			//String 타입의 변수 sql에 insert쿼리문을 넣는다.   
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentAddr.getStudentNo());
			statement.setString(2, studentAddr.getAddress());
			result = statement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (SQLException e) {}
		}
		
		return result;
	}

	// 학생 주소록의 리스트조회
	public ArrayList<StudentAddr> selectStudentAddrList(int studentNo) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StudentAddr studentAddr = null;
		ArrayList<StudentAddr> list = new ArrayList<StudentAddr>();
		String sql = "SELECT student_addr_no AS studentAddrNo, student_no AS studentNo, address FROM student_addr WHERE student_no = ?";
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentNo);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				studentAddr = new StudentAddr();
				studentAddr.setStudentAddrNo(resultSet.getInt("studentAddrNo"));
				studentAddr.setStudentNo(resultSet.getInt("studentNo"));
				studentAddr.setAddress(resultSet.getString("address"));
				list.add(studentAddr);
			}	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (SQLException e) {}
		}
		return list;
	}
	
	// 학생리스트 갯수 카운트
	public int studntAddrCount(int studentNo) {
		ArrayList<StudentAddr> list = new ArrayList<StudentAddr>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int result = 0;
		String sql = "SELECT COUNT(*) AS studentCount FROM student_addr WHERE student_no = ?";
		
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentNo);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				result = resultSet.getInt("studentCount");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null) try { resultSet.close(); } catch(SQLException ex) { }
			if(statement != null) try { statement.close(); } catch(SQLException ex) { }
			if(connection != null) try { connection.close(); } catch(SQLException ex) { }
		}
		return result;
	}
	
	//학생리스트 전체삭제
	public int removeStudentAddr(String[] removeAddrList) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		String sql = "DELETE FROM student_addr WHERE student_addr_no = ?";
		
		try {
			connection = DbConnection.dbConn();
			for(String studentAddrNo : removeAddrList) {
				statement = connection.prepareStatement(sql);
				System.out.println(studentAddrNo + "<--studentAddrNo");
				statement.setInt(1, Integer.parseInt(studentAddrNo));
				result = statement.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) try { statement.close(); } catch(SQLException ex) { }
			if(connection != null) try { connection.close(); } catch(SQLException ex) { }
		}
		return result;
	}
}
