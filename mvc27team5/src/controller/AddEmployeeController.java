package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/addEmployee.jjdev")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// ���� �Է��� ��û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);		
	}
	
	// ���� �Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
	}

}


