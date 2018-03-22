/*package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeeAddr;
import model.EmployeeAddrDao;




@WebServlet("/AddEmployeeAddrController.pjh")
public class AddEmployeeAddrController extends HttpServlet {
	private EmployeeAddrDao employeeAddrDao;
	private EmployeeAddr employeeAddr; 

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int EmployeeNo = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(request.getParameter("sendNO")+"<------doGet AddEmployeeAddrController");
		
		//Controller���� EmployeeNo�� �Ѱܹ޾� jsp���ѷ���
		request.setAttribute("EmployeeNo", EmployeeNo);
		//form.jsp�� �̵�
		request.getRequestDispatcher("/WEB-INF/views/employee/addEmployeeAddrForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int EmployeeNo = Integer.parseInt(request.getParameter("sendNO"));
		String employeeAddr = request.getParameter("employeeAddr");
		System.out.println(EmployeeNo+"<--------doPostAddAddEmployeeAddrController.java");
		System.out.println(employeeAddr+"<----------doPostAddEmployeeAddrController");
		
		employeeAddrDao = new EmployeeAddrDao();
		employeeAddrDao.InsertEmployeeAddr(EmployeeNo,employeeAddr);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("EmployeeNo", EmployeeNo);
		
		response.sendRedirect(request.getContextPath()+"/GetEmployeeAddrListController.pjh");
	}

}
*/