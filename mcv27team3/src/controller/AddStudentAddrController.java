package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;
import model.TeacherAddrDao;

@WebServlet("/AddStudentAddrController.lim")
public class AddStudentAddrController extends HttpServlet {
	private StudentAddrDao studentAddrDao;
	private StudentAddr studentAddr;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//가입시 숫자 뿐만아니라 한글,영어도 인코딩 
		request.setCharacterEncoding("euckr");
		
		//list에서 주소 추가를 누르면 Controller로 이동
		int studentNo = Integer.parseInt(request.getParameter("studentNO"));
		System.out.println(request.getParameter("studentNo")+"<-----doGet  AddTeacherAddrController.java");
		
		//콘트롤러에서 number를 넘겨받고 해당 number가 이미 입력되어 수정할수 없는 jsp로 뿌려준다.
		request.setAttribute("studentNo", studentNo);
		//해당 jsp에서 number 고정, address_number는 오토로 입력처리 X 결과적으로 주소값만 일력되는 form 작성
		
		request.getRequestDispatcher("/WEB-INF/views/addStudentAddrForm.jsp").forward(request, response);
		
		//form 작성시 controller로 넘어오고 입력된 데이터를 Dao에 연결시켜 query문장 실행 
		//list.jsp로 연결시켜 마무리
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euckr");
		
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentAddr = request.getParameter("studentAddr");
		System.out.println(studentNo+"<-------doPost AddStudentAddrController");
		System.out.println(studentAddr+"<-------doPost AddStudentAddrController");
		
		studentAddrDao = new StudentAddrDao();
		studentAddrDao.insertStudentAddr(studentNo, studentAddr);
		
		response.sendRedirect(request.getContextPath()+"/GetStudentAddrListController.lim");
	}

}
