package entities;

public class Employee {
	private String name;
	private String email;
	private String cpf;
	private String employmentContract;
	private Double grossSalary;
	
	public Employee() {
		
	}

	public Employee(String name, String email, String cpf, String employmentContract, Double grossSalary) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.employmentContract = employmentContract;
		this.grossSalary = grossSalary;
	}

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

	public String getEmploymentContract() {
		return employmentContract;
	}

	public void setEmploymentContract(String employmentContract) {
		this.employmentContract = employmentContract;
	}

	public Double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}
	
	
	
	
}
