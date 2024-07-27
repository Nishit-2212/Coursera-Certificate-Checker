package model;

public class Student {
	private int id,dept_id,sem_id,div_id;
	private String name,email,password,enrollment_no;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public int getSem_id() {
		return sem_id;
	}
	public void setSem_id(int sem_id) {
		this.sem_id = sem_id;
	}
	public int getDiv_id() {
		return div_id;
	}
	public void setDiv_id(int div_id) {
		this.div_id = div_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnrollment_no() {
		return enrollment_no;
	}
	public void setEnrollment_no(String enrollment_no) {
		this.enrollment_no = enrollment_no;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", dept_id=" + dept_id + ", sem_id=" + sem_id + ", div_id=" + div_id + ", name="
				+ name + ", email=" + email + ", password=" + password + ", enrollment_no=" + enrollment_no + "]";
	}
	
	
	
	
}
