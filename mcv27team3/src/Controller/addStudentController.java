package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Student;
import Model.StudentDao;

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
		//2. 모델(DAO) 호출
		//3. 다른 controller 호출 (redirect 한다)
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPs");
		Student student = new Student();
		//student setter 호출
		this.studentdao = new StudentDao();
		studentdao.insertStudent (student);
		response.sendRedirect("/WEB-INF/views/getStudentList.lim");
	}

}
