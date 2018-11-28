import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		menu.mainMenu();
		int selection = 0;
		while (selection != 3) {
			String selectionString = reader.nextLine();
			if (isInteger(selectionString)) {
				selection = Integer.parseInt(selectionString);
			} else {
				System.out.println("You have entered an invalid option. Please try again.");
			}
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
								if(employeeSelection == 1) {
									System.out.println("You have selected a Salaried Employee.");
									System.out.println("Please enter employee's first name.");
									String firstName = reader.nextLine(); 
									System.out.println("Please enter employee's last name.");
									String lastName = reader.nextLine();
									String employeeId = String.format("%05d", salArr.size() + hourArr.size() + 1);
									System.out.println("Please enter employee's Social Security Number. (Format xxx-xx-xxxx)");
									String social = reader.nextLine();
									salArr.add(new SalariedEmployee(firstName, lastName, employeeId, social));
									salArr.get(salArr.size()-1).hire(dateToday);
								}
								if(employeeSelection == 2) {
									System.out.println("You have selected an Hourly Employee.");
									System.out.println("Please enter employee's first name.");
									String firstName = reader.nextLine(); 
									System.out.println("Please enter employee's last name.");
									String lastName = reader.nextLine();
									String employeeId = String.format("%05d", salArr.size() + hourArr.size() + 1);
									System.out.println("Please enter employee's Social Security Number. (Format xxx-xx-xxxx)");
									String social = reader.nextLine();
									hourArr.add(new HourlyEmployee(firstName, lastName, employeeId, social));
									hourArr.get(hourArr.size()-1).hire(dateToday);
								}
								if(employeeSelection == 3) {
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
			if (selection == 2) {
				int employeeSelection = 0;
				menu.employeeOption("check for raise.");
				selectionString = reader.nextLine();
				if (isInteger(selectionString)) {
					employeeSelection = Integer.parseInt(selectionString);
				} else {
					System.out.println("You have entered an invalid option. Please try again.");
				}
				if(employeeSelection == 1) {
					for(int i = 0; i < salArr.size(); i++) {
						
					}
				}
			}
			menu.mainMenu();
		}
		System.out.println(userName + " has logged out.");
		reader.close();
	}

	public static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
