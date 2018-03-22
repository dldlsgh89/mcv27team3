package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;


@WebServlet("/addTeacher.lee") 
public class AddTeacherController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/views/teacher/addTeacher.jsp").forward(request, response);		
		 
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		String teacherId = request.getParameter("teacherId"); 
		System.out.println(request.getParameter("teacherId")+"<----AddTeacherController");
		String teacherPw = request.getParameter("teacherPw");
		
		Teacher teacher = new Teacher(); 
		teacher.setTeacherId(teacherId); 
		teacher.setTeacherPw(teacherPw);
		
		
		TeacherDao teacherDao = new TeacherDao(); 
		teacherDao.insertTeacher(teacher); 
		
		
		
		response.sendRedirect(request.getContextPath()+"/getTeacherList.lee"); 
		
	}
}
