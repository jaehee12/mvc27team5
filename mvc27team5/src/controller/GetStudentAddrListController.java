/*[김재희]*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/getStudentAddrList.jjdev")
public class GetStudentAddrListController extends HttpServlet {
	private StudentAddrDao studentAddrDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet GetStudentAddrListController.java");
		studentAddrDao = new StudentAddrDao();
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		System.out.println(studentNo + "<--studentNo GetStudentAddrListController.java ");
		ArrayList<StudentAddr> list = studentAddrDao.selectStudentAddrList(studentNo);
		request.setAttribute("list", list);
		request.setAttribute("studentAddrCount", studentAddrDao.studntAddrCount(studentNo));
		request.getRequestDispatcher("/WEB-INF/views/getStudentAddrList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost GetStudentAddrListController.java");
		request.setCharacterEncoding("UTF-8");
		studentAddrDao = new StudentAddrDao();
		StudentAddr studentAddr = new StudentAddr();
		studentAddr.setStudentNo(Integer.parseInt(request.getParameter("studentNo")));
		studentAddr.setAddress(request.getParameter("studentAddress"));
		studentAddrDao.insertStudentAddr(studentAddr);
		response.sendRedirect(request.getContextPath() + "/getStudentAddrList.jjdev?studentNo="+studentAddr.getStudentNo());
	}

}
