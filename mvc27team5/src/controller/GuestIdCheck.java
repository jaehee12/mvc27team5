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
		PrintWriter out = response.getWriter();
		GuestDao gDao = new GuestDao();
		if(gDao.gIdCheck(request.getParameter("guestId"))){			
			out.print("1");
		}else{
			out.print("0");
		}
		out.flush();
	}
}
