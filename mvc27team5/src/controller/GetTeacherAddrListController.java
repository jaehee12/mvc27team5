/*[유국화]*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/getTeacherAddrList.jjdev")
public class GetTeacherAddrListController extends HttpServlet {
	private TeacherAddrDao teacherAddrDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doGet GetTeacherAddrListController controller---");
		// DAO -> 리스트 출력하는 메서드 호출
		int teacherNo = Integer.parseInt(request.getParameter("teacherNo"));
		this.teacherAddrDao = new TeacherAddrDao();
		ArrayList<TeacherAddr> list = teacherAddrDao.selectTeacherAddrList(teacherNo);		
		// request 객체에 list 셋팅
		request.setAttribute("list", list);
		request.setAttribute("teacherAddrCount", teacherAddrDao.teacherAddrCount(teacherNo));
		request.getRequestDispatcher("/WEB-INF/views/getTeacherAddrList.jsp").forward(request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doPost GetTeacherAddrListController controller---");
		request.setCharacterEncoding("UTF-8");
		// 주소입력폼에서 보낸 데이터 셋팅
		TeacherAddr teacheraddr = new TeacherAddr();
		teacheraddr.setTeacherNo(Integer.parseInt(request.getParameter("teacherNo")));
		teacheraddr.setAddress(request.getParameter("teacherAddress"));		
		// DAO -> 주소입력 메서드 호출
		this.teacherAddrDao = new TeacherAddrDao();
		teacherAddrDao.insertTeacherAddr(teacheraddr);
		// 주소리스트로 리다이렉트
		response.sendRedirect(request.getContextPath()+"/getTeacherAddrList.jjdev?teacherNo="+teacheraddr.getTeacherNo());
	}	
}