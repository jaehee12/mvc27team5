/*[김재희]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/addStudentAddr.jjdev")
public class AddStudentAddr extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet AddStudentAddr.java");
		StudentAddr studentAddr = new StudentAddr();
		request.getRequestDispatcher("/WEB-INF/views/addStudentAddr.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("doPost AddStudentAddr.java");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentAddress = request.getParameter("studentAddr");
		System.out.println(studentNo + "," + studentAddress + "<-- studentNo,studentAddress");
		StudentAddr studentAddr = new StudentAddr();
		studentAddr.setStudentNo(studentNo);
		studentAddr.setAddress(studentAddress);
	
		StudentAddrDao studentAddrDao = new StudentAddrDao();
		studentAddrDao.insertStudentAddr(studentAddr);
		response.sendRedirect(request.getContextPath() + "/getStudentAddrList.jjdev");
		
	}

}
