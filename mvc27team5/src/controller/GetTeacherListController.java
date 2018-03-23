/*[유국화]*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;

@WebServlet("/getTeacherList.jjdev")
public class GetTeacherListController extends HttpServlet {
	private TeacherDao teacherDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doGet GetTeacherListController controller---");
		// DAO -> list 출력하는 메서드 호출
		this.teacherDao = new TeacherDao();
		int pagePerrow = 10; // 페이지마다 레코드 3행
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage  = Integer.parseInt(request.getParameter("currentPage")); // 리스트에서 겟방식으로 보냄
		}
		int startRow = (currentPage-1)*pagePerrow+1; 
		int endRow = 10;
		ArrayList<Teacher> list = teacherDao.selectAllTeacher(startRow, endRow);
		int totalRowCount = teacherDao.teacherRowCount();
		int lastPage = totalRowCount/pagePerrow; // 25개면 2.5 에서 정수형이니까 2페이지가 됌
		if(totalRowCount % pagePerrow != 0){
			lastPage++;
		}		
						
		// request 객체에 list, currentPage, lastPage 셋팅
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request, response);
	}
}