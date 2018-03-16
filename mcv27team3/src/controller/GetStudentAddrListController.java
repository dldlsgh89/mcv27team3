package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/GetStudentAddrListController.lim")
public class GetStudentAddrListController extends HttpServlet {
	private StudentAddrDao studentAddrdao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int sendNO = Integer.parseInt(request.getParameter("sendNO"));
				
		ArrayList<StudentAddr> arrayStudentAddr = new ArrayList<StudentAddr>();
		
		this.studentAddrdao = new StudentAddrDao();
		
		arrayStudentAddr = studentAddrdao.selectStudentAddr(sendNO);
		
		System.out.println(arrayStudentAddr.size()+"<------arrayStudent.size()  GetStudentAddrListController");
				
		request.setAttribute("arrayStudentAddr", arrayStudentAddr);
		
		request.getRequestDispatcher("/WEB-INF/views/getStudentAddrList.jsp").forward(request, response);
	}
	
	
}