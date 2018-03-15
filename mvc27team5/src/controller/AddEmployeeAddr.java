/*[백지훈]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;
import model.EmployeeAddr;
import model.EmployeeAddrDao;
import model.EmployeeDao;

@WebServlet("/addEmployeeAddr.jjdev")
public class AddEmployeeAddr extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeAddr employeeAddr = new EmployeeAddr();
		
		request.getRequestDispatcher("/WEB-INF/views/addEmployeeAddr.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeAddrDao employeeDao = new EmployeeAddrDao();
		EmployeeAddr employeeAddr = new EmployeeAddr();
		
		request.setCharacterEncoding("UTF-8");
		
		employeeAddr.setEmployeeNo(Integer.parseInt(request.getParameter("employeeNo")));
		employeeAddr.setAddress(request.getParameter("employeeAddr"));
		
		employeeDao.insertEmployeeAddr(employeeAddr);
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
	}
}
