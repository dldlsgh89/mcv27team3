package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Teacher;
import Model.TeacherDao;


@WebServlet("/addTeacher.lee")
public class AddTeacherController extends HttpServlet {
	private TeacherDao teacherDao;
	private Teacher teacher;
	//teacher �Է� ����û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addTeacher.jsp").forward(request, response);
	}
	//teacher �Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.request ó��
		System.out.println(request.getParameter("teacherid")+"<----AddTeacherController");
		//Teacher setter ȣ��
		this.teacherDao = new TeacherDao();
		teacherDao.insertTeacher(request, response);
		
		// 2. ��(DAO) ȣ��
		response.sendRedirect("/getTeacherList");
		// 3. �ٸ� controller ȣ�� (redirect)
	}
}
