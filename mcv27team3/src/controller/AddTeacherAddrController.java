package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/AddTeacherAddrController.lee")
public class AddTeacherAddrController extends HttpServlet {
	private TeacherAddrDao teacherAddrDao;
	private TeacherAddr teacherAddr;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���Ե� number�� �ּҸ� �߰������� �Է� ����
		request.setCharacterEncoding("UTF-8");
		//����Ʈ���� �ּ� �߰��� ������ Controller�� ��ȯ
		int teacherNo = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(request.getParameter("sendNO")+"<-----doGet  AddTeacherAddrController");
		
		//��Ʈ�ѷ����� number�� �Ѱܹް� �ش� number�� �̹� �ԷµǾ� �����Ҽ� ���� jsp�� �ѷ��ش�.
		request.setAttribute("teacherNo", teacherNo);
		//�ش� jsp���� number ����, address_number�� ����� �Է�ó�� X ��������� �ּҰ��� �ϷµǴ� form �ۼ�
		
		request.getRequestDispatcher("/WEB-INF/views/addTeacherAddrForm.jsp").forward(request, response);
		
		//form �ۼ��� controller�� �Ѿ���� �Էµ� �����͸� Dao�� ������� query���� ���� 
		//list.jsp�� ������� ������
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int sendNO = Integer.parseInt(request.getParameter("teacherNo"));
		String teacherAddr = request.getParameter("teacherAddr");
		System.out.println(sendNO+"<-------doPost AddTeacherAddrController");
		System.out.println(teacherAddr+"<-------doPost AddTeacherAddrController");
		
		teacherAddrDao = new TeacherAddrDao();		
		teacherAddrDao.addTeacherAddress(sendNO, teacherAddr);
		
		request.setAttribute("sendNO", sendNO);
		
				
		response.sendRedirect(request.getContextPath()+"/getTeacherList.lee");
		//request.getRequestDispatcher("/WEB-INF/views/getTeacherAddrList.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/GetTeacherAddrListController.lee");
	}

}
