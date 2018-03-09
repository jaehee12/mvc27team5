package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getStudentList.jjdev")
public class GetStudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request...		//GuestDao
		//request에 속성 추가
		//forward
		request.getRequestDispatcher("/WEB-INF/views/getStudentList.jsp").forward(request, response);
		
	}

	

}
