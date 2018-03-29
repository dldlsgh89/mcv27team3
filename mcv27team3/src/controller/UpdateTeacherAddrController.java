//27기 3팀 이인호
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/UpdateTeacherAddrController.team3")
public class UpdateTeacherAddrController extends HttpServlet {
	private TeacherAddrDao teacherAddrDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		int teacherAddrNo = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(teacherAddrNo+"<--doGet---UpdateTeacherAddrController");
		
		this.teacherAddrDao = new TeacherAddrDao();
		
		TeacherAddr teacherAddr = new TeacherAddr();
		teacherAddr = teacherAddrDao.teacherAddrSelectforUpdate(teacherAddrNo);
		
		request.setAttribute("teacherAddr", teacherAddr);
		
		request.getRequestDispatcher("/WEB-INF/views/teacher/updateTeacherAddrForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	int teacherAddrNo = Integer.parseInt(request.getParameter("teacherAddrNo"));
	System.out.println(teacherAddrNo+"<-----doPost----UpdateTeacherAddrController");
	int teacherNo =	Integer.parseInt(request.getParameter("teacherNo"));
	String teacherAddress =	request.getParameter("teacherAddress");
	
	TeacherAddr teacherAddr = new TeacherAddr();
	teacherAddr.setTeacherAddrNo(teacherAddrNo);
	teacherAddr.setTeacherNo(teacherNo);
	teacherAddr.setAddress(teacherAddress);
	
	this.teacherAddrDao.updateTeacherAddr(teacherAddr);
	

	response.sendRedirect(request.getContextPath()+"/GetTeacherAddrListController.team3");
	
	}

}
