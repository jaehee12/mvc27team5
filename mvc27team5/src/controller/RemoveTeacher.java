/*[유국화]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherDao;

@WebServlet("/removeTeacher.jjdev")
public class RemoveTeacher extends HttpServlet {
	private TeacherDao tdao;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doGet RemoveTeacher controller---");
		tdao = new TeacherDao();
		// 리턴받은 teacher는 선택한 teacherNo로 조회한 데이터
		tdao.removeTeacher(Integer.parseInt(request.getParameter("teacherNo")));
		// 리스트화면으로 리다이렉트
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjdev");
	}
}