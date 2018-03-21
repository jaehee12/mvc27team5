/*[김재희]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/modifyStudent.jjdev")
public class ModifyStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet ModifyStudentController.java");
		StudentDao studentDao = new StudentDao();
		request.setAttribute("student", studentDao.selectOneStudent(Integer.parseInt(request.getParameter("studentNo"))));
		request.getRequestDispatcher("/WEB-INF/views/modifyStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost ModifyStudentController.java");
		request.setCharacterEncoding("UTF-8");
		Student student = new Student();
		StudentDao studentDao = new StudentDao();
		student.setStudentNo(Integer.parseInt(request.getParameter("studentNo")));
		student.setStudentId(request.getParameter("uStudentId"));
		student.setStudentPw(request.getParameter("uStudentPw"));
		studentDao.modifyStudent(student);
		response.sendRedirect(request.getContextPath() + "/getStudentList.jjdev");
		
	}

}
