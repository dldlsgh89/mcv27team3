package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Teacher;
import Model.TeacherDao;

@WebServlet("/getTeacherList.lee")
public class GetTeacherListController extends HttpServlet {
	private TeacherDao teacherDao;
	private Teacher teacher;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		//request
		this.teacher = new Teacher();
		//TeacherDao
		
		this.teacherDao = new TeacherDao();
		//request에 속성 추가
		
		//forward
		
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request, response);
	}

}
