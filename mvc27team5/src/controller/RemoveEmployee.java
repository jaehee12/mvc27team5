package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmployeeDao;


@WebServlet("/removeEmployee.jjdev")
public class RemoveEmployee extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.deleteEmployee(Integer.parseInt(request.getParameter("employeeNo")));
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
	}


}
