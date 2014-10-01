package my.domain;

/**
 * Domain class. Used as value object to transform data to the client. 
 *
 */
public class Employee {

	private String id;
	private String name;
	private String jobTitle;
	
	public Employee() {}
	
	public Employee(String id, String name, String jobTitle) {
      super();
      this.id = id;
      this.name = name;
      this.jobTitle = jobTitle;
   }
   public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

   @Override
   public String toString() {
      return "Employee [id=" + id + ", name=" + name + ", jobTitle=" + jobTitle
            + "]";
   }
	
}
