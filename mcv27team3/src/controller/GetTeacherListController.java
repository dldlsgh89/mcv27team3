package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;

@WebServlet("/getTeacherList.lee")
public class GetTeacherListController extends HttpServlet {
	private TeacherDao teacherDao;
	private Teacher teacher;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//AddTeacherController���� �Ѿ�� request,response�� �޴´�.
		//insert������ return�����Ͱ� ���� �װ����� �ż��尡 ���������µ� request�� response�� �޴� ������ �ֳ�? 
		//�׳� ���������� Ư���� �����͸� ���� �ʰ� All select ���ִ� model�� ���Ḹ �ϸ� �ȵǴ���? 
		
		//TeacherDao Ŭ������ ��ü ����Ʈ�� select���ִ� �ż��带 �����Ѵ� 
	
		
		//request
		this.teacher = new Teacher();
		//TeacherDao
		
		this.teacherDao = new TeacherDao();
		teacherDao.searchTeacherList();
		//request�� �Ӽ� �߰�
		
		//forward
		
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request, response);
	}

}
