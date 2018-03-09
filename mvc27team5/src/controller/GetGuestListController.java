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
		//추가한 guest정보를 출력하기위해 selectAllGuest메서드를 호출한다.
		//그리고 return받은 list객체를 request객체에 setting한다.
		request.setAttribute("list", guestDao.selectAllGuest());
		request.getRequestDispatcher("/WEB-INF/views/getGuestList.jsp").forward(request, response);
	}

}
