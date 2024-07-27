package model;

public class Division {
	private int id,sem_id;
	private String division;
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
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public String toString() {
		return "Division [id=" + id + ", sem_id=" + sem_id + ", division=" + division + "]";
	}
	
	
	
	
	
	
}
