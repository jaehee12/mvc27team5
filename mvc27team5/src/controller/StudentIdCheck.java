/*[김재희]*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDao;

@WebServlet("/studentIdCheck.jjdev")
public class StudentIdCheck extends HttpServlet {
	
    public StudentIdCheck() {
        super();       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("studentId") + "test");
		PrintWriter out = response.getWriter();
		StudentDao studentDao = new StudentDao();
		if(studentDao.sIdCheck(request.getParameter("studentId"))) {
			out.print("1");
		} else {
			out.print("0");
		}
		out.flush();
	}

}
