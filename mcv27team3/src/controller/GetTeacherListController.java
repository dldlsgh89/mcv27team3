package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Teacher;
import model.TeacherDao;


@WebServlet("/getTeacherList.lee") //���ε� GetTeacherListController�� �ּ�
public class GetTeacherListController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//AddTeacherController���� �Ѿ�� request,response�� �޴´�.
		//insert������ return�����Ͱ� ���� �װ����� �ż��尡 ���������µ� request�� response�� �޴� ������ �ֳ�? 
		//�׳� ���������� Ư���� �����͸� ���� �ʰ� All select ���ִ� model�� ���Ḹ �ϸ� �ȵǴ���? 
		//���࿡ model�� ���� request�� response�� ������ ��Ȯ�� �ű⿡ ���ִ°� ������?
		
		//TeacherDao Ŭ������ ��ü ����Ʈ�� select���ִ� �ż��带 �����Ѵ� 
	
		request.setCharacterEncoding("UTF-8");
		
		ArrayList<Teacher> arrayTeacher = new ArrayList<Teacher>(); //������ �ż���� TeacherŸ���� ArrayList ��ü�� ������ �������� arrayTeacher������ �Ҵ��Ѵ� 
		
		TeacherDao teacherDao = new TeacherDao(); //������ �޼���� TeacherDaoŬ������ ��ü�� ������ �̸� �����ص� ���� teacherDao�� �Ҵ��Ѵ�
		arrayTeacher = teacherDao.selectTeacher(); //teacherDao�� �������� ã�ư� selectTeacher�޼��带 �����Ѵ�
													//selectTeacher�޼��忡�� ���ϵ� �����͸� �̸� �����ص� �������� arrayTeacher�� �Ҵ��Ѵ�
				
		request.setAttribute("arrayTeacher", arrayTeacher); //request�� ����� ������� setAttribute�޼��带 ȣ�����ְ� �̸��� "arrayTeacher"�ΰͿ�  �������� arrayTeacher�� ��´�?
		
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request, response);
		//������ ������ �������� views���� �ѷ�����ϱ� ������ �̹����� forward �Ѵ�. request.getRequestDispatcher�� �̵��� ��θ� ����ص� �ش� ��η� forward�ؼ� request�� response�� �Ѱ��ش�
	}

}
