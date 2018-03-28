//27기 3팀 임가현
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;
import model.Teacher;
import model.TeacherDao;

@WebServlet("/getStudentList.team3")
public class GetStudentListController extends HttpServlet {
private StudentDao studentDao;
	
	//초기 실행화면인 getTeacherList.jsp로 연결해주는 클래스
	//전체리스트를 출력해주는 model과 연결된다
	//기본적인 입력데이터가 없기 때문에 doget 메서드로 실행된다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		ArrayList<Student> arrayStudent = new ArrayList<Student>(); 		
		//기본적으로 list를 출력하기 때문에 ArrayList를 사용하고 Teacher클래스에서 데이터를 get하기 때문에 ArrayList<Teacher>타입의 변수 arrayTeacher에 ArrayList<Teacher>객체를 참조함
		this.studentDao = new StudentDao();
		int pagePerRow = 5;	//한페이지에 받을 최대 게시물 수. 그러니까 한페이지에서 보이는 마지막 게시글의 숫. 요청페이지에서 따로 정해 받을수도 있지만 지금은 그냥 정해둠
		int pageView = 5; //페이지 아래에서 보여지고 선택할수 있는 최대 페이지 숫자
		
		int currentPage = 1; //기본적인 페이지 번호. 즉 첫페이지는 1번으로 강제
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int starRow = (currentPage-1)*pagePerRow;  //selectTeacher메서드를 실행할때 어디부터 시작할지(어떤 게시글이 화면에 첫 게시글로 나올지) 정하는 변수
		arrayStudent = studentDao.selectStudent(starRow, pagePerRow); //입력받은 starRow번째부터 pagePerRow번 select 해주는 query문을 실행하는 메서드
		
		int totalRowCount = studentDao.studentRowCount();  //총게시물수을 구하는 count query을 실행하고 리턴값을 받는 메서드. 
		int totalPage = totalRowCount/pagePerRow; //총게시물수/한페이지에서 볼수 있는 게시글수 = 총페이지
		
		if(totalRowCount % pagePerRow != 0) {		//총게시글수가 총페이지에서 볼수 있는 게시글수보다 더 많을수도 있기 때문에 많드는 if문 
			totalPage++;							//총게시글수가 한페이지에서 볼수 잇는 게시글로 나누어 0으로 떨어지지 않으면 총페이지를 하나 더 만들어 남는 나머지 게시글을 추가로 보여준다
		}
		
		if(totalPage<currentPage) {		//혹시 모를 잘못된 page 정보가 입력됐을경우 자동으로 최대page로 변환해주는 if문?
			currentPage=totalPage;
		}
		System.out.println(totalPage+"<------totalPage---GetStudentListController");
								
		int startPage = ((currentPage - 1) / 5) * 5 + 1;  //page목록이 나올때 첫번째 page 숫자
		int endPage = startPage + pageView - 1; //page목록이 나올때 마지막 page숫자
		
		if(endPage>totalPage) {		//마지막 page목록의 숫자가 총page보다 클때 page목록숫자를 총페이지로 바꾸는 if문
			endPage=totalPage;
		}
			
		System.out.println(startPage+"<----startPage<------GetStudentListController");
		for (int iCount = startPage; iCount <= endPage; iCount++) {
		    System.out.print(" " + iCount + " ");
		}		
			
		request.setAttribute("arrayStudent", arrayStudent); 
		//참조된 arrayTeacher를 넘겨주기 위해 "arrayTeacher"라는 이름을 사용하여 setAttribute한다
		//list같은 경우는 특별히 데이터를 계속 남길 필요가 없으니 setAttribute는 request로 하는게 좋아보인다		
		request.setAttribute("currentPage", currentPage);
		
		request.setAttribute("totalPage", totalPage);
		
		request.setAttribute("startPage", startPage);
		
		request.setAttribute("endPage", endPage);
				
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentList.jsp").forward(request, response);
		//setAttribute한 데이터를 넘겨주기 위해 List를 출력하는 jsp의 경로인 "/WEB-INF/views/teacher/getTeacherList.jsp"로 forward한다. 
	}
}
