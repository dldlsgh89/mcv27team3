package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;
import model.StudentAddrDao;



@WebServlet("/DeleteStudentController.team3")
public class DeleteStudentController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int	studentNo = Integer.parseInt(request.getParameter("sendNO")); 
		System.out.println(studentNo+"<--sendNO---DeleteStudentController");
		
		StudentAddrDao studentAddrDao = new StudentAddrDao(); 
		System.out.println(studentAddrDao.selectStudentAddr(studentNo).size()+"<---studentAddrDao.selectStudentAddr(sendNO).size---DeleteStudentController");
		
		if(0<studentAddrDao.selectStudentAddr(studentNo).size()) { 
			
			response.setContentType("text/html;charset=utf-8");
			
	   		PrintWriter out=response.getWriter();
	   		
	   		out.println("<script>");
	   		out.println("alert('주소가 남아있으면 삭제할 수 없습니다');");
	   		out.println("location.href='" + request.getContextPath() + "/getStudentList.team3';");
	   		out.println("</script>");
	   		
	   		out.close();
	   		
	   		
		}else {   
			StudentDao studentDao = new StudentDao();
	   	
			studentDao.deleteStudent(studentNo);
			
		}
		
		response.sendRedirect(request.getContextPath()+"/getStudentList.team3");		
		
	}
}
