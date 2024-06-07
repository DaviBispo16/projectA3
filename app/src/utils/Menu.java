package utils;

public class Menu {
	public void printInitialMessage() {
		System.out.println("           %-%-%-%-%-%- GESTÃO RH %-%-%-%-%-%-%");
		System.out.println("  Bem-vindo ao Sistema de Gestão de CLT e Estagiários da empresa");
	}
	
	public void printMenu() {
		System.out.println("- _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ - _ -");
		System.out.println();
		System.out.println("MENU | FUNCIONÁRIOS");
		System.out.println("[1] Cadastrar");
		System.out.println("[2] Listar todos");
		System.out.println("[3] Listar nomes de A a Z");
		System.out.println("[4] Procurar");
		System.out.println("[5] Atualizar");
		System.out.println("[6] Excluir");
		System.out.println("[7] Dados completos");
		System.out.println("[8] Sair");
	}
	
	public void printMenuFinal() {
		System.out.println("Você saiu do sistema de RH com sucesso. Até a próxima!");
		System.out.println("----------------------------------------------------------------");
	}
}
