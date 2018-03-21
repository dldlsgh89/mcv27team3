package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeeAddr;
import model.EmployeeAddrDao;
import model.StudentAddr;
import model.StudentAddrDao;


@WebServlet("/GetEmployeeAddrListController.pjh")
public class GetEmployeeAddrListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int EmployeeNo = 0;
		HttpSession session = request.getSession();
		
		if(request.getParameter("sendNO") != null) {
			EmployeeNo = Integer.parseInt(request.getParameter("sendNO"));
			session.setAttribute("EmployeeNo", EmployeeNo);
		}else {
			EmployeeNo = (int)session.getAttribute("EmployeeNo");
		}
	
		System.out.println(EmployeeNo+"<---GetStudentAddrListController");
		
		ArrayList<EmployeeAddr> arrayEmployeeAddr = new ArrayList<EmployeeAddr>();
		
		EmployeeAddrDao employeeAddrDao = new EmployeeAddrDao();
		
		arrayEmployeeAddr = employeeAddrDao.selectEmployeeAddr(EmployeeNo);
		
		System.out.println(arrayEmployeeAddr.size()+"<----arrayEmployeeAddr.size() GetEmployeeAddrListController");
		
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeAddList.jsp").forward(request, response);
		
	}

}
