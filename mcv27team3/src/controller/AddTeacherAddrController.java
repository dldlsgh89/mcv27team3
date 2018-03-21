package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/AddTeacherAddrController.lee")
public class AddTeacherAddrController extends HttpServlet {
	private TeacherAddrDao teacherAddrDao;
	private TeacherAddr teacherAddr;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int teacherNo = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(request.getParameter("sendNO")+"<-----doGet  AddTeacherAddrController");
		
		
		request.setAttribute("teacherNo", teacherNo);
		
		
		request.getRequestDispatcher("/WEB-INF/views/teacher/addTeacherAddrForm.jsp").forward(request, response);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int teacherNo = Integer.parseInt(request.getParameter("teacherNo"));
		String teacherAddr = request.getParameter("teacherAddr");
		System.out.println(teacherNo+"<-------doPost AddTeacherAddrController");
		System.out.println(teacherAddr+"<-------doPost AddTeacherAddrController");
		
		teacherAddrDao = new TeacherAddrDao();		
		teacherAddrDao.addTeacherAddress(teacherNo, teacherAddr);
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("teacherNo", teacherNo);		
		
		response.sendRedirect(request.getContextPath()+"/GetTeacherAddrListController.lee");
	}

}
