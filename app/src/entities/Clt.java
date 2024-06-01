package entities;

import enums.EmploymentContract;

public class Clt extends Employee{
	private Double assistanceTransportation;
	private Double foodVouchers;
	
	public Clt(String name, String email, String cpf, EmploymentContract employmentContract,
			Double assistanceTransportation, Double foodVouchers) {
		super(name, email, cpf, employmentContract);
		this.assistanceTransportation = assistanceTransportation;
		this.foodVouchers = foodVouchers;
	}

	public Double getAssistanceTransportation() {
		return assistanceTransportation;
	}

	public void setAssistanceTransportation(Double assistanceTransportation) {
		this.assistanceTransportation = assistanceTransportation;
	}

	public Double getFoodVouchers() {
		return foodVouchers;
	}

	public void setFoodVouchers(Double foodVouchers) {
		this.foodVouchers = foodVouchers;
	}
	

}
