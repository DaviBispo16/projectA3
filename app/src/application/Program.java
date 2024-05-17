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
		System.out.println("Menu");
		int userChoice;
	
		do {
			System.out.println("[1] Cadastrar Funcionário");
			System.out.println("[2] Listar Funcionários");
			System.out.println("[3] Sair");
			
			userChoice = sc.nextInt();
			
			
			
		} while (userChoice == 1 || userChoice == 2);
		
		

	}

}
