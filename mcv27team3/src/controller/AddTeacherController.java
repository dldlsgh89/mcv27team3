//27기 3팀 이인호
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;


@WebServlet("/addTeacher.team3") 
public class AddTeacherController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/views/teacher/addTeacher.jsp").forward(request, response);	
		//입력받은 데이터가 없기때문에 veiw 부분인 addTeacher.jsp로 바로 forward해준다
		
		 
		//response.sendRedirect(request.getContextPath()+"/views/teacher/addTeacher.jsp");
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//veiw부분인 addTeacher.jsp에 post 방식으로 넘어온 데이터를 처리하는 메서드
		
		request.setCharacterEncoding("UTF-8");
		
		String teacherId = request.getParameter("teacherId"); //addTeacher.jsp의 form에서 name이 teacherId에 해당되는 곳의 입력데이터를 넘겨 받아 String 타입 teacherId변수에 담는다
		System.out.println(request.getParameter("teacherId")+"<----AddTeacherController");
		String teacherPw = request.getParameter("teacherPw"); //addTeacher.jsp의 form에서 name이 teacherPw에 해당되는 곳의 입력데이터를 넘겨 받아 String 타입 teacherPw변수에 담는다
		
		Teacher teacher = new Teacher(); //Teacher클래스 객체 생성후 변수 teacher에 참조
		teacher.setTeacherId(teacherId); //참조된 변수의 객체에 접근해서 teacherId,teacherPw setting
		teacher.setTeacherPw(teacherPw);
				
		TeacherDao teacherDao = new TeacherDao(); //TeacherDao클래스 객체 생성수 변수 teacherDao에 참조
		teacherDao.insertTeacher(teacher); //참조된 변수의 객체에 접근해서 teacherId,teacherPw가 setting된 teacher참조변수를 매개변수로 하는 메서드 insertTeacher메서드 실행
				
		response.sendRedirect(request.getContextPath()+"/getTeacherList.team3"); 
		//getTeacherList.lee로 redirect. veiw의 getTeacherList.jsp를 다시 보여준다
	}
}
