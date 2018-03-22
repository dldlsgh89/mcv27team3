package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherAddrDao;
import model.TeacherDao;


@WebServlet("/DeleteTeacherController.lee")
public class DeleteTeacherController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getTeacherList.jsp에서 넘어온 sendNO로 해당 데이터를 delete해주는 query문을 실행해주는 메서드를 호출하는 메서드

		int	teacherNo = Integer.parseInt(request.getParameter("sendNO")); 
		//getTeacherList.jsp에서 넘어온 sendNO를 Integer.parseInt으로 형변환해준뒤 int타입변수 teacherNo에 담는다
		
		System.out.println(teacherNo+"<--sendNO---DeleteTeacherController");
		
		TeacherAddrDao teacherAddrDao = new TeacherAddrDao(); 
		//TeacherAddrDao클래스 타입 객체참조변수 teacherAddrDao를 선언하고 TeacherAddrDao객체를 할당
		System.out.println(teacherAddrDao.selectTeacherAddr(teacherNo).size()+"<---teacherAddrDao.selectTeacherAddr(sendNO).size---DeleteTeacherController");
		
		if(0<teacherAddrDao.selectTeacherAddr(teacherNo).size()) { 
			//if문을 돌린다 조건은 teacherAddrDao객체에 teacherNo를 입력값으로 받아 해당회원의 전체주소를 select하는 메서는 selectTeacherAddr의 size가 0보다 크다면 true이다
			response.setContentType("text/html;charset=utf-8");
			//servlet에서 브라우저로 보내지는 한글을 처리하기 위한 코드
	   		PrintWriter out=response.getWriter();
	   		//getWriter메서드를 통해 응답하고 리턴 데이터 타입은 PrintWriter이고 변수 out에 담는 코드이다 getWriter메서드는 Writer즉 쓰기에 해당되는 메서드이다
	   		out.println("<script>");
	   		out.println("alert('주소가 남아있으면 삭제할 수 없습니다');");
	   		out.println("location.href='" + request.getContextPath() + "/getTeacherList.lee';");
	   		out.println("</script>");
	   		//PrintWriter타입의 변수 out에 접근해서 각각의 문장을 println한다
	   		//처음부터 끝까지 전부 완료시 적용되는 코드는 
	   		//<script>
	   		//alert('주소가 남아있으면 삭제할 수 없습니다');
	   		//location.href='request.getContextPath()/getTeacherList.lee';
	   		//</script> 
	   		//이다. 해당 코드를 실제 jsp에 실행한다면 <script>페이지 안에 '주소가 남아있으면 삭제할 수 없습니다'라는 alert를 입력하고 
	   		//GetTeacherListController.java클래스로 location.href를 하는 코드와 일치한다
	   		out.close();
	   		//사용하지 않는 out객체를 close함
	   		
		}else {   //만약 teacherAddrDao객체에 teacherNo를 입력값으로 받아 해당회원의 전체주소를 select하는 메서는 selectTeacherAddr의 size가 0보다 크지않다고 한다면
	   		TeacherDao teacherDao = new TeacherDao();
	   		//TeacherDao클래스 타입의 객체참조변수 teacherDao를 선언하고 TeacherDao객체를 할당한다
			teacherDao.deleteTeacher(teacherNo);
			//TeacherDao참조변수에 접근해서 Teacher데이터를 삭제해주는  dalete query문장을 실행해주는 메서드 deleteTeacher를 호출하고 입력데이터로 teacherNo를 넣는다
		}
		
		response.sendRedirect(request.getContextPath()+"/getTeacherList.lee");		
		//넘겨줘야할 데이터같은게 없기때문에 GetTeacherListController.java로 redirect한다
	}
}
