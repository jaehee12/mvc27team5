/*[백지훈]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDao;


@WebServlet("/modifyEmployee.jjdev")
public class ModifyEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao employeeDao = new EmployeeDao();
		//get방식으로 직원번호 받는다.
		request.setAttribute("employee", employeeDao.selectForUpdate(Integer.parseInt(request.getParameter("employeeNo"))));
		// 접근 
		request.getRequestDispatcher("/WEB-INF/views/modifyEmployee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Employee employee = new Employee();
		EmployeeDao employeeDao = new EmployeeDao();
		
		employee.setEmployeeNo(Integer.parseInt(request.getParameter("employeeNo")));
		employee.setEmployeeId(request.getParameter("employeeId"));
		employee.setEmployeePw(request.getParameter("employeePw"));
		
		employeeDao.updateEmployee(employee);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
		
		
	}

}
