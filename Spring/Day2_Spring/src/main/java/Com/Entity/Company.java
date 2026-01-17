package Com.Entity;

public class Company {
	
	int CId;
	String CName;
	Employee emp;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(int cId, String cName, Employee emp) {
		super();
		CId = cId;
		CName = cName;
		this.emp = emp;
	}
	public int getCId() {
		return CId;
	}
	public void setCId(int cId) {
		CId = cId;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "Company [CId=" + CId + ", CName=" + CName + ", emp=" + emp + "]";
	}
	
	

}
