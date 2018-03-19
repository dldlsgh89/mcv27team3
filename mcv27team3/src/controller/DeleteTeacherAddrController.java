package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TeacherAddrDao;



@WebServlet("/DeleteTeacherAddrController.lee")
public class DeleteTeacherAddrController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int	teacherAddrNo = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(teacherAddrNo+"<----teacherAddrNo-DeleteTeacherAddrController");
		
		TeacherAddrDao teacherAddrDao = new TeacherAddrDao();
		int teacherNo = teacherAddrDao.deleteTeacherAddrSelect(teacherAddrNo);
		System.out.println(teacherNo+"<----teacherNo----DeleteTeacherAddrController");
		teacherAddrDao.deleteTeacherAddr(teacherAddrNo);
				
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("teacherNo", teacherNo);
		
		
		//request.getRequestDispatcher("/GetTeacherAddrListController2.lee").forward(request, response);
		
		response.sendRedirect(request.getContextPath()+"/GetTeacherAddrListController2.lee");
	}

}
