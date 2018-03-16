package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Teacher;
import model.TeacherDao;


@WebServlet("/getTeacherList.lee") 
public class GetTeacherListController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		request.setCharacterEncoding("UTF-8");
		
		ArrayList<Teacher> arrayTeacher = new ArrayList<Teacher>(); 
		
		TeacherDao teacherDao = new TeacherDao(); 
		arrayTeacher = teacherDao.selectTeacher(); 
													
				
		request.setAttribute("arrayTeacher", arrayTeacher); 
		
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request, response);
		
	}

}
