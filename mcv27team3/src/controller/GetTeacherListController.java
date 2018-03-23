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


@WebServlet("/getTeacherList.team3")  
public class GetTeacherListController extends HttpServlet {
	//초기 실행화면인 getTeacherList.jsp로 연결해주는 클래스
	//전체리스트를 출력해주는 model과 연결된다
	//기본적인 입력데이터가 없기 때문에 doget 메서드로 실행된다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		ArrayList<Teacher> arrayTeacher = new ArrayList<Teacher>(); 		
		//기본적으로 list를 출력하기 때문에 ArrayList를 사용하고 Teacher클래스에서 데이터를 get하기 때문에 ArrayList<Teacher>타입의 변수 arrayTeacher에 ArrayList<Teacher>객체를 참조함
		
		int pagePerRow = 10;	//요청페이지에서 받을수도 있지만 지금은 그냥 정해둠
		System.out.println(request.getParameter("currentPage")+"<---currentPage---GetTeacherListController");
		int currentPage = 1;
		System.out.println(currentPage+"<-----currentPage----notif----GetTeacherListController");
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println(currentPage+"<-----currentPage2----if----GetTeacherListController");
		int starRow = (currentPage-1)*pagePerRow;
				
		TeacherDao teacherDao = new TeacherDao(); 
		//메서드를 사용하기 위해 TeacherDao 객체를 생성해 참조 할당
		arrayTeacher = teacherDao.selectTeacher(starRow, pagePerRow);
		//입력데이터 없이 전체테이블 정보를 select하는 query문을 실행하는 메서드 selectTeacher를 실행한다. 
		//메서드 실행시 리턴데이터 타입은 미리 선언해둔 ArrayList<Teacher>와 같으며 미리선언해둔 arrayTeacher변수에 참조한다
				
		int totalRowCount = teacherDao.teacherRowCount();
		int lastPage = totalRowCount/pagePerRow;
		
		if(totalRowCount % pagePerRow != 0) {
			lastPage++;
		}
		System.out.println(lastPage+"<---lastPage---GetTeacherListController");
		request.setAttribute("arrayTeacher", arrayTeacher); 
		//참조된 arrayTeacher를 넘겨주기 위해 "arrayTeacher"라는 이름을 사용하여 setAttribute한다
		//list같은 경우는 특별히 데이터를 계속 남길 필요가 없으니 setAttribute는 request로 하는게 좋아보인다
		
		request.setAttribute("currentPage", currentPage);
		
		request.setAttribute("lastPage", lastPage);
				
		request.getRequestDispatcher("/WEB-INF/views/teacher/getTeacherList.jsp").forward(request, response);
		//setAttribute한 데이터를 넘겨주기 위해 List를 출력하는 jsp의 경로인 "/WEB-INF/views/teacher/getTeacherList.jsp"로 forward한다. 
	}
}
