
public class Employee {
	
	private String firstName;
	private String lastName;
	private String employeeId;
	private String socialSecurityNumber;
	//ok to use a String type for hireDate
	private String hireDate;
	private String termDate;
	private Double vacationBalance;
	private Double sickBalance;
	private Double vacationTaken;
	private Double sickTaken;
	private String employeeStatus;
	private String managerName;
	private int disciplineCount;
	
	//I have referenced a class I created in a class I created MUAHH!!!
	private Projects [] project;
	
	public Projects[] getProject() {
		return project;
	}
	
	private Certifications [] certification;
	
	public Certifications [] getCertifications() {
		return certification;
	}

	public void setProject(Projects[] project) {
		this.project = project;
	}

	public void terminateEmployee(String termDate)
	{
		this.termDate = termDate;
		this.employeeStatus = "Terminated";
		this.vacationBalance = 0.0;
		this.sickBalance = 0.0;
		this.vacationTaken = 0.0;
		this.sickTaken = 0.0;
		this.managerName = "";
	}
	
	public void subtractVacation(Double amountTaken)
	{
		this.vacationBalance -= amountTaken;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getTermDate() {
		return termDate;
	}
	public void setTermDate(String termDate) {
		this.termDate = termDate;
	}
	public Double getVacationBalance() {
		return vacationBalance;
	}
	public void setVacationBalance(Double vacationBalance) {
		this.vacationBalance = vacationBalance;
	}
	public Double getSickBalance() {
		return sickBalance;
	}
	public void setSickBalance(Double sickBalance) {
		this.sickBalance = sickBalance;
	}
	public Double getVacationTaken() {
		return vacationTaken;
	}
	public void setVacationTaken(Double vacationTaken) {
		this.vacationTaken = vacationTaken;
	}
	public Double getSickTaken() {
		return sickTaken;
	}
	public void setSickTaken(Double sickTaken) {
		this.sickTaken = sickTaken;
	}
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getDisciplineCount() {
		return disciplineCount;
	}
	public void setDisciplineCount(int disciplineCount) {
		this.disciplineCount = disciplineCount;
	}
	
	public void hire(String hireDate) {
		this.setHireDate(hireDate);
		System.out.println(this.getFirstName() + " " + this.getLastName() + " has been hired as of " + hireDate);
	}
	
	
	

}