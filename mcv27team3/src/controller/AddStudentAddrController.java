package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;
import model.TeacherAddrDao;

@WebServlet("/AddStudentAddrController.lim")
public class AddStudentAddrController extends HttpServlet {
	private StudentAddrDao studentAddrDao;
	private StudentAddr studentAddr;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���Խ� ���� �Ӹ��ƴ϶� �ѱ�,��� ���ڵ� 
		request.setCharacterEncoding("euckr");
		
		//list���� �ּ� �߰��� ������ Controller�� �̵�
		int studentNo = Integer.parseInt(request.getParameter("studentNO"));
		System.out.println(request.getParameter("studentNo")+"<-----doGet  AddTeacherAddrController.java");
		
		//��Ʈ�ѷ����� number�� �Ѱܹް� �ش� number�� �̹� �ԷµǾ� �����Ҽ� ���� jsp�� �ѷ��ش�.
		request.setAttribute("studentNo", studentNo);
		//�ش� jsp���� number ����, address_number�� ����� �Է�ó�� X ��������� �ּҰ��� �ϷµǴ� form �ۼ�
		
		request.getRequestDispatcher("/WEB-INF/views/addStudentAddrForm.jsp").forward(request, response);
		
		//form �ۼ��� controller�� �Ѿ���� �Էµ� �����͸� Dao�� ������� query���� ���� 
		//list.jsp�� ������� ������
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euckr");
		
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentAddr = request.getParameter("studentAddr");
		System.out.println(studentNo+"<-------doPost AddStudentAddrController");
		System.out.println(studentAddr+"<-------doPost AddStudentAddrController");
		
		studentAddrDao = new StudentAddrDao();
		studentAddrDao.insertStudentAddr(studentNo, studentAddr);
		
		response.sendRedirect(request.getContextPath()+"/GetStudentAddrListController.lim");
	}

}
