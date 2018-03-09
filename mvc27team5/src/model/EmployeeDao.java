/*[백지훈]*/
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbConnection;

public class EmployeeDao {
	
	public int insertEmployee(Employee employee){
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO employee (employee_id, employee_pw) VALUES (?, ?)";
		int result = 0;
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setString(1, employee.getEmployeeId());
			statement.setString(2, employee.getEmployeePw());
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
	public ArrayList selectEmployee() {
		ArrayList<Employee> list = new ArrayList<Employee>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT employee_no AS employeeNo, employee_id AS employeeId, employee_pw AS employeePw FROM employee";
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeNo(resultSet.getInt("employeeNo"));
				employee.setEmployeeId(resultSet.getString("employeeId"));
				employee.setEmployeePw(resultSet.getString("employeePw"));
				list.add(employee);
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null) try { resultSet.close(); } catch(SQLException ex) { }
			if(statement != null) try { statement.close(); } catch(SQLException ex) { }
			if(connection != null) try { connection.close(); } catch(SQLException ex) { }
		}
		return list;
	}
}

