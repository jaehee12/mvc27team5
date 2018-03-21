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
		/* 서블릿에서 출력하기 위해  getWriter메서드 사용, 응답 출력스트림 받아온다*/
		PrintWriter out = response.getWriter();
		StudentDao studentDao = new StudentDao();
		if(studentDao.sIdCheck(request.getParameter("studentId"))) {
			// 만약 아이디가 있다면 1이 출력
			out.print("1");
		} else {
			// 아이디가 존재하지 않으면 
			out.print("0");
		}
		out.flush();
	}

}
