
public class Menu {
	
	public void mainMenu() {
		System.out.println("##################################################################");
		System.out.println("What would you like to do?");
		System.out.println("(1) Hire New Employees");
		System.out.println("(2) Check For Raise");
		System.out.println("(3) Logout");
		
	}
	
	public void employeeOption(String option) {
		System.out.println("##################################################################");
		System.out.println("What type of employee would you like to " + option + "?");
		System.out.println("(1) Salary");
		System.out.println("(2) Hourly");
		System.out.println("(3) Exit");
		
	}
}
