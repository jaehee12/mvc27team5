package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Guest;
import model.GuestDao;


@WebServlet("/addGuest.jk")
public class AddGuestController extends HttpServlet {
	private GuestDao guestDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addGuest.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String guestId = request.getParameter("guestId");
		String guestPw = request.getParameter("guestPw");
		Guest guest = new Guest();
		guest.setGuestId(guestId);
		guest.setGuestPw(guestPw);
		guestDao = new GuestDao();
		guestDao.insertGuest(guest);
		response.sendRedirect(request.getContextPath() + "/getGuestList.jk");
	}
}
