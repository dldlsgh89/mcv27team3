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

@WebServlet("/UpdateStudentController.lim")
public class UpdateStudentController extends HttpServlet {
	private StudentDao studentdao;
	private Student student;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int studentNo = (Integer.parseInt(request.getParameter("studentNO")));
		System.out.println(request.getParameter("studentNO")+"<-----doGet-----UpdateStudentController");
		
		this.studentdao = new StudentDao();
		
		this.student = new Student();
		student	 =	studentdao.SelectforUpdate(studentNo);
		
		request.setAttribute("student", student);
		
		
		request.getRequestDispatcher("/WEB-INF/views/updateStudentForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euckr");
		
		int studentNo = (Integer.parseInt(request.getParameter("studentNo")));
		System.out.println(studentNo+"<------doPost----UpdateStudentController");
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		
		this.student = new Student();
		student.setStudentNo(studentNo);
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
			
		studentdao.updateStudent(student);
		
		response.sendRedirect(request.getContextPath()+"/getStudentList.lee");
		
		//request.getRequestDispatcher(request.getContextPath()+"/GetTeacherListController").forward(request, response);
	}
}
