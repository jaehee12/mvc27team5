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
	private static final long serialVersionUID = 1L;
	private int teacherNo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doGet AddTeacherAddr controller---");
		// 조회할 데이터(teacherNo) 겟팅
		this.teacherNo = Integer.parseInt(request.getParameter("teacherNo"));
		// 뷰(주소입력화면)으로 포워드
		request.getRequestDispatcher("/WEB-INF/views/addTeacherAddr.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doPost AddTeacherAddr controller---");
		request.setCharacterEncoding("UTF-8");
		// 조회할 데이터 겟팅
		String teacherAddr = request.getParameter("teacherAddr");
		// request 객체에 셋팅
		// DAO -> this.teacherNo를 셀렉트해서 teacherAddr를 인서트하는 메서드 호출
		TeacherAddrDao addrdao = new TeacherAddrDao();
		addrdao.insertTeacherAddr(teacherNo, teacherAddr);
	}

}
