package application;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import enums.EmploymentContract;
import exceptions.CpfInvalidFormat;
import exceptions.IncorrectEmploymentContract;
import services.FieldValidations;
import services.EmployeeService;

public class Program {
	//Program Principal
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//Instaciação da arrayList employees;
		List <Employee> employees = new ArrayList<>();
		EmployeeService employeeService = new EmployeeService();
		
		automaticEmployeeRegistration(employees);
			
		System.out.println("----------Gestão Empregados---------");

		int userChoice;
	
		do {
			System.out.println();
			System.out.println("MENU");
			System.out.println("[1] Cadastrar Funcionário");
			System.out.println("[2] Listar todos Funcionários");
			System.out.println("[3] Procurar funcionário por CPF");
			System.out.println("[4] Excluir Funcionário");
			System.out.println("[5] Sair");
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
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
				
		} while (userChoice != 4);
		
		
	}
	
		static void automaticEmployeeRegistration(List <Employee> employees) {
			employees.add(new Employee("Felipe", "felipe@gmail.com", "123.123.123-21", EmploymentContract.CLT));
			employees.add(new Employee("Daniel", "dan@gmail.com", "113.113.123-21", EmploymentContract.ESTAGIO));
			employees.add(new Employee("Marco", "marco@gmail.com", "123.133.123-21", EmploymentContract.ESTAGIO));
			employees.add(new Employee("Silva", "silva@gmail.com", "123.153.123-21", EmploymentContract.CLT));
			employees.add(new Employee("Thiago", "thiago@gmail.com", "173.123.123-21", EmploymentContract.ESTAGIO));
			employees.add(new Employee("Gabriel", "ga@gmail.com", "123.123.143-21", EmploymentContract.CLT));
			employees.add(new Employee("Jonathan", "joan@gmail.com", "123.113.123-21", EmploymentContract.CLT));
		}
	
	
}
