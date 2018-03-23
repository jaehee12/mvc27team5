/*[김재희]*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.glassfish.external.statistics.impl.StatsImpl;

import model.Student;
import model.StudentDao;

@WebServlet("/getStudentList.jjdev")
public class GetStudentListController extends HttpServlet {
	private StudentDao studentDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet GetStudentListController.java");
		/*studentDao의 주소에 있는 selectStudentlist()메서드를 실행.
		 *메서드에서 리턴받은 list를 request에 셋팅하고 난 후 getStudentList.jsp로 포워드 한다.*/
		//int startRow 바아와야함
		int pagePerRow = 10; // 고정값 고정할수도 있다
		int currentPage = 1; // 현재페이지는 1로 고정하지만 
		// getStudentList에서  가져온 현재 페이지가 null이 아닐때 
		if(request.getParameter("currentPage") != null) { 
			// 현재 페이지 가져와 숫자로 변환시킨후 그 페이지를 int타입의 currentPage 변수에 담는다  
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println(currentPage + "<--currentPage not null");
		}
		// startRow를 기준으로 생각해야함
		int startRow = (currentPage-1)*pagePerRow;
		System.out.println(startRow + "<--startRow GetStudentListController.java");
		
		this.studentDao = new StudentDao();
		// selectStudentlist 호출해 startRow, pagePerRow를 매개변수로 넘기고 리턴받으 값을 list에 담는다
		ArrayList<Student> list = studentDao.selectStudentlist(startRow, pagePerRow);
        // studentTotalRowCount메서드를 호출해 리턴받은 count를  totalRowCount에 저장함                 		
		int totalRowCount = studentDao.studentTotalRowCount();
		System.out.println(totalRowCount + "<-- totalRowCount GetStudentListController.java");
		// 총 학생정보 개수와 페이지를 보여줄 갯술를 나눈 값을 lastPage에 저장하고
		int lastPage = totalRowCount/pagePerRow;
		System.out.println(lastPage + "<--lastPage not ++");
		// 만약 두개를 나눈 값의 나머지가 0이 아니라면 하나씩 더한다
		if(totalRowCount % pagePerRow != 0) { //double로 하면 정확해질 수 있다
			lastPage++;
			System.out.println(lastPage + "<--lastPage++");
		}
		//request객체내에 list, currentPage, lastPage를 셋팅해준다
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		System.out.println(currentPage + "<--currentPage GetStudentListController.java");
		//studentList.jsp로 포워드한다
		request.getRequestDispatcher("/WEB-INF/views/getStudentList.jsp").forward(request, response);
	}

}

