/*package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
import model.EmployeeAddrDao;
import model.StudentAddr;
import model.StudentAddrDao;


@WebServlet("/GetEmployeeAddrListController")
public class GetEmployeeAddrListController extends HttpServlet {
	private EmployeeAddrDao employeeAddrdao;
    private EmployeeAddr employeeAddr;   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//request
		this.employeeAddr = new EmployeeAddr();
		
		//EmployeeDao
		ArrayList<EmployeeAddr> arrayStudentAddr = new ArrayList<EmployeeAddr>();
		this.employeeAddrdao = new EmployeeAddrDao();
		arrayEmployeetAddr = employeeAddrdao.selectStudentAddr();
				
		request.setAttribute("arrayStudentAddr", arrayStudentAddr);
	}

}
*/