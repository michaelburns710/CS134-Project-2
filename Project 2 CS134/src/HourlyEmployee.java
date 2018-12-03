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
		this.setWage(7.50);
		System.out.println("Hourly Employee Created.");
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
