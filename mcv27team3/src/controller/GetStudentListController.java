package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

/**
 * Servlet implementation class getStudentListController
 */
@WebServlet("/getStudentList.lim")
public class GetStudentListController extends HttpServlet {
	private StudentDao studentdao;
	private Student student;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request
		this.student = new Student();
		//studentDAO
		this.studentdao = new StudentDao();
		//request에 속성추가
		//forward
		request.getRequestDispatcher("/WEB-INF/views/getStudentList.jsp").forward(request, response);
	}
}
