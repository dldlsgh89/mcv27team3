package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;
import model.TeacherAddrDao;

@WebServlet("/AddStudentAddrController.lim")
public class AddStudentAddrController extends HttpServlet {
	private StudentAddrDao studentAddrDao;
	private StudentAddr studentAddr;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//입력값에 숫자,한글,영어를 쓸 수 있게 한다.
		request.setCharacterEncoding("utf8");
		
		int studentNo = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(request.getParameter("sendNO")+"<-----doGet  AddTeacherAddrController.java");
		
		request.setAttribute("studentNo", studentNo);
		
		request.getRequestDispatcher("/WEB-INF/views/addStudentAddrForm.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf8");
		
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentAddr = request.getParameter("studentAddr");
		System.out.println(studentNo+"<-------doPost AddStudentAddrController");
		System.out.println(studentAddr+"<-------doPost AddStudentAddrController");
		
		studentAddrDao = new StudentAddrDao();
		studentAddrDao.insertStudentAddr(studentNo, studentAddr);
		
		response.sendRedirect(request.getContextPath()+"/GetStudentAddrListController.lim");
	}

}
