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
import model.Teacher;
import model.TeacherDao;

/**
 * Servlet implementation class getemployeelist
 */
@WebServlet("/getemployeelist.pjh")
public class GetEmployeeListController extends HttpServlet {
	private EmployeeDao employeedao;
	private Employee employee;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request
		request.setCharacterEncoding("euckr");
		
		//EmployeeDao
		ArrayList<Employee> arrayEmployee = new ArrayList<Employee>();
		
		this.employeedao = new EmployeeDao();
		arrayEmployee= employeedao.selectEmployee();
		//request에 속성 추가
		
		request.setAttribute("arrayEmployee", arrayEmployee);
		
		//request에 속성추가
		//forward
		request.getRequestDispatcher("/WEB-INF/views/getEmployeeList.jsp").forward(request, response);
	}

}
