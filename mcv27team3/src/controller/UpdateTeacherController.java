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


@WebServlet("/UpdateTeacherController.team3")
public class UpdateTeacherController extends HttpServlet {
	private TeacherDao teacherDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getTeacherList.jsp에서 넘어온 sendNO로 하나의 데이터를 찾는 query문을 실행하는 메서드를 호출하는 메서드 이다
		
		int teacherNo = (Integer.parseInt(request.getParameter("sendNO"))); 
		//getTeacherList.jsp에서 넘긴 sendNO를 받아 Integer.parseInt으로 int타입으로 변경시킨후 int타입변수teacherNo에 담는다
		System.out.println(request.getParameter("sendNO")+"<-----doGet-----UpdateTeacherController");
		
		this.teacherDao = new TeacherDao(); //TeacherDao클래스 타입 객체 생성후 teacherDao객체참조변수에 할당
		
		Teacher teacher = new Teacher(); //Teacher클래스 타입의 객체 생성후 teacher객체참조변수에 할당
		teacher	 =	teacherDao.teacherSelectforUpdate(teacherNo); 
		//teacherDao객체참조변수에 접근해 하나의 데이터를 select해주는 메서드 teacherSelectforUpdate를 입력데이터로 teacherNo를 넣어 호출한다 
		//return데이터는 teacher객체참조변수에 담는다
		
		request.setAttribute("teacher", teacher);
		//return데이터가 담긴 객체참조변수 teacher를 setAttribute해준다. 
		//teacher가 담긴 이름은 teacher이고 view에 속하는 updateTeacherForm.jsp에서 단 한번만 사용할 것임으로 request로 setAttribute
		
		request.getRequestDispatcher("/WEB-INF/views/teacher/updateTeacherForm.jsp").forward(request, response);
		//전달해야할 데이터가 있음으로 updateTeacherForm.jsp로 forward 해준다
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//updateTeacherForm.jsp에서 post 방식으로 넘어온 데이터들로 update qurey문을 실행하는 메서드를 호출하는 메서드이다
		request.setCharacterEncoding("UTF-8");
		//화면상 입력데이터가 있기때문에 Encoding필요
		
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo"))); 
		//updateTeacherForm.jsp에서 넘어온 데이터중 teacherNo에 해당하는 데이터를 받아 Integer.parseInt으로 형변화해서 int타입변수 teacherNo에 담음
		System.out.println(teacherNo+"<------doPost----UpdateTeacherController");
		String teacherId = request.getParameter("teacherId");
		//updateTeacherForm.jsp에서 넘어온 데이터중 teacherId에 해당하는 데이터를 String타입변수 teacherId에 담음
		String teacherPw = request.getParameter("teacherPw");
		//updateTeacherForm.jsp에서 넘어온 데이터중 teacherPw에 해당하는 데이터를 String타입변수 teacherPw에 담음
		
		Teacher teacher = new Teacher(); //Teacher클래스타입의 객체참조변수 teacher선언 및 할당
		teacher.setTeacherNo(teacherNo); //객체참조변수teacher에 접근해 teacherNo변수를 setting
		teacher.setTeacherId(teacherId); //객체참조변수teacher에 접근해 teacherNo변수를 setting
		teacher.setTeacherPw(teacherPw); //객체참조변수teacher에 접근해 teacherNo변수를 setting
			
		this.teacherDao.updateTeacher(teacher);
		//미리 선언해둔 teacherDao객체 참조변수에 접근해 update query문장을 실행해주는 메서드 updateTeacher에 setting된 teacher 객체참조변수를 입력데이터로 넣어 호출
		
		response.sendRedirect(request.getContextPath()+"/getTeacherList.team3");
		//결과값을 전달한다던가 하지 않음으로 그냥 GetTeacherListController.java로 redirect
	}
}
