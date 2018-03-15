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
	
	public int deleteEmployee(int employeeNo) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int result = 0;
		String sql = " DELETE FROM employee WHERE employee_no = ? ";
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

	public Employee selectForUpdate(int employeeNo) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Employee employee = new Employee();
		String sql = "SELECT employee_no AS employeeNo, employee_id AS employeeId, employee_pw AS employeePw FROM employee WHERE employee_no = ?";
		
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, employeeNo);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				employee.setEmployeeNo(resultSet.getInt("employeeNo"));
				employee.setEmployeeId(resultSet.getString("employeeId"));
				employee.setEmployeePw(resultSet.getString("employeePw"));
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) try { statement.close(); } catch(SQLException ex) { }
			if(connection != null) try { connection.close(); } catch(SQLException ex) { }
		}
		return employee; 
	}
	
	public int updateEmployee(Employee employee) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int result = 0;
		String sql = "UPDATE employee SET employee_pw = ? WHERE employee_no = ?";
		
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setString(1, employee.getEmployeePw());
			statement.setInt(2, employee.getEmployeeNo());
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

