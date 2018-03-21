/*[김재희]*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/getStudentList.jjdev")
public class GetStudentListController extends HttpServlet {
	private StudentDao studentDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*studentDao의 객체를 생성해주고 studentDao의 주소에 있는 selectStudentlist()메서드를 실행.
		 *메서드에서 리턴받은 list를 request에 셋팅하고 난 후 getStudentList.jsp로 포워드 한다.*/
		StudentDao studentDao = new StudentDao();
		ArrayList<Student> list = studentDao.selectStudentlist();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/getStudentList.jsp").forward(request, response);
	}

}

