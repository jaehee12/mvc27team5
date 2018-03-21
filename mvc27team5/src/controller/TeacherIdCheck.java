/*[유국화]*/
package controller;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TeacherDao;

@WebServlet("/teacherIdCheck.ykh")
public class TeacherIdCheck extends HttpServlet {
    public TeacherIdCheck() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("teacherId") + "test");
		// 서블릿에서 출력(out)하기 위한 response객체의 getWriter 메서드 호출
		PrintWriter out = response.getWriter();
		TeacherDao tDao = new TeacherDao();
		if(tDao.tIdCheck(request.getParameter("teacherId"))){
			//아이디가 존재하면 1
			out.print("1");
		}else{
			//아이디가 없으면
			out.print("0");
		}
		out.flush();
	}
}
