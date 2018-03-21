/*[유국화]*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddrDao;

@WebServlet("/removeTeacherAddr.ykh")
public class RemoveTeacherAddr extends HttpServlet {
	private TeacherAddrDao taddrdao = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] removeAddrList = request.getParameterValues("teacherAddrNoList");
		if(removeAddrList != null) {
			this.taddrdao = new TeacherAddrDao();
			taddrdao.removeTeacherAddr(removeAddrList);
		}
		response.sendRedirect(request.getContextPath() + "/getTeacherAddrList.jjdev?teacherNo="+request.getParameter("teacherNo"));
	}

}
