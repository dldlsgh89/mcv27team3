package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/GetTeacherAddrListController.lee")
public class GetTeacherAddrListController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��𼱰� �ּҸ���Ʈ���⸦ Ŭ���ÿ� ����Ǵ� �޼���
		//
		request.setCharacterEncoding("euckr");
		
		int sendNO = Integer.parseInt(request.getParameter("sendNO"));
		
		ArrayList<TeacherAddr> arrayTeacherAddr = new ArrayList<TeacherAddr>();
		
		TeacherAddrDao teacherAddrDao = new TeacherAddrDao();
		
		arrayTeacherAddr = teacherAddrDao.selectTeacherAddr(sendNO);
		
		System.out.println(arrayTeacherAddr.size()+"<------arrayTeacher.size()  GetTeacherAddrListController");
		
		request.setAttribute("arrayTeacherAddr", arrayTeacherAddr);
		
		
		request.getRequestDispatcher("/WEB-INF/views/getTeacherAddrList.jsp").forward(request, response);
		
		
	}

}