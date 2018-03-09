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
	private EmployeeDao employeedao;
	private Employee employee;
	// employee �Է� form ó��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);
	}

//employee �Է�	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String employeeId= request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		
		Employee employee = new Employee();
		employee.setM_id(employeeId);
		employee.setM_pw(employeePw);
		
		this.employeedao = new EmployeeDao();
		this.employee = new Employee();
		
		this.employeedao =new EmployeeDao();
		employeedao.InsertEmployee(employee);
		
		response.sendRedirect("/WEB-INF/views/GetEmployeeList.jsp");
	} //1.request ó��
	  //2.��(DAO)ȣ��
	  //3.redirect
	
	
}