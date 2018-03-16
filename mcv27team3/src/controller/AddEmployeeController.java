package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDao;



@WebServlet("/addEmployee.pjh")
public class AddEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao;
	private Employee employee;
	// employee �Է� form ó��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/employee/addEmployee.jsp").forward(request, response);
	}

//employee �Է�	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String employeeId= request.getParameter("employeeId");
		String pwd = request.getParameter("pwd");
		System.out.println(employeeId+"employeeId");
		System.out.println(pwd+"<--pwd");
		
		this.employee = new Employee();		
		employee.setEmployeeId(employeeId);
		employee.setEmployeePw(pwd);
		
		this.employeeDao =new EmployeeDao();
		employeeDao.InsertEmployee(employee);
		
		response.sendRedirect(request.getContextPath()+"/getemployeelist.pjh");
	} //1.request ó��
	  //2.��(DAO)ȣ��
	  //3.redirect123
	
	
}