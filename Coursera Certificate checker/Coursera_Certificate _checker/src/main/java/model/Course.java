package model;

public class Course {
	private int id,sem_id;
	private String course;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSem_id() {
		return sem_id;
	}
	public void setSem_id(int sem_id) {
		this.sem_id = sem_id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", sem_id=" + sem_id + ", course=" + course + "]";
	}
	
	
	
	
	
	
	
	
}
