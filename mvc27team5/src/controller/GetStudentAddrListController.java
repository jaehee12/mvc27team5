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
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet GetStudentAddrListController.java");
		StudentAddrDao studentAddrDao = new StudentAddrDao();
		ArrayList<StudentAddr> list = studentAddrDao.selectStudentAddrList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/getStudentAddrList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost GetStudentAddrListController.java");
	}

}
