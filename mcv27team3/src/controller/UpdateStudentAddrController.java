package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;
import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/UpdateStudentAddrController.team3")
public class UpdateStudentAddrController extends HttpServlet {
	private StudentAddrDao studentAddrDao;
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			  
			int studentAddrNo = Integer.parseInt(request.getParameter("sendNo"));
			System.out.println(studentAddrNo+"<--doGet---UpdatestudentAddrController");
			
			this.studentAddrDao = new StudentAddrDao();
			
			StudentAddr studentAddr = new StudentAddr();
			studentAddr = studentAddrDao.studentAddrSelectforUpdate(studentAddrNo);
			
			request.setAttribute("studentAddr", studentAddr);
			
			request.getRequestDispatcher("/WEB-INF/views/student/updateStudentAddrForm.jsp").forward(request, response);
		}
	
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			
		int studentAddrNo = Integer.parseInt(request.getParameter("studentAddrNo"));
		System.out.println(studentAddrNo+"<-----doPost----UpdateStudentAddrController");
		int studentNo =	Integer.parseInt(request.getParameter("studentNo"));
		String studentAddress =	request.getParameter("studentAddress");
		
		StudentAddr studentAddr = new StudentAddr();
		studentAddr.setStudentAddrNo(studentAddrNo);
		studentAddr.setStudentNo(studentNo);
		studentAddr.setAddress(studentAddress);
		
		this.studentAddrDao.updateStudentAddr(studentAddr);
		
	
		response.sendRedirect(request.getContextPath()+"/GetStudentAddrListController.team3");
		}

}
