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

@WebServlet("/addStudent.jjdev")
public class AddStudentController extends HttpServlet {
	private StudentDao studentDao;
    /* get방식으로 요청하면 ""에 있는 경로로 포워드 한다*/  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*add폼에서 post방식으로 요청한 경우  한글이 깨지는 것을 방지하기 위해 setCharacterEncoding 해준다*/
		request.setCharacterEncoding("UTF-8");
		/*student에 셋팅하기 위해 student의 객체를 생성해주고, request.getParameter로 입력받은 정보를 가져와 
		 * student에 Id와 pw를 셋팅한다   */
		Student student = new Student();
		student.setStudentId(request.getParameter("studentId"));
		student.setStudentPw(request.getParameter("studentPw"));
		/*studentDao의 객체를 생성해 insertStudent메서드를 셋팅했던 데이터가 있는 student를 매개변수로 실행한다.
		 *디비에 student의 정보를 추가하고 studentList가 가도록 리다이렉트한다 */ 
		studentDao = new StudentDao();
		studentDao.insertStudent(student);
		response.sendRedirect(request.getContextPath() + "/getStudentList.jjdev");
		
		
	}

}
