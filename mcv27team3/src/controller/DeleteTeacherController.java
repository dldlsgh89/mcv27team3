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

		int	sendNO = Integer.parseInt(request.getParameter("sendNO"));
		System.out.println(sendNO+"<--sendNO---DeleteTeacherController");
		
		TeacherAddrDao teacherAddrDao = new TeacherAddrDao();
		System.out.println(teacherAddrDao.selectTeacherAddr(sendNO).size()+"<---teacherAddrDao.selectTeacherAddr(sendNO).size---DeleteTeacherController");
		if(0<teacherAddrDao.selectTeacherAddr(sendNO).size()) {
			response.setContentType("text/html;charset=utf-8");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('주소가 남아있으면 삭제할 수 없습니다');");
	   		out.println("location.href='" + request.getContextPath() + "/getTeacherList.lee';");
	   		out.println("</script>");
	   		out.close();
		}else {   		
	   		TeacherDao teacherDao = new TeacherDao();
			teacherDao.deleteTeacher(sendNO);
		}
		
		response.sendRedirect(request.getContextPath()+"/getTeacherList.lee");		
	}
}
