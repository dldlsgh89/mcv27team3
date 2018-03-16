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

@WebServlet("/GetTeacherAddrListController2.lee")
public class GetTeacherAddrListController2 extends HttpServlet {
		 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��𼱰� �ּҸ���Ʈ���⸦ Ŭ���ÿ� ����Ǵ� �޼���
		//
		
		
		request.setCharacterEncoding("UTF-8");
		//sendNO = (int)request.getAttribute("sendNO");
		//int	sendNO = Integer.parseInt(request.getParameter("sendNO"));
		
		HttpSession session = request.getSession(true);
		
		int sendNO = (int)session.getAttribute("teacherNo");
		
		System.out.println(sendNO+"<------GetTeacherAddrListController2");
		
		ArrayList<TeacherAddr> arrayTeacherAddr = new ArrayList<TeacherAddr>();
		
		TeacherAddrDao teacherAddrDao = new TeacherAddrDao();
		
		arrayTeacherAddr = teacherAddrDao.selectTeacherAddr(sendNO);
		
		System.out.println(arrayTeacherAddr.size()+"<------arrayTeacher.size()  GetTeacherAddrListController");
		//request.setAttribute("sendNO", sendNO);
		
		request.setAttribute("sendNO", sendNO);
		request.setAttribute("arrayTeacherAddr", arrayTeacherAddr);
		
		
		request.getRequestDispatcher("/WEB-INF/views/getTeacherAddrList.jsp").forward(request, response);
		
		
	}

}
