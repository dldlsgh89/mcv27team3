//27기 3팀 임가현
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddrDao;
import model.TeacherAddrDao;

@WebServlet("/DeleteStudentAddrController.team3")
public class DeleteStudentAddrController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameterValues("checkbox[]")+"<------doPost---DeleteStudentAddrController.java");
		String[] checkbox = request.getParameterValues("checkbox[]");
		System.out.println(checkbox[0]+"<--checkbox---DeleteStudentAddrController.java");
				
		for(int i = 0; i<checkbox.length; i++) {
			int studentAddrNo = Integer.parseInt(checkbox[i]);
			StudentAddrDao studentAddrdao = new StudentAddrDao();
			studentAddrdao.deleteStudentAddr(studentAddrNo);
		}
	
		response.sendRedirect(request.getContextPath()+"/GetStudentAddrListController.team3");

	}

}
