
public class SalariedEmployee extends Employee {

	private Double baseSalary;
	private boolean isGettingOvertime;
	private int payInterval;
	private double contributionTo401K;
	
	//this is a constructor
	//this is a child class, so use super. to reference things in the parent class Employee
	SalariedEmployee(String firstName, String lastName, String employeeId, String socialSecurityNumber) {
		this.setBaseSalary(10000.00);
		super.setDisciplineCount(0);
		super.setTermDate("");
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setEmployeeId(employeeId);
		super.setSocialSecurityNumber(socialSecurityNumber);
		System.out.println("Salaried Employee Created.");
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Employee ID: " + employeeId);
	}
	
	public boolean isRaiseEligible() {
		if (super.isHired() & super.getDisciplineCount() == 0 & super.getProject().length > 1 & super.getCertification().length >= 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public boolean isGettingOvertime() {
		return isGettingOvertime;
	}
	public void setGettingOvertime(boolean isGettingOvertime) {
		this.isGettingOvertime = isGettingOvertime;
	}
	public int getPayInterval() {
		return payInterval;
	}
	public void setPayInterval(int payInterval) {
		this.payInterval = payInterval;
	}
	public double getContributionTo401K() {
		return contributionTo401K;
	}
	public void setContributionTo401K(double contributionTo401K) {
		this.contributionTo401K = contributionTo401K;
	}
	
	
}
