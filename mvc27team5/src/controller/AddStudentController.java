// [김재희]
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/addStudent.jjdev")
public class AddStudentController extends HttpServlet {
	private StudentDao studentDao;
    /* get방식으로 요청하면 ""에 있는 경로로 포워드 한다*/  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
	}
	/*add폼에서 post방식으로 요청한 경우  한글이 깨지는 것을 방지하기 위해 setCharacterEncoding 해주고, 
	 * request객체의 getParameter studentId 와 studentPw를 매개변수로 메소드를 호출해 겟팅해 String타입의 studentId,studentPw 변수들에 각각 담는다. */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		
		/*Student의 객체를 생성 하고 student참조변수 주소를 찾아 set메서드를 실행해 정보들을 담은 매개변수인 studentId를 셋팅한다.*/
		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
		
		/*StudentDao의 객체생성후 studentDao의 주소를 찾아 student를 매개변수로 insertStudent메소드를 실행해 학생들의 아이디,비번등을 db에 연결하고 추가한다.
		 *추가해준뒤 리스트로 리다이렉트 해준다. */
		StudentDao studentDao = new StudentDao();
		studentDao.insertStudent(student);
		response.sendRedirect(request.getContextPath() + "/getStudentList.jjdev");
		
		
	}

}
