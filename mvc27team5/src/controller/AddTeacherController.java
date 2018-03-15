/*[유국화]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;

@WebServlet("/addTeacher.jjdev")
public class AddTeacherController extends HttpServlet {
	private TeacherDao teacherDao;  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doGet AddTeacherController controller---");
		// 뷰(입력화면)으로 포워드
		request.getRequestDispatcher("/WEB-INF/views/addTeacher.jsp").forward(request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doPost AddTeacherController controller---");
		// 수정화면에서 입력받은 한글이 깨질 수 있으므로 인코딩
		request.setCharacterEncoding("UTF-8");
		// 입력화면에서 입력받은 데이터 겟팅
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		// 겟팅한 데이터 teacher객체에 셋팅
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		teacher.setTeacherPw(teacherPw);
		// DAO -> 입력처리 메서드 호출
		this.teacherDao = new TeacherDao();		
		teacherDao.insertTeacher(teacher);
		// 입력처리 후 뷰는 리스트로 리다이렉트
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjdev");
	}
}