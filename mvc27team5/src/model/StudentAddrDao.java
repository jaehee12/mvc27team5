// [김재희]
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbConnection;

public class StudentAddrDao {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	StudentAddr studentAddr = null;
	
	// 학생 주소추가 
	public int insertStudentAddr(StudentAddr studentAddr) {
		int result = 0;
		try {
			connection = DbConnection.dbConn();
			String sql = "INSERT INTO student_addr (student_no, address)  VALUES(?, ?)";
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
	public ArrayList<StudentAddr> selectStudentList() {
		ArrayList<StudentAddr> list = new ArrayList<StudentAddr>();
		try {
			connection = DbConnection.dbConn();
			String sql = "SELECT * FROM student_addr";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				studentAddr = new StudentAddr();
				studentAddr.setStudentAddrNo(resultSet.getInt("student_addr_no"));
				studentAddr.setStudentNo(resultSet.getInt("student_no"));
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
}
