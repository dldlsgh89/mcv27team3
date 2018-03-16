package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/GetStudentAddrListController.lim")
public class GetStudentAddrListController extends HttpServlet {
	private StudentAddrDao studentAddrdao;
	private StudentAddr studentAddr;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euckr");
		//request
		this.studentAddr = new StudentAddr();
		
		//studentDAO
		ArrayList<StudentAddr> arrayStudentAddr = new ArrayList<StudentAddr>();
		this.studentAddrdao = new StudentAddrDao();
		arrayStudentAddr = studentAddrdao.selectStudentAddr();
				
		request.setAttribute("arrayStudentAddr", arrayStudentAddr);
		

		//forward
		request.getRequestDispatcher("/WEB-INF/views/getStudentAddrList.jsp").forward(request, response);
	}
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euckr");
		
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentAddr = request.getParameter("studentAddr");
		System.out.println(studentNo+"<-------doPost AddStudentAddrController");
		System.out.println(studentAddr+"<-------doPost AddStudentAddrController");
		
		studentAddrdao = new StudentAddrDao();
		studentAddrdao.insertStudentAddr(studentNo, studentAddr);
		
		response.sendRedirect(request.getContextPath()+"/getStudentAddrList.jsp");
	}
*/
}