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
				menu.printMenuFinal();
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
				
		} while (userChoice != 8);
		
		
	}
		// Metódo para criação automática de 7 objetos da classe Funcionário
		static void automaticEmployeeRegistration(List <Employee> employees) {
			employees.add(new Clt("Augusto", "augusto@gmail.com", "123.123.123-21", EmploymentContract.CLT, 250.00, 250.00, 1400.00));
			employees.add(new Clt("Joana", "joana2@gmail.com", "113.113.123-71", EmploymentContract.CLT, 280.00, 200.00, 1500.00));
			employees.add(new Trainee("Guilherme", "guilherme@gmail.com", "723.173.183-45", EmploymentContract.ESTAGIO, 200.00, 600.00));
			employees.add(new Clt("Davi", "davi233@gmail.com", "118.173.128-21", EmploymentContract.CLT, 280.00, 300.00, 2500.00));
			employees.add(new Trainee("João", "joaosantana123@hotmail.com", "123.173.124-97", EmploymentContract.ESTAGIO, 100.00, 500.00));
			employees.add(new Clt("Gabriel", "gabriel3@gmail.com", "623.183.243-43", EmploymentContract.CLT, 120.00, 120.00, 1412.00));
			employees.add(new Trainee("Felipe", "felipe@hotmail.com", "183.113.123-35", EmploymentContract.ESTAGIO, 345.00, 900.00));
		}
	
	
}
