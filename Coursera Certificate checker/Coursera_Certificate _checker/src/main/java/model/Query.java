package model;

public class Query {
		int id,stu_id;
		String query;
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
		public String getQuery() {
			return query;
		}
		public void setQuery(String query) {
			this.query = query;
		}
		@Override
		public String toString() {
			return "Query [id=" + id + ", stu_id=" + stu_id + ", query=" + query + "]";
		}
		
		
}
