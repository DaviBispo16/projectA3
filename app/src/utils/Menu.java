package utils;

public class Menu {
	public void printInitialMessage() {
		System.out.println("----------Gestão Funcionários---------");
		System.out.println();
	}
	
	public void printMenu() {
		System.out.println("MENU");
		System.out.println("[1] Cadastrar Funcionário");
		System.out.println("[2] Listar todos Funcionários");
		System.out.println("[3] Listar nomes do funcionários de A a Z");
		System.out.println("[4] Procurar funcionário");
		System.out.println("[5] Atualizar Funcionário");
		System.out.println("[6] Excluir Funcionário");
		System.out.println("[7] Dados funcionário");
		System.out.println("[8] Sair");
	}
}
