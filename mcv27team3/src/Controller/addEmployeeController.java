package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Employee;
import Model.EmployeeDao;



@WebServlet("/addEmployee.pjh")
public class addEmployeeController extends HttpServlet {
	private EmployeeDao employeedao;
	private Employee employee;
	// employee 입력 form 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);
	}

//employee 입력	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String employeeId= request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		this.employeedao = new EmployeeDao();
		this.employee = new Employee();
	
		
		response.sendRedirect("/WEB-INF/views/GetEmployeeList.jsp");
	} //1.request 처리
	  //2.모델(DAO)호출
	  //3.redirect
	
	
}