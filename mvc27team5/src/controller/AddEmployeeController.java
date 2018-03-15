/*[백지훈]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmployeeDao;
import model.Employee;

@WebServlet("/addEmployee.jjdev")
public class AddEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		
		// employee 값 셋팅
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeePw(employeePw);
		
		employeeDao = new EmployeeDao();
		employeeDao.insertEmployee(employee);
		
		
		response.sendRedirect(request.getContextPath()+"/getEmployeeList.jjdev");
	}


}

