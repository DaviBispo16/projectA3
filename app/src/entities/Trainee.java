package entities;

import enums.EmploymentContract;

public class Trainee extends Employee{
	private Double assistanceTransportation;
	private Double traineeGrant;
	
	public Trainee(String name, String email, String cpf, EmploymentContract employmentContract,
			Double assistanceTransportation, Double traineeGrant) {
		super(name, email, cpf, employmentContract);
		this.assistanceTransportation = assistanceTransportation;
		this.traineeGrant = traineeGrant;
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
	

	@Override
	public void getPayRoll() {
		System.out.println("Resumo do funcionário: " + name);
		System.out.println("Email: " + email);
		System.out.println("CPF: " + cpf);
		System.out.println("Tipo de contrato: " + cpf);
		System.out.println("Auxílio Transporte: " + String.format("%.2f", assistanceTransportation));
		System.out.println("Bolsa Auxílio: " + String.format("%.2f", traineeGrant));
		System.out.println("Salário liquido: " + String.format("%.2f", netSalary()));
	}
		
}
