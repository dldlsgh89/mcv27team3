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
		request.setCharacterEncoding("euckr");
		
		int StudentNo = Integer.parseInt(request.getParameter("StudentNo"));
		System.out.println(request.getParameter("StudentNo")+"<-----doGet  AddStudentAddrController.java");
		
		//Controller에서 StudentNo를 넘겨 받아 jsp파일로 뿌려준다.
		request.setAttribute("StudentNo", StudentNo);
		
		//form.jsp로 이동시켜준다.
		request.getRequestDispatcher("/WEB-INF/views/addStudentAddrForm.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euckr");
		
		int StudentNo = Integer.parseInt(request.getParameter("StudentNo"));
		String studentAddr = request.getParameter("studentAddr");
		System.out.println(StudentNo+"<-------doPost AddTeacherAddrController");
		System.out.println(studentAddr+"<-------doPost AddTeacherAddrController");
		
		studentAddrDao = new StudentAddrDao();
		studentAddrDao.insertStudentAddr(StudentNo, studentAddr);
		
		response.sendRedirect(request.getContextPath()+"/getStudentList.lim");
	}

}
