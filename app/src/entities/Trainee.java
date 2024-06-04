package entities;

import enums.EmploymentContract;

public class Trainee extends Employee{
	private Double assistanceTransportation;
	private Double traineeGrant;
	
	public Trainee(String name, String email, String cpf, EmploymentContract employmentContract,
			Double assistanceTransportation, Double aidGrant) {
		super(name, email, cpf, employmentContract);
		this.assistanceTransportation = assistanceTransportation;
		this.traineeGrant = aidGrant;
	}

	public Double getAssistanceTransportation() {
		return assistanceTransportation;
	}

	public void setAssistanceTransportation(Double assistanceTransportation) {
		this.assistanceTransportation = assistanceTransportation;
	}

	public Double getTraineeGrant() {
		return traineeGrant;
	}

	public void setTraineeGrant(Double traineeGrant) {
		this.traineeGrant = traineeGrant;
	}
	
	public Double netSalary() {
		return assistanceTransportation+traineeGrant;
	}
	
	public Double grossSalary() {
		return assistanceTransportation + traineeGrant;
	}
	
	
}
