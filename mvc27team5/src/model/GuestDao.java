/*[진경수]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbConnection;

public class GuestDao {
	
	public int insertGuest(Guest guest) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO guest (guest_id, guest_pw) VALUES (?, ?)";
		int result = 0;
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
		String sql = "SELECT guest_no AS guestNo, guest_id AS guestId, guest_pw AS guestPw FROM guest";
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Guest guest = new Guest();
				guest.setGuestNo(resultSet.getString("guestNo"));
				guest.setGuestId(resultSet.getString("guestId"));
				guest.setGuestPw(resultSet.getString("guestPw"));
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
}
