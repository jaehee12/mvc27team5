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

@WebServlet("/modifyTeacher.jjdev")
public class ModifyTeacher extends HttpServlet {
	private TeacherDao tdao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doGet ModifyTeacher controller---");
		// DAO -> teacherNo 로 조회하여 teacher 리턴받기
		Teacher teacher = new Teacher();
		teacher.setTeacherNo(Integer.parseInt(request.getParameter("teacherNo")));
		this.tdao = new TeacherDao();		
		teacher = tdao.selectForUpdateTeacher(teacher.getTeacherNo());
		// request 객체에 뷰에 뿌려줄 teacher 세팅
		request.setAttribute("teacher", teacher);
		// 뷰(수정화면)로 포워드
		request.getRequestDispatcher("/WEB-INF/views/modifyTeacher.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doPost ModifyTeacher controller---");
		// 수정화면에서 입력받은 한글이 깨질 수 있으므로 인코딩
		request.setCharacterEncoding("UTF-8");
		// (수정해서)입력받은 데이터(form-submit) 겟팅
		Teacher teacher = new Teacher();
		teacher.setTeacherNo(Integer.parseInt(request.getParameter("teacherNo")));
		teacher.setTeacherPw(request.getParameter("teacherPw"));
		// DAO -> 수정된 데이터를 셋팅한 teacher를 입력변수로 메서드 호출
		this.tdao = new TeacherDao();
		tdao.updateTeacher(teacher);
		// 수정처리 후 뷰는 리스트로 리다이렉트
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjdev");	
	}
}
