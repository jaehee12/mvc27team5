package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDao;


@WebServlet("/removeStudent.jjdev")
public class DeleteStudentController extends HttpServlet {
	/*private StudentDao studentDao;*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet DeleteStudentController.java");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		System.out.println(studentNo + "<--studentNo DeleteStudentController.java");
		
		StudentDao studentDao = new StudentDao();
		studentDao.deleteStudent(studentNo);
		response.sendRedirect(request.getContextPath() + "/getStudentList.jjdev");
	}


}
