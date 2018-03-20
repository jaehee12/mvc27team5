/*[진경수]*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public ArrayList<GuestAddr> selectGuestAddrList(int guestNo){
		ArrayList<GuestAddr> list = new ArrayList<GuestAddr>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT guest_addr_no AS guestAddrNo, guest_no as guestNo, address from guest_addr where guest_no = ?";
		
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, guestNo);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				GuestAddr guestAddr = new GuestAddr();
				guestAddr.setGuestAddrNo(resultSet.getInt("guestAddrNo"));
				guestAddr.setGuestNo(resultSet.getInt("guestNo"));
				guestAddr.setAddress(resultSet.getString("address"));
				list.add(guestAddr);
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
	
	public int guestAddrCount(int guestNo){
		ArrayList<GuestAddr> list = new ArrayList<GuestAddr>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int result = 0;
		String sql = "SELECT count(*) AS guestCount from guest_addr where guest_no = ?";
		
		try {
			connection = DbConnection.dbConn();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, guestNo);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				result = resultSet.getInt("guestCount");
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
	
	public int removeGuestAddr(String[] removeAddrList) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		String sql = "DELETE FROM guest_addr WHERE guest_addr_no = ?";
		
		try {
			connection = DbConnection.dbConn();
			for(String guestAddrNo : removeAddrList) {
				statement = connection.prepareStatement(sql);
				System.out.println(guestAddrNo + "너머임");
				statement.setInt(1, Integer.parseInt(guestAddrNo));
				result = statement.executeUpdate();	
			}
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
