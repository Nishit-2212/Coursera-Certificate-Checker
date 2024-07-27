package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBconnection;
import model.Faculty;
import model.Student;

public class LoginDao {
		
	public static Student loginUser(String email)
	{
		Student s = null;
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from student where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);	
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setDept_id(rs.getInt("dept_id"));
				s.setSem_id(rs.getInt("sem_id"));
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
	
	
	public static Faculty loginFaculty(String email)
	{
		Faculty s = null;
		try {
			Connection conn = DBconnection.createConnection();
			String sql="select * from faculty where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);	
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				s = new Faculty();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static Boolean checkemail(String email) {
		Boolean flag = false;
		try {
			
			Connection conn = DBconnection.createConnection();
			String sql="select * from student where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);	
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
	
	public static void changePassword(String email,String password)
	{
		try {
			Connection conn=DBconnection.createConnection();
			String sql="update student set password=? where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, email);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updatename(String name,int id) {
		// TODO Auto-generated method stub
		try {
			Connection conn=DBconnection.createConnection();
			String sql="update student set name=? where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setInt(2, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
