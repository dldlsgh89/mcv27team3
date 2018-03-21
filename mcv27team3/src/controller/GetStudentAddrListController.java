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
		
		int sendNo = 0;
		
		sendNo = Integer.parseInt(request.getParameter("sendNo"));
		ArrayList<StudentAddr> arrayStudentAddr = new ArrayList<StudentAddr>();
		StudentAddrDao studentAddrdao = new StudentAddrDao();
		arrayStudentAddr = studentAddrdao.selectStudentAddr(sendNo);
		
		HttpSession session = request.getSession();
		session.setAttribute("sendNO", sendNo);				
		request.setAttribute("arrayStudentAddr", arrayStudentAddr);
		
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentAddrList.jsp").forward(request, response);
	}
	
	
	
}