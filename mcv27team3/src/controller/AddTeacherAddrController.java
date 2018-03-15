package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddTeacherAddrController.lee")
public class AddTeacherAddrController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���Ե� number�� �ּҸ� �߰������� �Է� ����
		
		//����Ʈ���� �ּ� �߰��� ������ Controller�� ��ȯ
		int teacherNo = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(request.getParameter("sendNO")+"<-----AddTeacherAddrController");
		
		//��Ʈ�ѷ����� number�� �Ѱܹް� �ش� number�� �̹� �ԷµǾ� �����Ҽ� ���� jsp�� �ѷ��ش�.
		request.setAttribute("teacherNo", teacherNo);
		//�ش� jsp���� number ����, address_number�� ����� �Է�ó�� X ��������� �ּҰ��� �ϷµǴ� form �ۼ�
		
		request.getRequestDispatcher("/WEB-INF/views/addTeacherAddrForm.jsp").forward(request, response);
		
		//form �ۼ��� controller�� �Ѿ���� �Էµ� �����͸� Dao�� ������� query���� ���� 
		//list.jsp�� ������� ������
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
