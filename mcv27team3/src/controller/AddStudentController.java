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
public class AddStudentController extends HttpServlet {
	private StudentDao studentdao;
	//student �Է� �� ��û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
	}
	//student �Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.request ó��
		String studentId = request.getParameter("studentId");
		System.out.println(studentId +"<--studentId");
		String studentPw = request.getParameter("studentPw");
		System.out.println(studentPw +"<--studentPw");
		
		//student setter ȣ��
		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
		
		//2. ��(DAO) ȣ��
		this.studentdao = new StudentDao();
		studentdao.insertStudent (student);
		
		//3. �ٸ� controller ȣ�� (redirect �Ѵ�)
		response.sendRedirect(request.getContextPath()+"/getStudentList.lim");
	}

}
