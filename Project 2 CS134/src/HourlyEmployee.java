public class HourlyEmployee extends Employee {
	
	private Double wage;
	private boolean isOvertimeEligible;
	private boolean hasWorkedOvetime;
	private Double overtimeRate;
	
	HourlyEmployee(String firstName, String lastName, String employeeId, String socialSecurityNumber) {
		super.setDisciplineCount(0);
		super.setTermDate("");
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setEmployeeId(employeeId);
		super.setSocialSecurityNumber(socialSecurityNumber);
		System.out.println("Hourly Employee Created.");
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Employee ID: " + employeeId);
	}

	public Double getWage() {
		return wage;
	}

	public void setWage(Double wage) {
		this.wage = wage;
	}

	public boolean isOvertimeEligible() {
		return isOvertimeEligible;
	}

	public void setOvertimeEligible(boolean isOvertimeEligible) {
		this.isOvertimeEligible = isOvertimeEligible;
	}

	public boolean isHasWorkedOvetime() {
		return hasWorkedOvetime;
	}

	public void setHasWorkedOvetime(boolean hasWorkedOvetime) {
		this.hasWorkedOvetime = hasWorkedOvetime;
	}

	public Double getOvertimeRate() {
		return overtimeRate;
	}

	public void setOvertimeRate(Double overtimeRate) {
		this.overtimeRate = overtimeRate;
	}
	
	
}
