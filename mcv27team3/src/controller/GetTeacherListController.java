package controller;

import java.io.IOException;
import java.util.ArrayList;

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
		//AddTeacherController에서 넘어온 request,response를 받는다.
		//insert에서는 return데이터가 없고 그곳에서 매서드가 끝나버리는데 request나 response를 받는 이유가 있나? 
		//그냥 독립적으로 특별한 데이터를 받지 않고 All select 해주는 model에 연결만 하면 안되는지? 
		//만약에 model에 들어가는 request나 response가 있으면 정확히 거기에 들어가있는건 뭐인지?
		
		//TeacherDao 클래스에 전체 리스트를 select해주는 매서드를 생성한다 
	
		request.setCharacterEncoding("euckr");
		//request
		this.teacher = new Teacher();
		//TeacherDao
		ArrayList<Teacher> arrayTeacher = new ArrayList<Teacher>();
		
		this.teacherDao = new TeacherDao();
		arrayTeacher = teacherDao.searchTeacherList();
		//request에 속성 추가
		request.setAttribute("arrayTeacher", arrayTeacher);
		
		//forward
		
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request, response);
	}

}
