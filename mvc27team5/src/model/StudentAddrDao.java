/*[김재희]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbConnection;

public class StudentAddrDao {
	
	/* studentAddr을 매개변수로 받아 해당된 학생의 주소를 추가해주는 메서드
	 * 그 결과를 result에 담아 리턴 */	
	public int insertStudentAddr(StudentAddr studentAddr) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO student_addr (student_no, address)  VALUES(?, ?)";
		int result = 0;
		try {
			//db연결 및 드라이버 로딩
			connection = DbConnection.dbConn();
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

	/* int타입의 studentNo를 매개변수로 받아 학생주소 리스트를 조회하는 메서드
	 * 셋팅된 결과를 리스트에 추가해 리턴한다 */
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
	
	/* int 타입의 studentNo를 매개변수로 받아 학생리스트 갯수를 카운트하는 메서드*/
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
	
	/* removeAddrList를 매개변수로 받아 선택한 학생의 주소리스트를 전체삭제,삭제 하는 메서드*/
	public int removeStudentAddr(String[] removeAddrList) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		String sql = "DELETE FROM student_addr WHERE student_addr_no = ?";
		try {
			connection = DbConnection.dbConn();
			for(String studentAddrNo : removeAddrList) {
				System.out.println(removeAddrList + "<-- removeAddrList removeStudentAddr ");
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
