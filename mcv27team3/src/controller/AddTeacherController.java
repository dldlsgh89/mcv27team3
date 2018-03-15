package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;


@WebServlet("/addTeacher.lee") //맴핑된 AddTeacherController의 주소
public class AddTeacherController extends HttpServlet {
	 //나중에 사용하게 될 TeacherDao클래스 타입의 변수 teacherDao을 미리 선언해 둔다
	//나중에 사용하게 될 Teacher클래스 타입의 변수 teacher을 미리 선언해 둔다
	
	
	//teacher 입력 폼요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/views/addTeacher.jsp").forward(request, response);		
		//insert 시작 화면 연결 실행시 addTeacher.jsp로 연결된다 
	}
	//teacher 입력
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.request 처리
		
		//Teacher setter 호출
		
		request.setCharacterEncoding("euc-kr");
		
		String teacherId = request.getParameter("teacherId"); //addTeacher.jsp에서 input박스 name="teacherId"의 넘어온 값을 받아 String 타입 변수 teacherId에 담는다
		System.out.println(request.getParameter("teacherid")+"<----AddTeacherController");
		String teacherPw = request.getParameter("teacherPw");//addTeacher.jsp에서 input박스 name="teacherPw"의 넘어온 값을 받아 String 타입 변수 teacherPw에 담는다
		
		Teacher teacher = new Teacher(); //생성자 매서드로  Teacher클래스의 객체를 생성해 미리 선언해둔 변수 teacher에 참조값을 할당한다
		teacher.setTeacherId(teacherId); //teacher에 할당횐 참조값을 찾아가 teacherId을 셋팅한다
		teacher.setTeacherPw(teacherPw);//teacher에 할당횐 참조값을 찾아가 teacherPw을 셋팅한다
		
		
		TeacherDao teacherDao = new TeacherDao(); //생성자 메서드로 TeacherDao클래스의 객체를 생성해 미리 선언해둔 변수 teacherDao에 참조값을 할당한다
		teacherDao.insertTeacher(teacher); //teacherDao에 할당된 참조값을 찾아가 insertTeacher메서드를 실행하고 입력데이터로 teacherId,teacherPw가 셋팅된 teacher의 참조값을 입력한다
		
		
		// 2. 모델(DAO) 호출
		response.sendRedirect(request.getContextPath()+"/getTeacherList.lee"); 
		//가입이후 list창으로 이동하기 위해 주소 getTeacherList.lee로 redirect를 해준다 
		//해당경로는 GetTeacherListController.java로 맴핑이 되어있기 때문에  GetTeacherListController.java로 이동한다
		
		
		// 3. 다른 controller 호출 (redirect)
	}
}
