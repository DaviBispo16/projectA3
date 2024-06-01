package entities;

import java.util.List;

import enums.EmploymentContract;
//Classe Empregados;
public class Employee {
	private String name;
	private String email;
	private String cpf;
	private EmploymentContract employmentContract;
	//Construtor sem Parâmetros;
	public Employee() {
		
	}
	//Construtor com Parâmetros;
	public Employee(String name, String email, String cpf, EmploymentContract employmentContract) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.employmentContract = employmentContract;
	}
	//Getters e Setters dos atributos da classe Employee;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public EmploymentContract getEmploymentContract() {
		return employmentContract;
	}

	public void setEmploymentContract(EmploymentContract employmentContract) {
		this.employmentContract = employmentContract;
	}
	
	// Metódo toString
	@Override
	public String toString() {
		StringBuilder stringbuilder = new StringBuilder();
		
		stringbuilder.append(getName()).append("  ").append(getEmail()).append("  ").append(employmentContract).append("  ").append(cpf);
		return stringbuilder.toString();
	}
	
}
