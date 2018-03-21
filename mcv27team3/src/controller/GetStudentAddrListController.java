package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/GetStudentAddrListController.lim")
public class GetStudentAddrListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int sendNO = 0;
		HttpSession session = request.getSession();
		
		if(request.getParameter("sendNO") != null) {
			sendNO = Integer.parseInt(request.getParameter("sendNO"));
			session.setAttribute("sendNO", sendNO);
		}else {
			sendNO = (int)session.getAttribute("sendNO");
		}
		System.out.println(sendNO + "<-- sendNO GetStudentAddrListController.java");
		
		ArrayList<StudentAddr> arrayStudentAddr =  new ArrayList<StudentAddr>();
		StudentAddrDao studentAddrDao = new StudentAddrDao();
		arrayStudentAddr = studentAddrDao.selectStudentAddr(sendNO);
		System.out.println(arrayStudentAddr + "<-- arrayStudentAddr GetStudentAddrListController.java");
		
		request.setAttribute("arrayStudentAddr", arrayStudentAddr);
		
		
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentAddrList.jsp").forward(request, response);
	}
	
	
	
}