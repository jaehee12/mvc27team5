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
		ArrayList<Teacher> list = teacherDao.selectAllTeacher();
		// request 객체에 list 셋팅
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request, response);
	}
}