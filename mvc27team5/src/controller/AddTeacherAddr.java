/*[유국화]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/addTeacherAddr.jjdev")
public class AddTeacherAddr extends HttpServlet {
	private TeacherAddrDao addrdao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doGet AddTeacherAddr controller---");
		// 조회할 데이터(teacheraddr) request 객체에 셋팅
		TeacherAddr teacheraddr = new TeacherAddr();
		teacheraddr.setTeacherNo(Integer.parseInt(request.getParameter("teacherNo")));
		request.setAttribute("teacheraddr", teacheraddr);
		// 뷰(주소입력화면)으로 포워드
		request.getRequestDispatcher("/WEB-INF/views/addTeacherAddr.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doPost AddTeacherAddr controller---");
		request.setCharacterEncoding("UTF-8");		
		// DAO -> this.teacherNo와 teacherAddr를 입력하는 메서드 호출		
		this.addrdao = new TeacherAddrDao();
		addrdao.insertTeacherAddr(Integer.parseInt(request.getParameter("teacherNo")), request.getParameter("teacherAddr"));	
		response.sendRedirect(request.getContextPath()+"/getTeacherAddrList.jjdev");
	}
}