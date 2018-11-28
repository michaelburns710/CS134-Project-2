import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
	
	private static ArrayList<SalariedEmployee> salArr = new ArrayList<>();
	
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in); // Reading from System.in
		System.out.println("Welcome to the Employee Portal! Please enter your Username below.");
		System.out.println("Username:");
		String userName = reader.nextLine(); // Scans the next token of the input as an int.;
		System.out.println("##################################################################");
		System.out.println("Welcome, " + userName + ".");
		System.out.println("##################################################################");
		mainMenu();
		reader.close();
		
	}

	public static void mainMenu() {
			Scanner reader = new Scanner(System.in);
			System.out.println("Please make a selection from the following options.");
			System.out.println("(1) Hire new employees.");
			int optionSelected = reader.nextInt();
			if (optionSelected == 1) {
				hireOneEmployee();
			} else {
				mainMenu();
			}
			reader.close();
	}

	public static void hireNewEmployee() {

		try {
			Scanner reader = new Scanner(System.in);
			System.out.println("##################################################################");
			System.out.println("How many employees would you like to hire? (Maximum 20)");
			int enteredNumber = reader.nextInt();

			if (enteredNumber <= 20) {
				for (int i = 0; i < enteredNumber; i++) {
					hireOneEmployee();
				}
			} else {
				System.out.println("You have entered an invalid option.");
				hireNewEmployee();
			}
			reader.close();
		}

		catch (Exception e) {
			System.out.println("You have entered an invalid option.");
			hireNewEmployee();
		}

	}

	public static void hireOneEmployee() {
		try {
			Scanner reader2 = new Scanner(System.in);
			System.out.println("What type of employee? (1) Hourly (2) Salary");
			int enteredNumber = reader2.nextInt();
			if (enteredNumber == 1) {
				Scanner readerString = new Scanner(System.in);
				System.out.println("Please enter employee's first name.");
				String firstName = readerString.nextLine();
				System.out.println("Please enter employee's last name.");
				String lastName = readerString.nextLine();
				System.out.println("Please enter employee's Social Security Number. (Format xxx-xx-xxx)");
				String socialSecurityNumber = readerString.nextLine();
				String employeeId = String.format("%05d", salArr.size()+1);
				salArr.add(new SalariedEmployee(firstName, lastName, employeeId, socialSecurityNumber));
				readerString.close();
				
			}
			mainMenu();
			reader2.close();
		}
		catch (Exception e) {
			System.out.println("You have entered an invalid option.");
			hireOneEmployee();
		}
	
	}

}
