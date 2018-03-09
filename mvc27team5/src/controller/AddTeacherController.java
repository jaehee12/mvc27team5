package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;

/**
 * Servlet implementation class TeacherController
 */
@WebServlet("/addTeacher.jjdev")
public class AddTeacherController extends HttpServlet {
	private TeacherDao teacherDao;  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Teacher �Է� ��
		request.getRequestDispatcher("/WEB-INF/views/addTeacher.jsp").forward(request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Teacher �Է�(ID, PW)
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		// 2. ��(DAO_ ȣ��
		Teacher teacher = new Teacher();
		this.teacherDao = new TeacherDao();
		teacherDao.insertTeacher(teacher);		
		// 3. �Է��ϰ� ȭ������ϱ� list.jsp�� �����̷�Ʈ
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjdev");
	}
}