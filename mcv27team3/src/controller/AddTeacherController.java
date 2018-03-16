package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;


@WebServlet("/addTeacher.lee") //���ε� AddTeacherController�� �ּ�
public class AddTeacherController extends HttpServlet {
	 //���߿� ����ϰ� �� TeacherDaoŬ���� Ÿ���� ���� teacherDao�� �̸� ������ �д�
	//���߿� ����ϰ� �� TeacherŬ���� Ÿ���� ���� teacher�� �̸� ������ �д�
	
	
	//teacher �Է� ����û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/views/addTeacher.jsp").forward(request, response);		
		//insert ���� ȭ�� ���� ����� addTeacher.jsp�� ����ȴ� 
	}
	//teacher �Է�
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.request ó��
		
		//Teacher setter ȣ��
		
		request.setCharacterEncoding("UTF-8");
		
		String teacherId = request.getParameter("teacherId"); //addTeacher.jsp���� input�ڽ� name="teacherId"�� �Ѿ�� ���� �޾� String Ÿ�� ���� teacherId�� ��´�
		System.out.println(request.getParameter("teacherid")+"<----AddTeacherController");
		String teacherPw = request.getParameter("teacherPw");//addTeacher.jsp���� input�ڽ� name="teacherPw"�� �Ѿ�� ���� �޾� String Ÿ�� ���� teacherPw�� ��´�
		
		Teacher teacher = new Teacher(); //������ �ż����  TeacherŬ������ ��ü�� ������ �̸� �����ص� ���� teacher�� �������� �Ҵ��Ѵ�
		teacher.setTeacherId(teacherId); //teacher�� �Ҵ�Ⱥ �������� ã�ư� teacherId�� �����Ѵ�
		teacher.setTeacherPw(teacherPw);//teacher�� �Ҵ�Ⱥ �������� ã�ư� teacherPw�� �����Ѵ�
		
		
		TeacherDao teacherDao = new TeacherDao(); //������ �޼���� TeacherDaoŬ������ ��ü�� ������ �̸� �����ص� ���� teacherDao�� �������� �Ҵ��Ѵ�
		teacherDao.insertTeacher(teacher); //teacherDao�� �Ҵ�� �������� ã�ư� insertTeacher�޼��带 �����ϰ� �Էµ����ͷ� teacherId,teacherPw�� ���õ� teacher�� �������� �Է��Ѵ�
		
		
		// 2. ��(DAO) ȣ��
		response.sendRedirect(request.getContextPath()+"/getTeacherList.lee"); 
		//�������� listâ���� �̵��ϱ� ���� �ּ� getTeacherList.lee�� redirect�� ���ش� 
		//�ش��δ� GetTeacherListController.java�� ������ �Ǿ��ֱ� ������  GetTeacherListController.java�� �̵��Ѵ�
		
		
		// 3. �ٸ� controller ȣ�� (redirect)
	}
}
