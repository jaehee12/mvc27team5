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
		int currentPage = 1;
		//처음은 무조건 1셋팅
		int startRow = 0;
		//한페이지에몇라인출력?
		int pagePerRow = 10;
		//총 몇개의 라인이있는지
		int totalRowCount = guestDao.guestRowCount();
		//한페이지에 해당라인만큼만 출력할거면 몇페이지가 있어야되지?
		int lastPage = totalRowCount/pagePerRow;
		//1~9는 0표시로되니까 만약 나머지가 1개라도있으면 ++ 시켜줌
		if(totalRowCount%pagePerRow != 0){
			lastPage++;
		}
		if(request.getParameter("currentPage") != null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			startRow = (currentPage-1)*pagePerRow;
		}
		//얘는 보여줄 현제페이지의 번호순서중에 첫번째
		request.setAttribute("startPage", ((currentPage-1)/10)*10+1);
		System.out.println(currentPage);
		//얘는 현재페이지
		request.setAttribute("currentPage", currentPage);
		//얘는 보여줄것이아니라 아예 끝번호
		request.setAttribute("lastPage", lastPage);
		
		request.setAttribute("list", guestDao.selectGuest(startRow, pagePerRow));
		
		
		request.getRequestDispatcher("/WEB-INF/views/getGuestList.jsp").forward(request, response);
	}
}