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

@WebServlet("/getStudentList.team3")
public class GetStudentListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int pagePerRow = 10; //요청페이지에서 받을 수도 있다.
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}	
		
		int startRow = (currentPage-1)*pagePerRow;
		
		ArrayList<Student> arrayStudent = new ArrayList<Student>();
		StudentDao studentdao = new StudentDao();
		arrayStudent = studentdao.selectStudent(startRow, pagePerRow);
		
		int totalRowCount = studentdao.studentRowCount();
		int lastPage = totalRowCount/pagePerRow;
		if(totalRowCount % pagePerRow != 0) {
			lastPage++;
		}
		
		request.setAttribute("arrayStudent", arrayStudent);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		//forward
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentList.jsp").forward(request, response);
	} 
}

