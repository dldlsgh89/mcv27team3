package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherDao;


@WebServlet("/DeleteTeacherAddrController.lee")
public class DeleteTeacherAddrController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int	sendNO = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(sendNO+"<-----DeleteTeacherController");
		
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.deleteTeacher(sendNO);
		
		response.sendRedirect(request.getContextPath()+"/getTeacherList.lee");
	}

}
