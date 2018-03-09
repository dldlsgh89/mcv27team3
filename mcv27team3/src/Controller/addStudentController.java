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
	//student �Է� �� ��û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
	}
	//student �Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.request ó��
		//2. ��(DAO) ȣ��
		//3. �ٸ� controller ȣ�� (redirect �Ѵ�)
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPs");
		Student student = new Student();
		//student setter ȣ��
		this.studentdao = new StudentDao();
		studentdao.insertStudent (student);
		response.sendRedirect("/WEB-INF/views/getStudentList.lim");
	}

}
