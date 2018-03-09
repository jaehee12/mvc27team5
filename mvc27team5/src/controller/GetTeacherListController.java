package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherDao;

@WebServlet("/getTeacherList.jjdev")
public class GetTeacherListController extends HttpServlet {
	private TeacherDao teacherDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request
		// Teacher DAO
		teacherDao = new TeacherDao();
		request.setAttribute("list", teacherDao.selectAllTeacher());
		// request
		// forward
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request, response);
	}

}
