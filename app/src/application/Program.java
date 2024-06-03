package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Clt;
import entities.Employee;
import entities.Estagio;
import enums.EmploymentContract;
import services.EmployeeManagement;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Employee> employees = new ArrayList<>();
		EmployeeManagement employeeService = new EmployeeManagement();
		
		automaticEmployeeRegistration(employees);
			
		System.out.println("----------Gestão Empregados---------");

		int userChoice;
	
		do {
			System.out.println();
			System.out.println("MENU");
			System.out.println("[1] Cadastrar Funcionário");
			System.out.println("[2] Listar todos Funcionários");
			System.out.println("[3] Procurar funcionário");
			System.out.println("[4] Atualizar Funcionário");
			System.out.println("[5] Excluir Funcionário");
			System.out.println("[6] Sair");
			userChoice = sc.nextInt();
		
		switch(userChoice) {
			case 1:
				employeeService.registerEmployee(sc, employees);
				break;
			case 2: 
				employeeService.listEmployees(employees);
				break;	
			case 3: 
				employeeService.searchEmployeeByCPF(sc, employees);
				break;
			case 4:
				employeeService.updateEmployee(sc, employees);
				break;
			case 5: 
				employeeService.removeEmployee(sc, employees);
				break;
			case 6:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
				
		} while (userChoice != 6);
		
		
	}
	
		static void automaticEmployeeRegistration(List <Employee> employees) {
			employees.add(new Clt("Felipe", "felipe@gmail.com", "123.123.123-21", EmploymentContract.CLT, 250.00, 250.00));
			employees.add(new Clt("Daniel", "dan@gmail.com", "113.113.123-21", EmploymentContract.ESTAGIO, 500.00, 400.00));
			employees.add(new Estagio("Marco", "marco@gmail.com", "123.133.123-21", EmploymentContract.ESTAGIO, 400.00, 400.00));
			employees.add(new Clt("Silva", "silva@gmail.com", "123.153.123-21", EmploymentContract.CLT, 400.00, 400.00));
			employees.add(new Estagio("Thiago", "thiago@gmail.com", "173.123.123-21", EmploymentContract.ESTAGIO, 400.00, 400.00));
			employees.add(new Clt("Gabriel", "ga@gmail.com", "123.123.143-21", EmploymentContract.CLT, 120.00, 120.00));
			employees.add(new Estagio("Jonathan", "joan@gmail.com", "123.113.123-21", EmploymentContract.CLT, 345.00, 450.00));
		}
	
	
}
