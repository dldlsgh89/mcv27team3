package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/addStudent.lim")
public class addStudentController extends HttpServlet {
	private StudentDao studentdao;
	//student 입력 폼 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
	}
	//student 입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.request 처리
		String studentId = request.getParameter("studentid");
		System.out.println(studentId +"<--studentId");
		String studentPw = request.getParameter("studentpw");
		System.out.println(studentPw +"<--studentPw");
		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
		//student setter 호출
		this.studentdao = new StudentDao();
		studentdao.insertStudent (student);
		//2. 모델(DAO) 호출
		response.sendRedirect(request.getContextPath()+"/getStudentList.lim");
		//3. 다른 controller 호출 (redirect 한다)
	}

}
