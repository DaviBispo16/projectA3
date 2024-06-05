package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Clt;
import entities.Employee;
import entities.Trainee;
import enums.EmploymentContract;
import services.EmployeeManagement;
import utils.Menu;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Employee> employees = new ArrayList<>();
		EmployeeManagement employeeService = new EmployeeManagement();
		Menu menu = new utils.Menu();
		
		automaticEmployeeRegistration(employees);
			
		menu.printInitialMessage();
		
		int userChoice;
	
		do {	
			menu.printMenu();
			userChoice = sc.nextInt();
		
		switch(userChoice) {
			case 1:
				employeeService.registerEmployee(sc, employees);
				break;
			case 2: 
				employeeService.listEmployees(employees);
				break;	
			case 3: 
				employeeService.orderByNameAscending(employees);
				break;
			case 4:
				employeeService.searchEmployeeByCPF(sc, employees);
				break;
			case 5: 
				employeeService.updateEmployee(sc, employees);
				break;
			case 6:
				employeeService.removeEmployee(sc, employees);
				break;
			case 7:
				employeeService.getResume(sc, employees);
				break;
			case 8:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
				
		} while (userChoice != 9);
		
		
	}
	
		static void automaticEmployeeRegistration(List <Employee> employees) {
			employees.add(new Clt("Felipe", "felipe@gmail.com", "123.123.123-21", EmploymentContract.CLT, 250.00, 250.00, 1678.00));
			employees.add(new Clt("Daniel", "dan@gmail.com", "113.113.123-21", EmploymentContract.ESTAGIO, 500.00, 400.00, 1000.00));
			employees.add(new Trainee("Marco", "marco@gmail.com", "123.133.123-21", EmploymentContract.ESTAGIO, 400.00, 400.00));
			employees.add(new Clt("Silva", "silva@gmail.com", "123.153.123-21", EmploymentContract.CLT, 400.00, 400.00, 1000.00));
			employees.add(new Trainee("Thiago", "thiago@gmail.com", "173.123.123-21", EmploymentContract.ESTAGIO, 400.00, 400.00));
			employees.add(new Clt("Gabriel", "ga@gmail.com", "123.123.143-21", EmploymentContract.CLT, 120.00, 120.00, 1000.00));
			employees.add(new Trainee("Jonathan", "joan@gmail.com", "123.113.123-21", EmploymentContract.CLT, 345.00, 450.00));
		}
	
	
}
