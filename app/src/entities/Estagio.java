package entities;

import enums.EmploymentContract;

public class Estagio extends Employee{
	private Double assistanceTransportation;
	private Double aidGrant;
	
	public Estagio(String name, String email, String cpf, EmploymentContract employmentContract,
			Double assistanceTransportation, Double aidGrant) {
		super(name, email, cpf, employmentContract);
		this.assistanceTransportation = assistanceTransportation;
		this.aidGrant = aidGrant;
	}

	public Double getAssistanceTransportation() {
		return assistanceTransportation;
	}

	public void setAssistanceTransportation(Double assistanceTransportation) {
		this.assistanceTransportation = assistanceTransportation;
	}

	public Double getAidGrant() {
		return aidGrant;
	}

	public void setAidGrant(Double aidGrant) {
		this.aidGrant = aidGrant;
	}
	
	public Double netSalary() {
		return assistanceTransportation+aidGrant;
	}
	
}
