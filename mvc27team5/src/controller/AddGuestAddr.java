/*[진경수]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Guest;
import model.GuestAddr;
import model.GuestAddrDao;
import model.GuestDao;

@WebServlet("/addGuestAddr.jk")
public class AddGuestAddr extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestAddr guestAddr = new GuestAddr();
		//web-inf안에있기때문에 이렇게 접근해야함.
		request.setAttribute("guestNo", request.getParameter("guestNo"));
		request.getRequestDispatcher("/WEB-INF/views/addGuestAddr.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestAddrDao gAddrDao = new GuestAddrDao();
		GuestAddr guestAddr = new GuestAddr();
		//해당 request의 인코딩을 DB와 맞춰주지않으면, 한글이 깨지기 때문에, 치환시켜준다.
		request.setCharacterEncoding("UTF-8");
		//위에 doGet에서 보냈던것을 수정한 정보를 여기에서 받아서 객체에 셋팅해줌
		guestAddr.setGuestNo(Integer.parseInt(request.getParameter("guestNo")));
		guestAddr.setAddress(request.getParameter("guestAddr"));
		//수정 고고
		gAddrDao.insertGuestAddr(guestAddr);
		//수정한뒤 다시 리스트로 컴백 
		response.sendRedirect(request.getContextPath() + "/getGuestList.jk");
	}
}
