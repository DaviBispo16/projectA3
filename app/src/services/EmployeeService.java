package services;

import java.util.List;
import java.util.Scanner;

import entities.Employee;
import enums.EmploymentContract;
import exceptions.CpfInvalidFormat;
import exceptions.IncorrectEmploymentContract;

public class EmployeeService {
	
	public void listEmployees(List<Employee> employees) {
		System.out.println();
		System.out.println("Nome | Email | Tipo de Contrato | CPF");
		for (Employee list : employees) {
			System.out.println(list.toString());
		}
		System.out.println();
		System.out.println("----------------------------------");
	}
	
	public void registerEmployee(Scanner sc, List<Employee> employees) {
		FieldValidations fieldValidations = new FieldValidations();
		try {
		System.out.println();
		System.out.print("Nome:");
		sc.nextLine(); 
		String name = sc.nextLine();
		 
		System.out.print("Email:");
		String email = sc.next();
		 
		System.out.print("CPF:");
		String cpf = sc.next();
		fieldValidations.validateCPFFormat(cpf);
		fieldValidations.validateEqualCPF(cpf, employees);
		 
		System.out.print("Tipo de Contrato(CLT/ESTAGIO):");
		sc.nextLine();
		String employmentContract = sc.next();
		fieldValidations.validateEmployementContract(employmentContract);
		 
		 
		employees.add(new Employee(name, email, cpf, EmploymentContract.valueOf(employmentContract)));
		System.out.println();
		System.out.println("Funcionário cadastrado!");
		System.out.println();
		System.out.println("----------------------------------");
		} catch (CpfInvalidFormat exception) {
			System.out.println(exception.getMessage());
		} catch (IncorrectEmploymentContract exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public void searchEmployeeByCPF(Scanner sc, List<Employee> employees) {
		System.out.print("Informe o CPF:");
		String cpf = sc.next();
		boolean flag = false;
		System.out.println();
		
		for (Employee list : employees) {
			if (list.getCpf().equals(cpf)) {
				System.out.println("Funcionário Encontrado!");
				System.out.println(list.getName() + "  " + list.getEmail() + "  "  + list.getCpf() + "  " + list.getEmploymentContract());
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
