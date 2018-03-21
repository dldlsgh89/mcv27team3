package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;
import model.Teacher;

@WebServlet("/addStudent.lim")
public class AddStudentController extends HttpServlet {
	private StudentDao studentdao;
	private Student student;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/student/addStudent.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String studentId = request.getParameter("studentId");
		System.out.println(studentId +"<--AddStudentController.java");
		String studentPw = request.getParameter("studentPw");
		System.out.println(studentPw +"<--AddStudentController.java");
		
		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
		
		StudentDao studentdao = new StudentDao();
		studentdao.insertStudent(student);
		
		response.sendRedirect(request.getContextPath()+"/getStudentList.lim");
	}

}
