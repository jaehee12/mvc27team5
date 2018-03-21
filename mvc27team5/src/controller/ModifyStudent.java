/*[김재희]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/modifyStudent.jjdev")
public class ModifyStudent extends HttpServlet {
	/*StudentDao의 객체를 셋팅해주고 파라미터로 받은 studentNo를 Integer로 문자열을 숫자로 변환시킨후 
	 * selectOneStudent메서드의 매개변수로 넘겨 request에 셋팅 후 포워드 한다  */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet ModifyStudentController.java");
		StudentDao studentDao = new StudentDao();
		request.setAttribute("student", studentDao.selectOneStudent(Integer.parseInt(request.getParameter("studentNo"))));
		request.getRequestDispatcher("/WEB-INF/views/modifyStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost ModifyStudentController.java");
		/*폼에서 입력받은 내용이 깨지지 않도록 인코딩 한다*/
		request.setCharacterEncoding("UTF-8");
		/*student와 studentDao의 객체들을 생성한 후
		 * 파라미터로 받은 stuentNo를 integer.parsint로 문자열을 숫자로 변환시킨 후 student에 셋팅
		 * id와 pw는 파라미터로 받아 각각 student의 id와 pw에 셋팅한다
		 * 셋팅된 정보들이 있는 student를 매개변수로 modify메서드를 호출해 수정한다
		 * 그 후 리스트로 리다이렉트 해준다.*/
		Student student = new Student();
		StudentDao studentDao = new StudentDao();
		student.setStudentNo(Integer.parseInt(request.getParameter("studentNo")));
		student.setStudentId(request.getParameter("uStudentId"));
		student.setStudentPw(request.getParameter("uStudentPw"));
		studentDao.modifyStudent(student);
		response.sendRedirect(request.getContextPath() + "/getStudentList.jjdev");
		
	}

}
