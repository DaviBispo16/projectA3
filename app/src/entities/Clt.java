package entities;

import enums.EmploymentContract;

public class Clt extends Employee{
	private Double assistanceTransportation;
	private Double foodVouchers;
	private Double netSalary;
	
	public Clt(String name, String email, String cpf, EmploymentContract employmentContract,
			Double assistanceTransportation, Double foodVouchers, Double netSalary) {
		super(name, email, cpf, employmentContract);
		this.assistanceTransportation = assistanceTransportation;
		this.foodVouchers = foodVouchers;
		this.netSalary = netSalary;
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

	public Double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
	}
	
	public Double grossSalary() {
		Double inss = 0.0;

		if (netSalary < 1412.00) {
			throw new RuntimeException("Salário deve ser maior!");
		} else if (netSalary == 1412.00) {
			return netSalary - (netSalary * 0.075);
		} else if (netSalary > 1412.00 && netSalary <= 2.666) {
			return netSalary - (netSalary * 0.09);
		} else if (netSalary > 2.666 && netSalary <= 4.000) {
			return netSalary - (netSalary * 0.12);
		} else if (netSalary <= 7087.22) {
			return netSalary - (netSalary * 0.14);
		} else {
			return 99.99;
		}
	
		
	}

	@Override
	public void getPayRoll() {
		System.out.println("Resumo do Funcionário: " + name);
		System.out.println("Email: " + email);
		System.out.println("CPF: " + cpf);
		System.out.println("Tipo de Contrato: " + cpf);
		System.out.println("Auxílio Transporte: " + String.format("%.2f", assistanceTransportation));
		System.out.println("Vale Alimentação: " + String.format("%.2f", foodVouchers));
		System.out.println("Salário Bruto: " + String.format("%.2f", netSalary));
//		System.out.println("Salário Liquido: " + (assistanceTransportation + foodVouchers + netSalary);
		
	}

	
	
	

}
