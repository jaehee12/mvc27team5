package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/addStudent.jjdev")
public class AddStudentController extends HttpServlet {
	private StudentDao studentDao;
       
	//student �Է� ����û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
	}

	//student�Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		Student student = new Student();
		// student setterȣ��
		
		StudentDao sutdentDao = new StudentDao();
		this.studentDao.insertStudent(student);
		response.sendRedirect(request.getContextPath() + "/getStudentList.jjdev");
		
		//1.requestó��
		//2.�� daoȣ��
		//3. list redirect
	}

}
