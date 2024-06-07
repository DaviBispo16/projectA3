package services;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import entities.Clt;
import entities.Employee;
import entities.Trainee;
import enums.EmploymentContract;
import exceptions.CpfInvalidFormat;
import exceptions.IncorrectEmploymentContract;
import exceptions.IncorrectMinimumWage;

public class EmployeeManagement {
	//Metódo para listar funcionário cadastrados no sistema
	public void listEmployees(List<Employee> employees) {
		System.out.println();
		System.out.println("Nome | Email | Tipo de Contrato | CPF");
		for (Employee list : employees) {
			System.out.println(list.toString());
		}
	}
	
	//Metódo para registrar um funcionário no sistema
	public void registerEmployee(Scanner sc, List<Employee> employees) {
		FieldValidations fieldValidations = new FieldValidations();
		Employee employee = null;
		try {
		System.out.println();
		System.out.print("Nome:");
		sc.nextLine(); 
		String name = sc.nextLine().trim();
		 
		System.out.print("Email:");
		String email = sc.next();
		 
		System.out.print("CPF:");
		String cpf = sc.next();
		fieldValidations.validateCPFFormat(cpf);
		fieldValidations.validateEqualCPF(cpf, employees);
		 
		System.out.print("Tipo de Contrato(CLT/ESTAGIO):");
		sc.nextLine();
		String employmentContract = sc.next().toUpperCase();
		fieldValidations.validateEmployementContract(employmentContract);
		
		if (employmentContract.equals("CLT")) {
			System.out.print("Valor vale-transporte:");
			Double assistanceTransportation = sc.nextDouble();
			
			System.out.print("Valor vale-alimentação:");
			Double foodVouchers = sc.nextDouble();
			
			System.out.print("Valor do salário bruto:");
			Double grossSalary = sc.nextDouble();
			
			if (grossSalary < 1412.00) {
				throw new IncorrectEmploymentContract("O valor do salário bruto mínimo deve ser maior que R$ 1412.00");
			} else {
				employee = new Clt(name, email, cpf, EmploymentContract.valueOf(employmentContract), assistanceTransportation, foodVouchers, grossSalary);
			}
		} 
		
		if (employmentContract.equals("ESTAGIO")) {
			System.out.print("Valor vale-transporte:");
			Double assistanceTransportation = sc.nextDouble();
			
			System.out.print("Valor bolsa-estágio:");
			Double traineeGrant = sc.nextDouble();
			
			employee = new Trainee(name, email, cpf, EmploymentContract.valueOf(employmentContract), assistanceTransportation, traineeGrant);
		}
		 
		employees.add(employee);
		System.out.println();
		System.out.println("Funcionário cadastrado!");
		} catch (CpfInvalidFormat exceptionCpf) {
			System.out.println(exceptionCpf.getMessage());
		} catch (IncorrectEmploymentContract exceptionEmployeeContract) {
			System.out.println(exceptionEmployeeContract.getMessage());
		} catch (IncorrectMinimumWage exceptionWage) {
			System.out.println(exceptionWage.getMessage());
		}
	}
	
	// Metódo para procurar um funcionário no sistema pelo cpf
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
	}
	
	//Metódo para atualizar um funcionário no sistema
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
					String name = sc.nextLine().trim();
					
					System.out.print("Email:");
					String email = sc.next();
										
					employeeToBeUpdated.setName(name);
					employeeToBeUpdated.setEmail(email);
					
					if (employeeToBeUpdated instanceof Clt) {
						Clt employeeClt = (Clt) employeeToBeUpdated;
						System.out.print("Valor vale-transporte:");
						Double assistanceTransportation = sc.nextDouble();
						
						System.out.print("Valor vale-alimentação:");
						Double foodVouchers = sc.nextDouble();
						
						System.out.print("Valor do salário bruto:");
						Double grossSalary = sc.nextDouble();
						
						if (grossSalary < 1412.00) {
							throw new IncorrectEmploymentContract("O valor do salário bruto mínimo deve ser maior que R$ 1412.00");
						}
						
						employeeClt.setAssistanceTransportation(assistanceTransportation);
						employeeClt.setFoodVouchers(foodVouchers);
						employeeClt.setGrossSalary(grossSalary);
					}
					
					if (employeeToBeUpdated instanceof Trainee) {
						Trainee employeeTrainee = (Trainee) employeeToBeUpdated;
						
						System.out.print("Valor vale-transporte:");
						Double assistanceTransportation = sc.nextDouble();
						
						System.out.print("Valor bolsa-estágio:");
						Double traineeGrant = sc.nextDouble();
						
						employeeTrainee.setAssistanceTransportation(assistanceTransportation);
						employeeTrainee.setTraineeGrant(traineeGrant);
					}
					
					System.out.println("Funcionário atualizado!");
					
				} catch (CpfInvalidFormat exceptionCpf) {
					System.out.println(exceptionCpf.getMessage());
				} catch (IncorrectMinimumWage exceptionWage) {
					System.out.println(exceptionWage.getMessage());
				}
			}
		}
		
		if (employeeToBeUpdated == null) {
			System.out.println("Funcionário não encontrado!");
		}
	}
	
	//Metódo para remover um funcionário do sistema
	public void removeEmployee(Scanner sc, List<Employee> employees) {
		System.out.print("Informe o CPF:");
		String cpf = sc.next();
		
		Employee employeeToBeRemove = null;
		
		for (Employee emp : employees) {
			if (emp.getCpf().equalsIgnoreCase(cpf)) {
				System.out.print("Tem certeza que vai excluir o funcionário com CPF: " + cpf + "?");
				String removalDecision = sc.next().toLowerCase();
				
				if (removalDecision.equals("sim")) {
					employeeToBeRemove = emp; 
					System.out.println("Funcionário removido!");
				} else {
					break;
				}
			}
		}
		
		employees.remove(employeeToBeRemove);
		
		if (employeeToBeRemove == null) {
			System.out.println("Funcionário não encontrado!");
		}
	}
	
	//Metódo para listar os funcionários do sistema em ordem crescente
	public void orderByNameAscending(List<Employee> employees) {
		Collections.sort(employees);
		System.out.println();
		System.out.println("Nome | Email | Tipo de Contrato | CPF");
		
		for (Employee list : employees) {
			System.out.println(list.toString());
		}
	}
	
	//Metódo para detalhar um funcionário com todos os seus dados no sistema
	public void getResume(Scanner sc, List <Employee> employees) {
		System.out.print("Informe o CPF:");
		String cpf = sc.next();
		
		for (Employee emp : employees) {
			if (emp.getCpf().equals(cpf)) {
				emp.getPayRoll();
			}
		}
	}
	
	
	
	
	
	
	
}
