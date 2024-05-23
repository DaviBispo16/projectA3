package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import enums.EmploymentContract;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Employee> employees = new ArrayList<>();
		automaticEmployeeRegistration(employees);
			
		System.out.println("----------Gestão Empregados---------");

		int userChoice;
	
		do {
			System.out.println();
			System.out.println("MENU");
			System.out.println("[1] Cadastrar Funcionário");
			System.out.println("[2] Listar todos Funcionários");
			System.out.println("[3] Buscar funcionário pelo CPF");
			System.out.println("[4] Sair");
			userChoice = sc.nextInt();
			
		switch(userChoice) {
			case 1:
			registerEmployee(sc, employees);
			break;
			case 2: 
			listEmployees(employees);
			break;	
			case 3: 
			searchEmployeeByCPF(sc, employees);
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
	
	static void listEmployees(List<Employee> employees) {
		System.out.println();
		System.out.println("Nome | Email | Tipo de Contrato");
		for (Employee list : employees) {
			System.out.println(list.toString());
		}
		System.out.println();
		System.out.println("----------------------------------");
	}
	
	static void registerEmployee(Scanner sc, List<Employee> employees) {
		System.out.println();
		System.out.print("Nome:");
		sc.nextLine(); 
		String name = sc.nextLine();
		 
		System.out.print("Email:");
		String email = sc.next();
		 
		System.out.print("CPF:");
		String cpf = sc.next();
		 
		System.out.print("Tipo de Contrato:");
		sc.nextLine();
		String employmentContract = sc.nextLine();
		 
		System.out.print("Salário Bruto:");
		Double grassSalary = sc.nextDouble();
		 
		employees.add(new Employee(name, email, cpf, EmploymentContract.valueOf(employmentContract), grassSalary));
		System.out.println();
		System.out.println("Funcionário cadastrado!");
		System.out.println();
		System.out.println("----------------------------------");
	}
	
	static void automaticEmployeeRegistration(List <Employee> employees) {
		employees.add(new Employee("Felipe", "felipe@gmail.com", "123.123.123-21", EmploymentContract.CLT, 1400.00));
		employees.add(new Employee("Daniel", "dan@gmail.com", "113.113.123-21", EmploymentContract.PJ, 2400.00));
		employees.add(new Employee("Marco", "marco@gmail.com", "123.133.123-21", EmploymentContract.PJ, 1200.00));
		employees.add(new Employee("Silva", "silva@gmail.com", "123.153.123-21", EmploymentContract.PJ, 1300.00));
		employees.add(new Employee("Thiago", "thiago@gmail.com", "173.123.123-21", EmploymentContract.PJ, 4400.00));
		employees.add(new Employee("Gabriel", "ga@gmail.com", "123.123.143-21", EmploymentContract.PJ, 6400.00));
		employees.add(new Employee("Jonathan", "joan@gmail.com", "123.113.123-21", EmploymentContract.PJ, 1400.00));
	}
	
	static void searchEmployeeByCPF(Scanner sc, List<Employee> employees) {
		System.out.print("Informe o CPF:");
		String cpf = sc.next();
		boolean flag = false;
		System.out.println();
		
		for (Employee list : employees) {
			if (list.getCpf().equals(cpf)) {
				System.out.println("Funcionário Encontrado!");
				System.out.println(list.getName() + "  " + list.getEmail() + "  "  + list.getCpf() + "  " + list.getEmploymentContract() +
						"  " + String.format("%.2f", list.getGrossSalary()));
				flag = true;
			} 
		}
		
		if (!flag) {
			System.out.println("CPF não encontrado!");
		}
		System.out.println();
		System.out.println("----------------------------------");
	}

}
