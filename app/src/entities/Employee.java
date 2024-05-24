package entities;

import enums.EmploymentContract;
//Classe Empregados;
public class Employee {
	private String name;
	private String email;
	private String cpf;
	private EmploymentContract employmentContract;
	private Double grossSalary;
	//Construtor sem Parâmetros;
	public Employee() {
		
	}
	//Construtor com Parâmetros;
	public Employee(String name, String email, String cpf, EmploymentContract employmentContract, Double grossSalary) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.employmentContract = employmentContract;
		this.grossSalary = grossSalary;
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

	public Double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}
	
	// Metódo toString
	@Override
	public String toString() {
		StringBuilder stringbuilder = new StringBuilder();
		
		stringbuilder.append(getName()).append("  ").append(getEmail()).append("  ").append(employmentContract);
		return stringbuilder.toString();
	}
	
	
}
