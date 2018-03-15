// [김재희]
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDao;


@WebServlet("/removeStudent.jjdev")
public class RemoveStudentController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet RemoveStudentController.java");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		System.out.println(studentNo + "<-- studentNo RemoveStudentController.java");
		
		StudentDao studentDao = new StudentDao();
		studentDao.removeStudent(studentNo);
		response.sendRedirect(request.getContextPath() + "/getStudentList.jjdev");
	}


}
