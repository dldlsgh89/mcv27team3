/*package controller;

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
		employeeAddr = employeeAddrDao.em
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
*/