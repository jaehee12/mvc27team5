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

@WebServlet("/modifyGuest.jk")
public class ModifyGuest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDao gDao = new GuestDao();
		//get방식으로 guestNo 받음
		request.setAttribute("guest", gDao.selectForUpdate(Integer.parseInt(request.getParameter("guestNo"))));
		//web-inf안에있기때문에 이렇게 접근해야함.
		request.getRequestDispatcher("/WEB-INF/views/modifyGuest.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Guest guest = new Guest();
		GuestDao gDao = new GuestDao();
		//해당 request의 인코딩을 DB와 맞춰주지않으면, 한글이 깨지기 때문에, 치환시켜준다.
		request.setCharacterEncoding("UTF-8");
		//위에 doGet에서 보냈던것을 수정한 정보를 여기에서 받아서 객체에 셋팅해줌
		guest.setGuestNo(Integer.parseInt(request.getParameter("guestNo")));
		guest.setGuestId(request.getParameter("guestId"));
		guest.setGuestPw(request.getParameter("guestPw"));
		//수정 고고
		gDao.updateGuest(guest);
		//수정한뒤 다시 리스트로 컴백 
		response.sendRedirect(request.getContextPath() + "/getGuestList.jk");
	}
}
