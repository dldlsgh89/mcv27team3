package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/AddTeacherAddrController.lee")
public class AddTeacherAddrController extends HttpServlet {
	private TeacherAddrDao teacherAddrDao;
	private TeacherAddr teacherAddr;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//가입된 number로 주소를 추가했을때 입력 과정
		request.setCharacterEncoding("euckr");
		//리스트에서 주소 추가를 누르면 Controller로 소환
		int teacherNo = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(request.getParameter("sendNO")+"<-----doGet  AddTeacherAddrController");
		
		//콘트롤러에서 number를 넘겨받고 해당 number가 이미 입력되어 수정할수 없는 jsp로 뿌려준다.
		request.setAttribute("teacherNo", teacherNo);
		//해당 jsp에서 number 고정, address_number는 오토로 입력처리 X 결과적으로 주소값만 일력되는 form 작성
		
		request.getRequestDispatcher("/WEB-INF/views/addTeacherAddrForm.jsp").forward(request, response);
		
		//form 작성시 controller로 넘어오고 입력된 데이터를 Dao에 연결시켜 query문장 실행 
		//list.jsp로 연결시켜 마무리
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euckr");
		
		int teacherNo = Integer.parseInt(request.getParameter("teacherNo"));
		String teacherAddr = request.getParameter("teacherAddr");
		System.out.println(teacherNo+"<-------doPost AddTeacherAddrController");
		System.out.println(teacherAddr+"<-------doPost AddTeacherAddrController");
		
		teacherAddrDao = new TeacherAddrDao();
		teacherAddrDao.addTeacherAddress(teacherNo, teacherAddr);
		
		response.sendRedirect(request.getContextPath()+"/getTeacherList.lee");
	}

}
