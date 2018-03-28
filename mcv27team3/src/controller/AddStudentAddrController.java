//27기 3팀 임가현
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StudentAddr;
import model.StudentAddrDao;
import model.TeacherAddrDao;

@WebServlet("/AddStudentAddrController.team3")
public class AddStudentAddrController extends HttpServlet {
	private StudentAddrDao studentAddrDao;
	private StudentAddr studentAddr;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int studentNo = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(request.getParameter("sendNO")+"<-----doGet  AddTeacherAddrController.java");
		
		request.setAttribute("studentNo", studentNo);
		
		request.getRequestDispatcher("/WEB-INF/views/student/addStudentAddrForm.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentAddr = request.getParameter("studentAddr");
		System.out.println(studentNo+"<-------doPost AddStudentAddrController");
		System.out.println(studentAddr+"<-------doPost AddStudentAddrController");
		
		studentAddrDao = new StudentAddrDao();
		studentAddrDao.insertStudentAddr(studentNo, studentAddr);
		
		HttpSession session = request.getSession();
		session.setAttribute("studentNo", studentNo);
		
		response.sendRedirect(request.getContextPath()+"/GetStudentAddrListController.team3");
	}

}
