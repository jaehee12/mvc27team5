/*[진경수]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GuestDao;

@WebServlet("/removeGuest.jk")
public class RemoveGuest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDao gDao = new GuestDao();
		gDao.deleteGuest(Integer.parseInt(request.getParameter("guestNo")));
		response.sendRedirect(request.getContextPath() + "/getGuestList.jk");
	}
}
