package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;



@WebServlet("/DeleteStudentController.team3")
public class DeleteStudentController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int	sendNO = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(sendNO+"<-----DeleteStudentController.java");
		
		StudentDao studentdao = new StudentDao();
		studentdao.deleteStudent(sendNO);
		
		response.sendRedirect(request.getContextPath()+"/getStudentList.team3");
	}
}
