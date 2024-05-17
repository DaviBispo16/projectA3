package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Employee> employees = new ArrayList<>();
		
		System.out.println("-----Controle de funcionários-----");

		int userChoice;
	
		do {
			System.out.println("MENU");
			System.out.println("[1] Cadastrar Funcionário");
			System.out.println("[2] Listar Funcionários");
			System.out.println("[3] Sair");
			
			userChoice = sc.nextInt();
			
			if (userChoice == 1) {
				 System.out.println();
				 System.out.println("-----Cadastro-----");
				 
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
				 
				 employees.add(new Employee(name, email, cpf, employmentContract, grassSalary));
				 System.out.println("Funcionário cadastrado com sucesso!");
				 System.out.println();
			}
			
			
		} while (userChoice == 1 || userChoice == 2);
		
		

	}

}
