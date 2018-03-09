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
	
	// employee 입력 폼요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);
	}

	//employee 입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeePw(employeePw);
		this.employeeDao = new EmployeeDao();
		employeeDao.insertEmployee(employee);
		//1.request 처리
		//2.모델 (DAO) 호출
		//3.다른 controller 호출 (redirect)
		response.sendRedirect(request.getContextPath()+"/getEmployeeList.jjdev");
	}


}

