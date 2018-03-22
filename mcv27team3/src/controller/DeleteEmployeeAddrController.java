package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddrDao;

@WebServlet("/DeleteEmployeeAddrController")
public class DeleteEmployeeAddrController extends HttpServlet {
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameterValues("checkbox[]")+"<------doPost---DeleteEmployeeAddrController");
		String[] checkbox = request.getParameterValues("checkbox[]");
		System.out.println(checkbox[0]+"<--checkbox---DeleteEmployeeAddrController");
		
		for(int i = 0; i<checkbox.length; i++) {
			int employeeAddrNo = Integer.parseInt(checkbox[i]);
			TeacherAddrDao teacherAddrDao = new TeacherAddrDao();
			teacherAddrDao.deleteTeacherAddr(employeeAddrNo);
		}
		
		response.sendRedirect(request.getContextPath()+"/GetEmployeeAddrListController.pjh");
	}

}
