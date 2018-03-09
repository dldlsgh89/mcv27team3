package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Teacher;
import Model.TeacherDao;


@WebServlet("/addTeacher.lee")
public class AddTeacherController extends HttpServlet {
	private TeacherDao teacherDao;
	private Teacher teacher;
	//teacher 입력 폼요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addTeacher.jsp").forward(request, response);
	}
	//teacher 입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.request 처리
		System.out.println(request.getParameter("teacherid")+"<----AddTeacherController");
		//Teacher setter 호출
		
		String teacherId = request.getParameter("teacherid");
		String teacherPw = request.getParameter("teacherpw");
		this.teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		teacher.setTeacherPw(teacherPw);
		
		
		this.teacherDao = new TeacherDao();
		teacherDao.insertTeacher(teacher);
		
		// 2. 모델(DAO) 호출
		response.sendRedirect(request.getContextPath()+"/getTeacherList.lee");
		// 3. 다른 controller 호출 (redirect)
	}
}
