package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
import model.EmployeeAddrDao;

@WebServlet("/UpdateEmployeeAddrController.pjh")
public class UpdateEmployeeAddrController extends HttpServlet {
	private EmployeeAddrDao employeeAddrDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int employeeAddrNo = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(employeeAddrNo+"<--doGet---UpdateEmployeeAddrController");
		
		this.employeeAddrDao = new EmployeeAddrDao();
		
		EmployeeAddr employeeAddr = new EmployeeAddr();
		employeeAddr = employeeAddrDao.employeeAddrSelectforUpdate(employeeAddrNo);
		
		request.setAttribute("employeeAddr", employeeAddr);
		
		request.getRequestDispatcher("/WEB-INF/views/employee/updateEmployeeForm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	int employeeAddrNo = Integer.parseInt(request.getParameter("employeeAddrNo"));
	System.out.println(employeeAddrNo+"<---doPost-----UpdateEmployeeAddrController");
	int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
	String employeeAddress = request.getParameter("employeeAddress");
	
	EmployeeAddr employeeAddr = new EmployeeAddr();
	employeeAddr.setEmployeeAddrNo(employeeAddrNo);
	employeeAddr.setEmployeeAddrNo(employeeAddrNo);
	employeeAddr.setAddress(employeeAddress);
	
	this.employeeAddrDao.updateEmployeeAddr(employeeAddr);
	
	response.sendRedirect(request.getContextPath()+"/GetEmployeeAddrListController.pjh");
	
	}

}
