package model;

public class Studentcomplete {
	private int id,stu_id,co_id;
	private String certificate_path,submit_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public int getCo_id() {
		return co_id;
	}
	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}
	public String getCertificate_path() {
		return certificate_path;
	}
	public void setCertificate_path(String certificate_path) {
		this.certificate_path = certificate_path;
	}
	public String getSubmit_date() {
		return submit_date;
	}
	public void setSubmit_date(String submit_date) {
		this.submit_date = submit_date;
	}
	@Override
	public String toString() {
		return "Studentcomplete [id=" + id + ", stu_id=" + stu_id + ", co_id=" + co_id + ", certificate_path="
				+ certificate_path + ", submit_date=" + submit_date + "]";
	}
	
	
	
}
