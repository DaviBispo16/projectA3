package entities;

import enums.EmploymentContract;
public abstract class Employee implements Comparable<Employee>{
	protected String name;
	protected String email;
	protected String cpf;
	protected EmploymentContract employmentContract;
	
	public Employee() {
		
	}
	
	public Employee(String name, String email, String cpf, EmploymentContract employmentContract) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.employmentContract = employmentContract;
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

	public EmploymentContract getEmploymentContract() {
		return employmentContract;
	}

	public void setEmploymentContract(EmploymentContract employmentContract) {
		this.employmentContract = employmentContract;
	}
	
	public abstract Double netSalary();
	
	public int compareTo(Employee e) {
		return name.compareTo(e.getName());
	}
	
	
	@Override
	public String toString() {
		StringBuilder stringbuilder = new StringBuilder();
		
		stringbuilder.append(getName()).append("  ").append(getEmail()).append("  ").append(employmentContract).append("  ").append(cpf);
		return stringbuilder.toString();
	}
	
	public abstract void getPayRoll(); 
	
}

