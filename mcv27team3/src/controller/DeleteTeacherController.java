package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;


@WebServlet("/DeleteTeacherController.lee")
public class DeleteTeacherController extends HttpServlet {
	private TeacherDao teacherDao;
	private Teacher teacher;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int	sendNO = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(sendNO+"<-----DeleteTeacherController");
		
		this.teacherDao = new TeacherDao();
		teacherDao.deleteTeacher(sendNO);
		
		response.sendRedirect(request.getContextPath()+"/getTeacherList.lee");
		
	}

}