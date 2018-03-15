package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DbConnection;

public class EmployeeAddrDao {
	
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
