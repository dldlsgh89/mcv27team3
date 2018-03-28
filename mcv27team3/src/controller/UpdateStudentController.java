//27기 3팀 임가현
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

@WebServlet("/UpdateStudentController.team3")
public class UpdateStudentController extends HttpServlet {
	private StudentDao studentdao;
	private Student student;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int studentNo = (Integer.parseInt(request.getParameter("sendNO")));
		System.out.println(studentNo+"<-----doGet-----UpdateStudentController");
		
		this.studentdao = new StudentDao();
		
		this.student = new Student();
		student	 =	studentdao.SelectforUpdate(studentNo);
		
		request.setAttribute("student", student);
		
		
		request.getRequestDispatcher("/WEB-INF/views/student/updateStudentForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int studentNo = (Integer.parseInt(request.getParameter("studentNo")));
		System.out.println(studentNo+"<------doPost----UpdateStudentController");
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		
		this.student = new Student();
		student.setStudentNo(studentNo);
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
			
		studentdao.updateStudent(student);
		
		response.sendRedirect(request.getContextPath()+"/getStudentList.team3");
		
	}
}
