/*[진경수]*/
package controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import com.sun.xml.internal.txw2.Document;
import model.GuestDao;
@WebServlet("/guestIdCheck.jk")
public class GuestIdCheck extends HttpServlet {
    public GuestIdCheck() {
        super();
    }
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response, request.getParameter("guestId"));
	}*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("guestId") + "test");
		/*원래 jsp딴에서 해줘야하는데 web-inf안에는 접속이 불허하기때문에, 서블릿에서 접근해야함.
		그런데 , 서블릿에서 출력해주려면 response객체의 writer를 사용해야 한다.*/
		PrintWriter out = response.getWriter();
		GuestDao gDao = new GuestDao();
		if(gDao.gIdCheck(request.getParameter("guestId"))){
			//아이디가 존재하면 1
			out.print("1");
		}else{
			//아이디가 없으면
			out.print("0");
		}
		out.flush();
	}
}
