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
public class ModifyStudentController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet ModifyStudentController.java");
		
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.selectOneStudent(studentNo);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/views/modifyStudentForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("doPost ModifyStudentController.java");
		
		Student student = new Student();
		StudentDao studentDao = new StudentDao();
		
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		System.out.println(studentNo + "," + studentId + "," + studentPw + "<--studentNo, studentId, studentPw");
		 
		student.setStudentNo(studentNo);
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
		
		studentDao.modifyStudent(student);
		
		response.sendRedirect(request.getContextPath() + "/getStudentList.jjdev");
		
	}

}
