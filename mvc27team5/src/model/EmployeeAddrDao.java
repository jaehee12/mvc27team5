/*[백지훈]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DbConnection;

public class EmployeeAddrDao {
	
	public int deleteEmployeeAddr(int employeeNo) {
		int result = 0;
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		
		String sql = "DELETE FROM employee WHERE employee_no = ?";
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, employeeNo);
			result = statement.executeUpdate();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement != null) try { statement.close(); } catch(SQLException ex) {}
			if(connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return result;
		
		
	}
	
	public int insertEmployeeAddr(EmployeeAddr employeeAddr) {
		
		int result = 0;
		PreparedStatement statement = null;
		Connection connection = null;
		
		String sql = "INSERT INTO employee_addr (employee_no, address) VALUES (?, ?)";
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, employeeAddr.getEmployeeNo());
			statement.setString(2, employeeAddr.getAddress());
			result = statement.executeUpdate();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) try { statement.close(); } catch(SQLException ex) { }
			if(connection != null) try { connection.close(); } catch(SQLException ex) { }
		}
		return result;
	}
}
