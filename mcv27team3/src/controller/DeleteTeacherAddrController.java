package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Teacher;
import model.TeacherAddrDao;



@WebServlet("/DeleteTeacherAddrController.lee")
public class DeleteTeacherAddrController extends HttpServlet {
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		System.out.println(request.getParameterValues("checkbox[]")+"<------doPost---DeleteTeacherAddrController");
		String[] checkbox = request.getParameterValues("checkbox[]");
		System.out.println(checkbox[0]+"<--checkbox---DeleteTeacherAddrController");
				
		for(int i = 0; i<checkbox.length; i++) {
			int teacherAddrNo = Integer.parseInt(checkbox[i]);
			TeacherAddrDao teacherAddrDao = new TeacherAddrDao();
			teacherAddrDao.deleteTeacherAddr(teacherAddrNo);
		}
	
		response.sendRedirect(request.getContextPath()+"/GetTeacherAddrListController.lee");
		
	}

}
