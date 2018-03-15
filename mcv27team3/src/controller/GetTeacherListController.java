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


@WebServlet("/getTeacherList.lee") //맴핑된 GetTeacherListController를 주소
public class GetTeacherListController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//AddTeacherController에서 넘어온 request,response를 받는다.
		//insert에서는 return데이터가 없고 그곳에서 매서드가 끝나버리는데 request나 response를 받는 이유가 있나? 
		//그냥 독립적으로 특별한 데이터를 받지 않고 All select 해주는 model에 연결만 하면 안되는지? 
		//만약에 model에 들어가는 request나 response가 있으면 정확히 거기에 들어가있는건 뭐인지?
		
		//TeacherDao 클래스에 전체 리스트를 select해주는 매서드를 생성한다 
	
		request.setCharacterEncoding("euckr");
		
		ArrayList<Teacher> arrayTeacher = new ArrayList<Teacher>(); //생성자 매서드로 Teacher타입의 ArrayList 객체를 생성해 참조값을 arrayTeacher변수에 할당한다 
		
		TeacherDao teacherDao = new TeacherDao(); //생성자 메서드로 TeacherDao클래스의 객체를 생성해 미리 선언해둔 변수 teacherDao에 할당한다
		arrayTeacher = teacherDao.selectTeacher(); //teacherDao의 참조값에 찾아가 selectTeacher메서드를 실행한다
													//selectTeacher메서드에서 리턴된 데이터를 미리 선언해둔 참조변수 arrayTeacher에 할당한다
					
		request.setAttribute("arrayTeacher", arrayTeacher); //request에 결과를 담기위해 setAttribute메서드를 호출해주고 이름은 "arrayTeacher"인것에  참조변수 arrayTeacher를 담는다?
		
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request, response);
		//
	}

}
