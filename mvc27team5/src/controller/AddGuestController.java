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

//원래의 파일명을 보여주지않고, 아래와같은 이름으로 치환함.
@WebServlet("/addGuest.jk")
public class AddGuestController extends HttpServlet {
	private GuestDao guestDao;
	//get방식으로 addGuest.jk파일을 요구한 경우
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addGuest.jsp").forward(request, response);
	}
	//post방식으로 addGuest.jk파일을 요구한 경우
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//해당 request의 인코딩을 DB와 맞춰주지않으면, 한글이 깨지기 때문에, 치환시켜준다.
		request.setCharacterEncoding("UTF-8");
		//입력받은 정보를 setting할 guest객체를 생성한다. 
		Guest guest = new Guest();
		//guest정보 setting
		guest.setGuestId(request.getParameter("guestId"));
		guest.setGuestPw(request.getParameter("guestPw"));
		//guest에 들어가있는 정보를 토대로 DB에 추가하기위해 매개변수를 guest로 넘겨준다.
		guestDao = new GuestDao();
		guestDao.insertGuest(guest);
		//게스트를 추가한 뒤 추가된 리스트를 보여준다.
		response.sendRedirect(request.getContextPath() + "/getGuestList.jk");
	}
}
