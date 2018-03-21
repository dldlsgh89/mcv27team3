package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/GetTeacherAddrListController.lee")
public class GetTeacherAddrListController extends HttpServlet {
		 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.setCharacterEncoding("UTF-8");
		int teacherNo = 0;
		HttpSession session = request.getSession();	
		//if문으로 GetTeacherAddrListController와 GetTeacherAddrListController2 합치기
		if(request.getParameter("sendNO") != null) {
			teacherNo = Integer.parseInt(request.getParameter("sendNO"));	
			session.setAttribute("teacherNo", teacherNo);
		}else {			
			teacherNo = (int)session.getAttribute("teacherNo");
		}
		
		System.out.println(teacherNo+"<----GetTeacherAddrListController");
		
		ArrayList<TeacherAddr> arrayTeacherAddr = new ArrayList<TeacherAddr>();
		
		TeacherAddrDao teacherAddrDao = new TeacherAddrDao();
		
		arrayTeacherAddr = teacherAddrDao.selectTeacherAddr(teacherNo);
		
		System.out.println(arrayTeacherAddr.size()+"<------arrayTeacher.size()  GetTeacherAddrListController");		
		request.setAttribute("arrayTeacherAddr", arrayTeacherAddr);
		
		
		request.getRequestDispatcher("/WEB-INF/views/teacher/getTeacherAddrList.jsp").forward(request, response);
		
		
	}

}
