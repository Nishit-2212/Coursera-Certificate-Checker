package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import connection.DBconnection;
import model.Course;
import model.Department;
import model.Division;
import model.Faculty;
import model.Query;
import model.Semester;
import model.Student;
import model.Studentcomplete;





public class AdminDao {
	public static void addsemester(Semester s) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="insert into semester(semester,dept_id) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getSemester());
			pst.setInt(2, s.getDept_id());
			
			
			
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addfaculty(Faculty s) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="insert into faculty(name,email,password) values(?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getEmail());
			pst.setString(3, s.getPassword());
			
			
			
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void adddepartment(Department d) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="insert into department(department) values(?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, d.getDepartment());
			
			
			
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void submitquery(String query,int id) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="insert into query(query,stu_id) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, query);
			pst.setInt(2,id);
			
			
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Semester> getAllSemester(){
		List<Semester> list = new ArrayList<Semester>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select * from semester LIMIT 1";
			PreparedStatement pst  = conn.prepareStatement(sql);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Semester u = new Semester();
				u.setId(rs.getInt("id"));
				u.setSemester(rs.getString("semester"));
				u.setDept_id(rs.getInt("dept_id"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Faculty> getAllFaculty(){
		List<Faculty> list = new ArrayList<Faculty>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select * from faculty";
			PreparedStatement pst  = conn.prepareStatement(sql);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Faculty u = new Faculty();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Division> getAllDivision(){
		List<Division> list = new ArrayList<Division>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select * from Division order by sem_id";
			PreparedStatement pst  = conn.prepareStatement(sql);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Division u = new Division();
				u.setId(rs.getInt("id"));
				u.setDivision(rs.getString("division"));
				u.setSem_id(rs.getInt("sem_id"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Studentcomplete> getAllCompleteddata(){
		List<Studentcomplete> list = new ArrayList<Studentcomplete>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select * from student_course order by submit_date desc";
			PreparedStatement pst  = conn.prepareStatement(sql);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Studentcomplete u = new Studentcomplete();
				u.setId(rs.getInt("id"));
				u.setStu_id(rs.getInt("stu_id"));
				u.setCo_id(rs.getInt("co_id"));
				u.setCertificate_path(rs.getString("certificate_path"));
				u.setSubmit_date(rs.getString("submit_date"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Studentcomplete> getAllCompleteddatabyid(int id){
		List<Studentcomplete> list = new ArrayList<Studentcomplete>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select * from student_course where stu_id=? order by submit_date desc";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Studentcomplete u = new Studentcomplete();
				u.setId(rs.getInt("id"));
				u.setStu_id(rs.getInt("stu_id"));
				u.setCo_id(rs.getInt("co_id"));
				u.setCertificate_path(rs.getString("certificate_path"));
				u.setSubmit_date(rs.getString("submit_date"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Studentcomplete> getAllCompleteddatabydsd(int dept_id,int sem_id,int div_id){
		List<Studentcomplete> list = new ArrayList<Studentcomplete>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select * from student_course s,student st where s.stu_id = st.id and st.dept_id=? and st.sem_id=? and st.div_id=? order by s.submit_date desc";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setInt(1, dept_id);
			pst.setInt(2, sem_id);
			pst.setInt(3, div_id);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Studentcomplete u = new Studentcomplete();
				u.setId(rs.getInt("id"));
				u.setStu_id(rs.getInt("stu_id"));
				u.setCo_id(rs.getInt("co_id"));
				u.setCertificate_path(rs.getString("certificate_path"));
				u.setSubmit_date(rs.getString("submit_date"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Student> getAllCompleteddatanamebydsd(int dept_id,int sem_id,int div_id){
		List<Student> list = new ArrayList<Student>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select * from student_course s,student st where s.stu_id = st.id and st.dept_id=? and st.sem_id=? and st.div_id=? order by s.submit_date desc";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setInt(1, dept_id);
			pst.setInt(2, sem_id);
			pst.setInt(3, div_id);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Student u = new Student();
				u.setName(rs.getString("st.name"));
				
				
				
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public static List<Course> getAllCourse(){
		List<Course> list = new ArrayList<Course>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select * from Course";
			PreparedStatement pst  = conn.prepareStatement(sql);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Course u = new Course();
				u.setId(rs.getInt("id"));
				u.setCourse(rs.getString("course"));
				u.setSem_id(rs.getInt("sem_id"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Semester> getAllSemesters(){
		List<Semester> list = new ArrayList<Semester>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select * from semester";
			PreparedStatement pst  = conn.prepareStatement(sql);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Semester u = new Semester();
				u.setId(rs.getInt("id"));
				u.setSemester(rs.getString("semester"));
				u.setDept_id(rs.getInt("dept_id"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void adddivision(Division s) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="insert into division(division,sem_id) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getDivision());
			pst.setInt(2, s.getSem_id());
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	public static void addcourse(Course c) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DBconnection.createConnection();
			String sql="insert into course(course,sem_id) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c.getCourse());
			pst.setInt(2, c.getSem_id());
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	
	public static List<Department> getAllDepartment(){
		List<Department> list = new ArrayList<Department>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select * from department";
			PreparedStatement pst  = conn.prepareStatement(sql);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Department d = new Department();
				d.setId(rs.getInt("id"));
				d.setDepartment(rs.getString("department"));
				
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	

	public static Department getDepartmentById(int id) {
		Department d = null;
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from department where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				d = new Department();
				d.setId(rs.getInt("id"));
				d.setDepartment(rs.getString("department"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static Faculty getFacultyById(int id) {
		Faculty d = null;
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from Faculty where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				d = new Faculty();
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("name"));
				d.setEmail(rs.getString("email"));
				d.setPassword(rs.getString("password"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	
	
	public static Division getDivisionById(int id) {
		Division d = null;
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from division where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				d = new Division();
				d.setId(rs.getInt("id"));
				d.setDivision(rs.getString("division"));
				d.setSem_id(rs.getInt("sem_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static Semester getSemesterById(int id) {
		Semester d = null;
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from semester where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				d = new Semester();
				d.setId(rs.getInt("id"));
				d.setSemester(rs.getString("semester"));
				d.setDept_id(rs.getInt("dept_id"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static Semester getSemesterBydeptId(int id) {
		Semester d = null;
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from semester where dept_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				d = new Semester();
				d.setId(rs.getInt("id"));
				d.setSemester(rs.getString("semester"));
				d.setDept_id(rs.getInt("dept_id"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static Course getCourseById(int id) {
		Course d = null;
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from course where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				d = new Course();
				d.setId(rs.getInt("id"));
				d.setCourse(rs.getString("course"));
				d.setSem_id(rs.getInt("sem_id"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static Department getDepartmentByName(String department) {
		Department d = null;
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from department where department=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, department);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				d = new Department();
				d.setId(rs.getInt("id"));
				d.setDepartment(rs.getString("department"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static Semester getSemesterByName(String semester) {
		Semester s = null;
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from semester where semester=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, semester);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				s = new Semester();
				s.setId(rs.getInt("id"));
				s.setSemester(rs.getString("semester"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	

	
	public static Division getDivisionByName(String division,int semester_id) {
		Division f = null;
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from division where division=? and sem_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, division);
			pst.setInt(2, semester_id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				f = new Division();
				f.setId(rs.getInt("id"));
				f.setDivision(rs.getString("division"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	
	public static List<Student> getStudentBydsd(int division_id,int semester_id,int department_id){
		List<Student> list = new ArrayList<Student>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select * from student where dept_id=? and sem_id=? and div_id=?";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setInt(1, department_id);
			pst.setInt(2, semester_id);
			pst.setInt(3, division_id);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
				s.setEnrollment_no(rs.getString("enrollment_no"));
				
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

	public static void updateDepartment(Department d) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="update department set department=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, d.getDepartment());
			pst.setInt(2, d.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public static void updateDivision(Division d) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="update division set division=?,sem_id=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, d.getDivision());
			pst.setInt(2, d.getSem_id());
			pst.setInt(3, d.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateFaculty(Faculty d) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="update faculty set name=?,email=?,password=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, d.getName());
			pst.setString(2, d.getEmail());
			pst.setString(3, d.getPassword());
			pst.setInt(4, d.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateCourse(Course d) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="update course set course=?,sem_id=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, d.getCourse());
			pst.setInt(2, d.getSem_id());
			pst.setInt(3, d.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateSemester(Semester d) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="update semester set semester=?,dept_id=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, d.getSemester());
			pst.setInt(2, d.getDept_id());
			pst.setInt(3, d.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void updateStudent(Student s) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="update student set name=?,email=?,password=?,enrollment_no=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getEmail());
			pst.setString(3, s.getPassword());
			pst.setString(4, s.getEnrollment_no());
			pst.setInt(5, s.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void deleteDepartment(int id) {
		
		try {
			Connection conn = DBconnection.createConnection();
			String sql="delete from department where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		public static void deleteFaculty(int id) {
				
				try {
					Connection conn = DBconnection.createConnection();
					String sql="delete from faculty where id=?";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setInt(1, id);
					pst.executeUpdate();
					System.out.println("data deleted");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
public static void deleteCompleted(int id) {
		
		try {
			Connection conn = DBconnection.createConnection();
			String sql="delete from student_course where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteDivision(int id) {
			
			try {
				Connection conn = DBconnection.createConnection();
				String sql="delete from division where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				pst.executeUpdate();
				System.out.println("data deleted");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public static void deleteCourse(int id) {
		
		try {
			Connection conn = DBconnection.createConnection();
			String sql="delete from course	 where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteSemester(int id) {
		
		try {
			Connection conn = DBconnection.createConnection();
			String sql="delete from semester where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteStudent(int id) {
		
		
			
			try {
				Connection conn = DBconnection.createConnection();
				String sql="delete from student where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				pst.executeUpdate();
				System.out.println("data deleted");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public static void deleteQuery(int id) {
		
		try {
			Connection conn = DBconnection.createConnection();
			String sql="delete from query where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addstudent(Student s) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="insert into student(name,dept_id,sem_id,div_id,email,password,enrollment_no) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setInt(2, s.getDept_id());
			pst.setInt(3, s.getSem_id());
			pst.setInt(4,s.getDiv_id());
			pst.setString(5, s.getEmail());
			pst.setString(6, s.getPassword());
			pst.setString(7, s.getEnrollment_no());
			
			
			
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Student getStudentById(int id) {
		Student s = null;
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from student where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setSem_id(rs.getInt("sem_id"));
				s.setDept_id(rs.getInt("dept_id"));
				s.setDiv_id(rs.getInt("div_id"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
				s.setEnrollment_no(rs.getString("enrollment_no"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static List<Query> getAllquery() {
		List<Query> list = new ArrayList<Query>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from query";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Query s = new Query();
				s.setId(rs.getInt("id"));
				s.setQuery(rs.getString("query"));
				s.setStu_id(rs.getInt("stu_id"));
				
				
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
}
