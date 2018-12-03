import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//The EmployeeManager allows a company to hire employees and store key details about their status as an employee for the company.
//Features to add: 
//Create ability to add projects and certifications. Currently a test of the project and certification classes are run in this sample.
public class EmployeeManager {

	private static String dateToday;
	private static ArrayList<SalariedEmployee> salArr = new ArrayList<>();
	private static ArrayList<HourlyEmployee> hourArr = new ArrayList<>();

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in); // Reading from System.in
		Menu menu = new Menu();
		System.out.println("Welcome to the Employee Portal! Please enter your Username below.");
		System.out.println("Username:");
		String userName = reader.nextLine(); // Scans the next token of the input as an int.;
		System.out.println("##################################################################");
		System.out.println("Welcome, " + userName + ".");
		System.out.println("Please enter today's date. (Format MM/DD/YYYY)");
		dateToday = reader.nextLine();
		//Test of project and certification class.
		Projects [] projects = new Projects[2];
		projects[0] = new Projects();
		projects[1] = new Projects();
		projects[0].setLeaderEmployeeId("00001");
		projects[1].setLeaderEmployeeId("00001");
		Certifications [] certifications = new Certifications[2];
		certifications[0] = new Certifications();
		certifications[1] = new Certifications();
		certifications[0].setName("Amazon Web Certification");
		certifications[0].setCompensationFactor(5.50);
		certifications[1].setName("Microsoft Certification");
		certifications[1].setCompensationFactor(4.50);
		int selection = 0;
		while (selection != 5) {
			menu.mainMenu();
			String selectionString = reader.nextLine();
			if (isInteger(selectionString)) {
				selection = Integer.parseInt(selectionString);
			} else {
				System.out.println("You have entered an invalid option. Please try again.");
			}
			// This menu option will allow a user to hire a select amount of employees and choose to hire hourly or salaried.
			if (selection == 1) {
				System.out.println("How many employees would you like to hire? (Maximum 5)");
				selectionString = reader.nextLine();
				int numberToHire = 0;
				if (isInteger(selectionString)) {
					numberToHire = Integer.parseInt(selectionString);
					if (numberToHire <= 5) {
						int employeeSelection = 0;
						while (employeeSelection != 3) {
							for (int i = 0; i < numberToHire; i++) {
								menu.employeeOption("hire");
								selectionString = reader.nextLine();
								if (isInteger(selectionString)) {
									employeeSelection = Integer.parseInt(selectionString);
								} else {
									System.out.println("You have entered an invalid option. Please try again.");
								}
								if (employeeSelection == 1) {
									System.out.println("You have selected a Salaried Employee.");
									System.out.println("Please enter employee's first name.");
									String firstName = reader.nextLine();
									System.out.println("Please enter employee's last name.");
									String lastName = reader.nextLine();
									String employeeId = String.format("%05d", salArr.size() + hourArr.size() + 1);
									System.out.println(
											"Please enter employee's Social Security Number. (Format xxx-xx-xxxx)");
									String social = reader.nextLine();
									salArr.add(new SalariedEmployee(firstName, lastName, employeeId, social));
									salArr.get(salArr.size() - 1).hireEmployee(dateToday);
									salArr.get(salArr.size() - 1).setProject(projects);
									salArr.get(salArr.size() - 1).setCertification(certifications);
								}
								if (employeeSelection == 2) {
									System.out.println("You have selected an Hourly Employee.");
									System.out.println("Please enter employee's first name.");
									String firstName = reader.nextLine();
									System.out.println("Please enter employee's last name.");
									String lastName = reader.nextLine();
									String employeeId = String.format("%05d", salArr.size() + hourArr.size() + 1);
									System.out.println(
											"Please enter employee's Social Security Number. (Format xxx-xx-xxxx)");
									String social = reader.nextLine();
									hourArr.add(new HourlyEmployee(firstName, lastName, employeeId, social));
									hourArr.get(hourArr.size() - 1).hireEmployee(dateToday);
									hourArr.get(hourArr.size() - 1).setProject(projects);
									hourArr.get(hourArr.size() - 1).setCertification(certifications);
								}
								if (employeeSelection == 3) {
									break;
								}
							}
							break;
						}
					} else {
						System.out.println("You have entered an invalid option. Please try again.");
					}
				} else {
					System.out.println("You have entered an invalid option. Please try again.");
				}
			}
			// This menu option will pull all employees of a selected type and check to see if they meet criteria for a promotion.
			if (selection == 2) {
				int employeeSelection = 0;
				menu.employeeOption("check for raise.");
				selectionString = reader.nextLine();
				if (isInteger(selectionString)) {
					employeeSelection = Integer.parseInt(selectionString);
				} else {
					System.out.println("You have entered an invalid option. Please try again.");
				}
				if (employeeSelection == 1) {
					if (salArr.size() != 0) {
						for (int i = 0; i < salArr.size(); i++) {
							if (salArr.get(i).isRaiseEligible()) {
								System.out.println("Employee: " + salArr.get(i).getEmployeeId() + " has been given a raise.");
								salArr.get(i).setBaseSalary(salArr.get(i).getBaseSalary() * 0.1);
							}
							else {
								System.out.println("Employee: " + salArr.get(i).getEmployeeId() + " is not eligible for a raise.");
							}
						}
					}
					else {
						System.out.println("There are no salaried employee's to check for raise. Please hire some first.");
					}
				}
				if (employeeSelection == 2) {
					if (hourArr.size() != 0) {
						for (int i = 0; i < hourArr.size(); i++) {
							if (hourArr.get(i).isRaiseEligible()){
								System.out.println("Employee: " + hourArr.get(i).getEmployeeId() + " has been given a raise.");
								hourArr.get(i).setWage(hourArr.get(i).getWage() + 2.50);
							}
							else {
								System.out.println("Employee: " + hourArr.get(i).getEmployeeId() + " is not eligible for a raise.");
							}
						}
					}
					else {
						System.out.println("There are no hourly employee's to check for raise. Please hire some first.");
					}
				}
			}
			if (selection == 3) {
				if (salArr.size() != 0 | hourArr.size() != 0) {
					for(int i = 0; i < salArr.size(); i++) {
						if(salArr.get(i).getDisciplineCount() >=3 ) {
							salArr.get(i).terminateEmployee(dateToday);
						}
					}
					for(int i = 0; i < hourArr.size(); i++) {
						if(hourArr.get(i).getDisciplineCount() >=3 ) {
							hourArr.get(i).terminateEmployee(dateToday);
						}
					}
				}
				else {
					System.out.println("There are no employee's to check. Please Hire Some.");
				}

			}
			if (selection == 4) {
				System.out.println("Please Enter an Employee ID");
				String employeeId = reader.nextLine();
				if (isInteger(employeeId)) {
					int employeeIdNumber = Integer.parseInt(employeeId);
					for(int i = 0; i < salArr.size(); i++) {
						if (employeeIdNumber == Integer.parseInt(salArr.get(i).getEmployeeId())) {
							salArr.get(i).printEmployeeDetails();
							break;
						}
					}
					for(int i = 0; i < hourArr.size(); i++) {
						if (employeeIdNumber == Integer.parseInt(hourArr.get(i).getEmployeeId())) {
							hourArr.get(i).printEmployeeDetails();
							break;
						}
					}
				}
				else {
					System.out.println("You have entered an invalid option.");
				}
			}
		}
		System.out.println(userName + " has logged out.");
		reader.close();
	}

	// This method will check whether a system input is an integer to avoid creating an exception from a user error.
	public static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
