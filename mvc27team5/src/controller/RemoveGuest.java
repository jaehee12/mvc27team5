/*[진경수]*/
package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestAddrDao;
import model.GuestDao;

@WebServlet("/removeGuest.jk")
public class RemoveGuest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDao gDao = new GuestDao();
		GuestAddrDao gAddrDao = new GuestAddrDao();
		int guestNo = Integer.parseInt(request.getParameter("guestNo"));
		try {
			gDao.deleteGuest(guestNo);
		} catch (SQLException e) {
			request.setAttribute("noDap", guestNo);
		} finally {
			response.sendRedirect(request.getContextPath() + "/getGuestList.jk");
		}
	}
}
