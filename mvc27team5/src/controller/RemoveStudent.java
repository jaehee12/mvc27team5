/*[김재희]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDao;

@WebServlet("/removeStudent.jjdev")
public class RemoveStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet RemoveStudentController.java");
		StudentDao studentDao = new StudentDao();
		studentDao.removeStudent(Integer.parseInt(request.getParameter("studentNo")));
		response.sendRedirect(request.getContextPath() + "/getStudentList.jjdev");
	}


}
