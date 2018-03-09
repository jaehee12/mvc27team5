/*[진경수]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Guest;
import model.GuestDao;

@WebServlet("/getGuestList.jk")
public class GetGuestListController extends HttpServlet {
	private GuestDao guestDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		guestDao = new GuestDao();
		request.setAttribute("list", guestDao.selectAllGuest());
		//request
		//GuestDao
		//request.setAttribute();
		//forward
		request.getRequestDispatcher("/WEB-INF/views/getGuestList.jsp").forward(request, response);
	}

}
