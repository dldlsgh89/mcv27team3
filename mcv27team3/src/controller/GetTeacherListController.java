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
		
		int pagePerRow = 10;	//한페이지에 받을 최대 게시물 수. 요청페이지에서 따로 정해 받을수도 있지만 지금은 그냥 정해둠
		int pageView = 5; //페이지 아래에서 보여지고 선택할수 있는 최대 페이지 숫자
		
		int currentPage = 1; //현재페이지 번호
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int starRow = (currentPage-1)*pagePerRow;  //selectTeacher메서드를 실행할때 어디부터 시작할지(어떤 데이터부터 뿌려줄지) 시작하는 변수
		
		int startPage = ((currentPage - 1) / 5) * 5 + 1;  //page목록이 나올때 첫번째 page 숫자
		int endPage = startPage + pageView - 1; //page목록이 나올때 마지막 page숫자
				
				
		TeacherDao teacherDao = new TeacherDao(); 
		//메서드를 사용하기 위해 TeacherDao 객체를 생성해 참조 할당
		arrayTeacher = teacherDao.selectTeacher(starRow, pagePerRow);
		
				
		int totalRowCount = teacherDao.teacherRowCount();  //총게시물수
		int totalPage = totalRowCount/pagePerRow; //총 페이지 수
		
		if(totalRowCount % pagePerRow != 0) {
			totalPage++;
		}
		
		if(totalPage<currentPage) {
			currentPage=totalPage;
		}
		
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		System.out.println(startPage+"<----startPage<------GetTeacherListController");
		for (int iCount = startPage; iCount <= endPage; iCount++) {

		    System.out.print(" " + iCount + " ");

		}
		
			
		//System.out.println(totalPage+"<---lastPage---GetTeacherListController");
		request.setAttribute("arrayTeacher", arrayTeacher); 
		//참조된 arrayTeacher를 넘겨주기 위해 "arrayTeacher"라는 이름을 사용하여 setAttribute한다
		//list같은 경우는 특별히 데이터를 계속 남길 필요가 없으니 setAttribute는 request로 하는게 좋아보인다		
		request.setAttribute("currentPage", currentPage);
		
		request.setAttribute("totalPage", totalPage);
		
		request.setAttribute("startPage", startPage);
		
		request.setAttribute("endPage", endPage);
				
		request.getRequestDispatcher("/WEB-INF/views/teacher/getTeacherList.jsp").forward(request, response);
		//setAttribute한 데이터를 넘겨주기 위해 List를 출력하는 jsp의 경로인 "/WEB-INF/views/teacher/getTeacherList.jsp"로 forward한다. 
	}
}
