/*[진경수]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import db.DbConnection;

public class GuestDao {
	
	public int updateGuest(Guest guest) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int result = 0;
		String sql = "UPDATE guest SET guest_pw = ? WHERE guest_no = ?";
		
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setString(1, guest.getGuestPw());
			statement.setInt(2, guest.getGuestNo());
			System.out.println(statement);
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
	
	public Guest selectForUpdate(int guestNo) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Guest guest = new Guest();
		String sql = "SELECT guest_no AS guestNo, guest_id AS guestId, guest_pw AS guestPw FROM guest WHERE guest_no = ?";
		
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, guestNo);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				guest.setGuestNo(resultSet.getInt("guestNo"));
				guest.setGuestId(resultSet.getString("guestId"));
				guest.setGuestPw(resultSet.getString("guestPw"));
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) try { statement.close(); } catch(SQLException ex) { }
			if(connection != null) try { connection.close(); } catch(SQLException ex) { }
		}
		return guest;
		
	}
	
	public int deleteGuest(int guestNo) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int result = 0;
		String sql = "DELETE FROM guest WHERE guest_no = ?";
		
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, guestNo);
			result = statement.executeUpdate();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) try { statement.close(); } catch(SQLException ex) { }
			if(connection != null) try { connection.close(); } catch(SQLException ex) { }
		}
		return result;
	}
	
	public int insertGuest(Guest guest) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		String sql = "INSERT INTO guest (guest_id, guest_pw) VALUES (?, ?)";
		
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setString(1, guest.getGuestId());
			statement.setString(2, guest.getGuestPw());
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
	
	public ArrayList<Guest> selectAllGuest() {
		ArrayList<Guest> list = new ArrayList<Guest>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT guest_no AS guestNo, guest_id AS guestId, guest_pw AS guestPw, (SELECT COUNT(guest_no) FROM guest_addr WHERE guest.guest_no = guest_addr.guest_no) AS guestCount FROM guest";
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Guest guest = new Guest();
				guest.setGuestNo(resultSet.getInt("guestNo"));
				guest.setGuestId(resultSet.getString("guestId"));
				guest.setGuestPw(resultSet.getString("guestPw"));
				guest.setGuestCount(resultSet.getInt("guestCount"));
				list.add(guest);
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
	
	
	public boolean gIdCheck(String guestId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Guest guest = new Guest();
		boolean result = false;
		String sql = "SELECT guest_id AS guestId FROM guest WHERE guest_id = ?";
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setString(1, guestId);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				result = true;
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
		return result;
		
	}
	
}
