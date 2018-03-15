/*[진경수]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DbConnection;

public class GuestAddrDao {
	
	public int insertGuestAddr(GuestAddr guestAddr) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		String sql = "INSERT INTO guest_addr (guest_no, address) VALUES (?, ?)";
		
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, guestAddr.getGuestNo());
			statement.setString(2, guestAddr.getAddress());
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
