/*package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
import model.EmployeeAddrDao;

@WebServlet("/AddEmployeeAddrController.pjh")
public class AddEmployeeAddrController extends HttpServlet {
	private EmployeeAddrDao employeeAddrDao;
	private EmployeeAddr employeeAddr; 

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euckr");
		
		int EmployeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		System.out.println(request.getParameter("employeeNo")+"<------doGet AddEmployeeAddrController.java");
		
		//Controller���� EmployeeNo�� �Ѱܹ޾� jsp���ѷ���
		request.setAttribute("EmployeeNo", EmployeeNo);
		//form.jsp�� �̵�
		request.getRequestDispatcher("/WEB-INF/views/employee/addEmployeeAddrForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euckr");
		
		int EmployeeNo = Integer.parseInt(request.getParameter("EmployeeNo"));
		String employeeAddr = request.getParameter("employeeAddr");
		System.out.println(EmployeeNo+"<--------doPostAddAddEmployeeAddrController.java");
		System.out.println(employeeAddr+"<----------doPostAddEmployeeAddrController");
		
		employeeAddrDao = new EmployeeAddrDao();
		employeeAddrDao.InsertEmployeeAddr(EmployeeNo,employeeAddr);

		response.sendRedirect(request.getContextPath()+"/addEmployee.pjh");
	}

}
*/