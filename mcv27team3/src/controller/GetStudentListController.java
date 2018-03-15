package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;
import model.Teacher;

/**
 * Servlet implementation class getStudentListController
 */
@WebServlet("/getStudentList.lim")
public class GetStudentListController extends HttpServlet {
	private StudentDao studentdao;
	private Student student;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euckr");
		//request
		this.student = new Student();
		
		//studentDAO
		ArrayList<Student> arrayStudent = new ArrayList<Student>();
		this.studentdao = new StudentDao();
		arrayStudent = studentdao.selectStudent();
		
		request.setAttribute("arrayStudent", arrayStudent);
		

		//forward
		request.getRequestDispatcher("/WEB-INF/views/getStudentList.jsp").forward(request, response);
	} 
}
