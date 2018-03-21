/*[김재희]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDao;

@WebServlet("/removeStudent.jjdev")
public class RemoveStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet RemoveStudentController.java");
		/* studentDao 객체 생성해 준후 removeStudent메서드를 호출하는데 입력받은 studentNo를 숫자로 변환시킨 후 매개변수로 넘긴다 
		 * 그 후 리스트로 리다이렉트 한다 */
		StudentDao studentDao = new StudentDao();
		studentDao.removeStudent(Integer.parseInt(request.getParameter("studentNo")));
		response.sendRedirect(request.getContextPath() + "/getStudentList.jjdev");
	}


}
