/*[김재희]*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/getStudentAddrList.jjdev")
public class GetStudentAddrListController extends HttpServlet {
	private StudentAddrDao studentAddrDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet GetStudentAddrListController.java");
		/* studentNo를 파라미터로 가져와 integer.parseint로 숫자로 변환시켜
		 * int 타입의 studentNo에 초기화한다*/ 
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		System.out.println(studentNo + "<--studentNo GetStudentAddrListController.java ");
		/* studentAddrDao에 매개변수로 studentNo를 넘겨 학생의주소를 select하는 메서드를 호출해 리턴받은 값을 list에 
		 * 담는다 */
		studentAddrDao = new StudentAddrDao();
		ArrayList<StudentAddr> list = studentAddrDao.selectStudentAddrList(studentNo);
		/*request객체에 list를 셋팅하고 카운트도 셋팅한다*/ 
		request.setAttribute("list", list);
		request.setAttribute("studentAddrCount", studentAddrDao.studntAddrCount(studentNo));
		request.getRequestDispatcher("/WEB-INF/views/getStudentAddrList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost GetStudentAddrListController.java");
		/*글자가 깨지지 않도록 인코딩한다 */ 
		request.setCharacterEncoding("UTF-8");
		/*studentAddr객체를 생성한 후 파라미터로 가져온 정보들을 셋팅한다 */
		StudentAddr studentAddr = new StudentAddr();
		studentAddr.setStudentNo(Integer.parseInt(request.getParameter("studentNo")));
		studentAddr.setAddress(request.getParameter("studentAddress"));
		/*studentAddrDao에 insertStudentAddr메서드를 실행 studentAddr을 매개변수로 넘겨준다
		 * 그후 리스트로 리다이렉트 해준다 */
		studentAddrDao = new StudentAddrDao();
		studentAddrDao.insertStudentAddr(studentAddr);
		response.sendRedirect(request.getContextPath() + "/getStudentAddrList.jjdev?studentNo="+studentAddr.getStudentNo());
	}

}
