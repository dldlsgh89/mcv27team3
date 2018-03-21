package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;


@WebServlet("/UpdateTeacherController.lee")
public class UpdateTeacherController extends HttpServlet {
	private TeacherDao teacherDao;
	private Teacher teacher;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int teacherNo = (Integer.parseInt(request.getParameter("sendNO")));
		System.out.println(request.getParameter("sendNO")+"<-----doGet-----UpdateTeacherController");
		
		this.teacherDao = new TeacherDao();
		
		this.teacher = new Teacher();
		teacher	 =	teacherDao.teacherSelectforUpdate(teacherNo);
		
		request.setAttribute("teacher", teacher);
		
		
		request.getRequestDispatcher("/WEB-INF/views/teacher/updateTeacherForm.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));
		System.out.println(teacherNo+"<------doPost----UpdateTeacherController");
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		
		this.teacher = new Teacher();
		teacher.setTeacherNo(teacherNo);
		teacher.setTeacherId(teacherId);
		teacher.setTeacherPw(teacherPw);
			
		teacherDao.updateTeacher(teacher);
		
		response.sendRedirect(request.getContextPath()+"/getTeacherList.lee");
		
	}
}
