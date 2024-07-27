package model;

public class Semester {
	private int id,dept_id;
	private String semester;
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
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	@Override
	public String toString() {
		return "Semester [id=" + id + ", dept_id=" + dept_id + ", semester=" + semester + "]";
	}
	
	
	
	
	
	
	
	
	
}
