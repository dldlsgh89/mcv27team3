package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getStudentListController
 */
@WebServlet("/getstudentListcontroller.lim")
public class GetStudentListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request...
		//studentDAO
		//request에 속성추가
		//forward
		request.getRequestDispatcher("/WEB-INF/views/getStudentList.jsp").forward(request, response);
	}
}
