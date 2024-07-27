package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBconnection;
import model.Course;
import model.Semester;

public class UploadDao {
	public static Boolean checkname(String name) {
		Boolean flag = false;
		try {
			
			Connection conn = DBconnection.createConnection();
			String sql="select * from student where name=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);	
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	
	public static Boolean checknamedsd(String name,int department,int semester,int division) {
		Boolean flag = false;
		try {
			
			Connection conn = DBconnection.createConnection();
			String sql="select * from student where name=? and dept_id=? and sem_id=? and div_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);	
			pst.setInt(2, department);	
			pst.setInt(3, semester);	
			pst.setInt(4, division);	
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	
	public static Boolean checkc(int student_id,int course_id) {
		Boolean flag1 = false;
		try {
			
			Connection conn = DBconnection.createConnection();
			String sql="select * from student_course where stu_id=? and co_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, student_id);	
			pst.setInt(2, course_id);		
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag1=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag1;
	}
	
	public static List<Course> getCourse(int sem) {
		List<Course> list = new ArrayList<Course>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select course from course where sem_id=?";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setInt(1, sem);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Course c = new Course();
				c.setCourse(rs.getString("course"));
				
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Course> getAllCourse() {
		List<Course> list = new ArrayList<Course>();
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select * from course ";
			PreparedStatement pst  = conn.prepareStatement(sql);
			
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				Course c = new Course();
				c.setCourse(rs.getString("course"));
				
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int get_Courseid(String course) {
		int courseId = -1;
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select id from course where course=?";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setString(1, course);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				 courseId = rs.getInt("id");
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseId;
	}
	
	public static String get_Departmentname(int department) {
		String department_name = "";
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select department from department where id=?";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setInt(1, department);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				 department_name = rs.getString("department");
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return department_name;
	}
	
	public static String get_Semestername(int semester) {
		String semester_name = "";
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select semester from semester where id=?";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setInt(1, semester);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				semester_name = rs.getString("semester");
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return semester_name;
	}
	
	public static String get_divisionname(int division) {
		String division_name = "";
		try {
			Connection conn = DBconnection.createConnection();
			String sql = "select division from division where id=?";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setInt(1, division);
			ResultSet rs =  pst.executeQuery();
			while(rs.next()) {
				division_name = rs.getString("division");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return division_name;
	}
	
	
	public static List<Semester> getAllSemester(){
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
				
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void insertstatus(int id,int co_id,String path) {
		try {
			Connection conn = DBconnection.createConnection();
			String sql="insert into student_course(stu_id,co_id,certificate_path) values(?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, co_id);
			pst.setString(3, path);
			
			
			
			pst.executeUpdate();
			System.out.println("data inserted in student_course success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
