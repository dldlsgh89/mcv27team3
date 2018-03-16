package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDao;


@WebServlet("/UpdateEmployeeController.pjh")
public class UpdateEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao;
	private Employee employee;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euckr");
		
		int employeeNo = (Integer.parseInt(request.getParameter("employeeNo")));
		System.out.println(employeeNo+"<------doGEt----UpdateEmployeeController");
		
		this.employeeDao = new EmployeeDao();
		
		this.employee = new Employee();
		employee = employeeDao.SelectforUpdate(employeeNo);
		
		request.setAttribute("Employee", employee);
		
		request.getRequestDispatcher("/WEB-INF/views/updateEmployeeForm.jsp").forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euckr");
		
		int employeeNo = (Integer.parseInt(request.getParameter("employeeNo")));
		System.out.println(employeeNo+"<---------doPost-----UpdateEmployeeController");
		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		
		this.employee = new Employee();
		employee.setEmployeeNo(employeeNo);
		employee.setEmployeeId(employeeId);
		employee.setEmployeePw(employeePw);
		
		employeeDao.UpdateEmployee(employee);
		
		response.sendRedirect(request.getContextPath()+"/getemployeelist.pjh");
	}

}
