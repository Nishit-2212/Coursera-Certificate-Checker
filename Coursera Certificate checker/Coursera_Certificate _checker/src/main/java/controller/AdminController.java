package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;

import model.Course;
import model.Department;
import model.Division;
import model.Faculty;
import model.Semester;
import model.Student;



/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("Add semester")) {
			
			
			Semester s =new Semester();
			s.setSemester(request.getParameter("semester"));
			s.setDept_id(Integer.parseInt(request.getParameter("dropdown")));
		
			System.out.println(s);
			
			
			
			
			AdminDao.addsemester(s);
			
			request.setAttribute("msg", "data registered successfully");
			request.getRequestDispatcher("semestercrud.jsp").forward(request, response);
			
		}
        if(action.equalsIgnoreCase("Add faculty")) {
			
			
			Faculty s =new Faculty();
			s.setName(request.getParameter("name"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			
		
			System.out.println(s);
			
			
			
			
			AdminDao.addfaculty(s);
			
			request.setAttribute("msg", "data registered successfully");
			request.getRequestDispatcher("facultycrud.jsp").forward(request, response);
			
		}
		if(action.equalsIgnoreCase("Add division")) {
			
			
			Division s =new Division();
			s.setDivision(request.getParameter("division"));
			s.setSem_id(Integer.parseInt(request.getParameter("dropdown")));
			System.out.println(s);
			
			
			
			
			AdminDao.adddivision(s);
			
			request.setAttribute("msg", "data registered successfully");
			request.getRequestDispatcher("divisioncrud.jsp").forward(request, response);
			
		}
		
		if(action.equalsIgnoreCase("Add course")) {
			
			Course c = new Course();
			
			c.setCourse(request.getParameter("course"));
			c.setSem_id(Integer.parseInt(request.getParameter("dropdown")));
			System.out.println(c);
			
			AdminDao.addcourse(c);
			
			request.setAttribute("msg", "course registered successfully");
			request.getRequestDispatcher("coursecrud.jsp").forward(request, response);
			
		}
		
		if(action.equalsIgnoreCase("Add Department")) {
			
			Department d = new Department();
			
			d.setDepartment(request.getParameter("department"));
			System.out.println(d);
			AdminDao.adddepartment(d);
			
			request.setAttribute("msg", "department added successfully");
			request.getRequestDispatcher("departmentcrud.jsp").forward(request, response);
		}
		
		if(action.equalsIgnoreCase("department_edit")) {
			System.out.println("click the edit button");
			int id = Integer.parseInt(request.getParameter("id"));
			Department d = AdminDao.getDepartmentById(id);
			System.err.println(d);
			request.setAttribute("department", d);
			request.getRequestDispatcher("departmentedit.jsp").forward(request, response);
		}
		if(action.equalsIgnoreCase("faculty_edit")) {
			System.out.println("click the edit button");
			int id = Integer.parseInt(request.getParameter("id"));
			Faculty d = AdminDao.getFacultyById(id);
			System.err.println(d);
			request.setAttribute("faculty", d);
			request.getRequestDispatcher("facultyedit.jsp").forward(request, response);
		}
		if(action.equalsIgnoreCase("course_edit")) {
			System.out.println("click the edit button");
			int id = Integer.parseInt(request.getParameter("id"));
			Course d = AdminDao.getCourseById(id);
			System.err.println(d);
			request.setAttribute("course", d);
			request.getRequestDispatcher("courseedit.jsp").forward(request, response);
		}
		
		if(action.equalsIgnoreCase("semester_edit")) {
			System.out.println("click the edit button");
			int id = Integer.parseInt(request.getParameter("id"));
			Semester d = AdminDao.getSemesterById(id);
			System.err.println(d);
			request.setAttribute("semester", d);
			request.getRequestDispatcher("semesteredit.jsp").forward(request, response);
		}
		if(action.equalsIgnoreCase("division_edit")) {
			System.out.println("click the edit button");
			int id = Integer.parseInt(request.getParameter("id"));
			Division d = AdminDao.getDivisionById(id);
			System.err.println(d);
			request.setAttribute("division", d);
			request.getRequestDispatcher("divisionedit.jsp").forward(request, response);
		}
		
		if(action.equalsIgnoreCase("student_edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Student s = AdminDao.getStudentById(id);
			request.setAttribute("student", s);
			request.getRequestDispatcher("studentedit.jsp").forward(request, response);
		}
		if(action.equalsIgnoreCase("Update Department")) {
			Department d = new Department();
			d.setId(Integer.parseInt(request.getParameter("id")));
			d.setDepartment(request.getParameter("department"));
			
			AdminDao.updateDepartment(d);
			response.sendRedirect("departmentcrud.jsp");
		}
		if(action.equalsIgnoreCase("Update Faculty")) {
			Faculty d = new Faculty();
			d.setId(Integer.parseInt(request.getParameter("id")));
			d.setName(request.getParameter("name"));
			d.setEmail(request.getParameter("email"));
			d.setPassword(request.getParameter("password"));
			
			AdminDao.updateFaculty(d);
			response.sendRedirect("facultycrud.jsp");
		}
		if(action.equalsIgnoreCase("Update Division")) {
			String seme_name = request.getParameter("dropdown");
			Semester s = AdminDao.getSemesterByName(seme_name);
			int semester_id = s.getId();
			Division d = new Division();
			d.setId(Integer.parseInt(request.getParameter("id")));
			d.setDivision(request.getParameter("division"));
			d.setSem_id(semester_id);
			AdminDao.updateDivision(d);
			response.sendRedirect("divisioncrud.jsp");
		}
		if(action.equalsIgnoreCase("Update Course")) {
			String seme_name = request.getParameter("dropdown");
			Semester s = AdminDao.getSemesterByName(seme_name);
			int semester_id = s.getId();
			Course d = new Course();
			d.setId(Integer.parseInt(request.getParameter("id")));
			d.setCourse(request.getParameter("course"));
			d.setSem_id(semester_id);
			AdminDao.updateCourse(d);
			response.sendRedirect("coursecrud.jsp");
		}
		
		if(action.equalsIgnoreCase("Update Semester")) {
			Semester d = new Semester();
			d.setId(Integer.parseInt(request.getParameter("id")));
			d.setSemester(request.getParameter("semester"));
			d.setDept_id(Integer.parseInt(request.getParameter("dropdown")));
			AdminDao.updateSemester(d);
			response.sendRedirect("semestercrud.jsp");
		}
		if(action.equalsIgnoreCase("Update Student")) {
			Student s = new Student();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			s.setEnrollment_no(request.getParameter("enrollment_no"));
			
			AdminDao.updateStudent(s);
			response.sendRedirect("studentcrud.jsp");
		}
		if(action.equalsIgnoreCase("department_delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			AdminDao.deleteDepartment(id);
			response.sendRedirect("departmentcrud.jsp");
		}
		if(action.equalsIgnoreCase("semester_delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			AdminDao.deleteSemester(id);
			response.sendRedirect("semestercrud.jsp");
		}
		if(action.equalsIgnoreCase("student_delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			AdminDao.deleteStudent(id);
			response.sendRedirect("studentcrud.jsp");
		}
		if(action.equalsIgnoreCase("faculty_delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			AdminDao.deleteFaculty(id);
			response.sendRedirect("facultycrud.jsp");
		}
		if(action.equalsIgnoreCase("division_delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			AdminDao.deleteDivision(id);
			response.sendRedirect("divisioncrud.jsp");
		}
		if(action.equalsIgnoreCase("completed_delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			AdminDao.deleteCompleted(id);
			response.sendRedirect("completeddata.jsp");
		}
		if(action.equalsIgnoreCase("completed_deletee")) {
			int id = Integer.parseInt(request.getParameter("id"));
			AdminDao.deleteCompleted(id);
			response.sendRedirect("completedataview.jsp");
		}
		if(action.equalsIgnoreCase("course_delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			AdminDao.deleteCourse(id);
			response.sendRedirect("coursecrud.jsp");
		}
		if(action.equalsIgnoreCase("query_delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			AdminDao.deleteQuery(id);
			response.sendRedirect("viewquery.jsp");
		}
		
		if(action.equalsIgnoreCase("See Student")) {
			String Department = request.getParameter("dropdown");
			String Semester = request.getParameter("dropdown1");
			String Division = request.getParameter("division");
			
			System.out.println(Department);
			System.out.println(Semester);
			System.out.println(Division);
			
			Department d = AdminDao.getDepartmentByName(Department);
			Semester s = AdminDao.getSemesterByName(Semester);
			
			
			int department_id = d.getId();
			int semester_id = s.getId();
			
			Division f = AdminDao.getDivisionByName(Division, semester_id);
			
			int division_id = f.getId();
			
			System.out.println("Department_id :"+ department_id);
			System.out.println("Semester_id :"+ semester_id);
			System.out.println("division_id :"+ division_id);
			
			
			
			
			request.setAttribute("department_id", department_id);
			request.setAttribute("semester_id", semester_id);
			request.setAttribute("division_id", division_id);
			request.getRequestDispatcher("studentview.jsp").forward(request, response);
			
		}	
		if(action.equalsIgnoreCase("See Students")) {
			int Department_id = Integer.parseInt(request.getParameter("dropdown"));
			int Semester_id = Integer.parseInt(request.getParameter("dropdown1"));
			String Division = request.getParameter("division");
			
			System.out.println(Department_id);
			System.out.println(Semester_id);
			System.out.println(Division);
			
			Division d = AdminDao.getDivisionByName(Division,Semester_id);
			
			int divisionid = d.getId();
			System.out.println(divisionid);
			
			
			
		
			
		
			
			
			
			request.setAttribute("department_id", Department_id);
			request.setAttribute("semester_id", Semester_id);
			request.setAttribute("division_id", divisionid);
			request.getRequestDispatcher("completedataview.jsp").forward(request, response);
			
		}	
	}

}
