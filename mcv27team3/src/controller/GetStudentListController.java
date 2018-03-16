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

@WebServlet("/getStudentList.lim")
public class GetStudentListController extends HttpServlet {
	private StudentDao studentdao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//studentDAO
		ArrayList<Student> arrayStudent = new ArrayList<Student>();
		this.studentdao = new StudentDao();
		arrayStudent = studentdao.selectStudent();
		
		request.setAttribute("arrayStudent", arrayStudent);
		

		//forward
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentList.jsp").forward(request, response);
	} 
}
