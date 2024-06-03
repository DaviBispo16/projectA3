package services;

import java.util.List;
import java.util.Scanner;

import entities.Clt;
import entities.Employee;
import entities.Estagio;
import enums.EmploymentContract;
import exceptions.CpfInvalidFormat;
import exceptions.IncorrectEmploymentContract;

public class EmployeeManagement {
	
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
		Employee employee = null;
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
		
		if (employmentContract.equals("CLT")) {
			System.out.print("Valor vale-transporte:");
			Double assistanceTransportation = sc.nextDouble();
			
			System.out.print("Valor vale-alimentação:");
			Double foodVouchers = sc.nextDouble();
			
			employee = new Clt(name, email, cpf, EmploymentContract.valueOf(employmentContract), assistanceTransportation, foodVouchers);
			
		} 
		
		if (employmentContract.equals("ESTAGIO")) {
			System.out.print("Valor vale-transporte:");
			Double assistanceTransportation = sc.nextDouble();
			
			System.out.print("Valor bolsa-estágio:");
			Double traineeGrant = sc.nextDouble();
			
			employee = new Estagio(name, email, cpf, EmploymentContract.valueOf(employmentContract), assistanceTransportation, traineeGrant);
		}
		 
		 
		employees.add(employee);
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
	
	public void updateEmployee(Scanner sc, List<Employee> employees) {
		FieldValidations fieldValidations = new FieldValidations();
		System.out.print("Informe o CPF:");
		String cpf = sc.next();
		
		Employee employeeToBeUpdated = null;
		
		for (Employee emp : employees) {
			if (emp.getCpf().equals(cpf)) {
				employeeToBeUpdated = emp;
				try {
					System.out.println();
					System.out.print("Nome:");
					sc.nextLine(); 
					String name = sc.nextLine();
					
					System.out.print("Email:");
					String email = sc.next();
					
					System.out.print("Tipo de Contrato(CLT/ESTAGIO):");
					sc.nextLine();
					String employmentContract = sc.next();
					fieldValidations.validateEmployementContract(employmentContract);
					
					emp.setName(name);
					emp.setEmail(email);
					emp.setEmploymentContract(EmploymentContract.valueOf(employmentContract));
					
					System.out.println("Funcionário atualizado!");
					
				} catch (CpfInvalidFormat exception) {
					System.out.println(exception.getMessage());
				}  catch (IncorrectEmploymentContract exception) {
					System.out.println(exception.getMessage());
				}
			}
		}
		
		if (employeeToBeUpdated == null) {
			System.out.println("Funcionário não encontrado!");
		}
		System.out.println();
		System.out.println("----------------------------------");
	}
	
	public void removeEmployee(Scanner sc, List<Employee> employees) {
		System.out.print("Informe o CPF:");
		String cpf = sc.next();
		
		Employee employeeToBeRemove = null;
		
		for (Employee emp : employees) {
			if (emp.getCpf().equalsIgnoreCase(cpf)) {
				employeeToBeRemove = emp;
				
				System.out.println("Funcionário removido!");
			}
		}
		
		employees.remove(employeeToBeRemove);
		
		if (employeeToBeRemove == null) {
			System.out.println("Funcionário não encontrado!");
		}
		System.out.println();
		System.out.println("----------------------------------");
	}
	
	
	
	
	
	
}
