package entities;

import enums.EmploymentContract;
import exceptions.IncorrectMinimumWage;

public class Clt extends Employee{
	private Double assistanceTransportation;
	private Double foodVouchers;
	private Double grossSalary;
	
	public Clt(String name, String email, String cpf, EmploymentContract employmentContract,
			Double assistanceTransportation, Double foodVouchers, Double grossSalary) {
		super(name, email, cpf, employmentContract);
		this.assistanceTransportation = assistanceTransportation;
		this.foodVouchers = foodVouchers;
		this.grossSalary = grossSalary;
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

	public Double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}
	
	// Metódo para calcular o salário líquido do funcionário
	public Double netSalary() {
		Double inss = 0.0;
		
		if (grossSalary == 1412.00) {
			inss = grossSalary * 0.075;
		} else if (grossSalary > 1412.00 && grossSalary <= 2666.68) {
			inss = grossSalary * 0.09;
		} else if (grossSalary > 2666.68 && grossSalary < 4000.00) {
			inss = grossSalary * 0.12;
		} else {
			inss = grossSalary * 0.14;
		}
		
		return grossSalary - inss;
		
	}
	
	// Metódo para calcular o valor da aliquota INSS do funcionário
	public Double aliquotInss() {
		Double aliquot = 0.0;
		if (grossSalary == 1412.00) {
			aliquot = 7.5;
		} else if (grossSalary > 1412.00 && grossSalary <= 2666.68) {
			aliquot = 9.0;
		} else if (grossSalary > 2666.68 && grossSalary < 4000.00) {
			aliquot = 12.0;
		} else {
			aliquot = 14.0;
		}
		
		return aliquot;
	}
	
	// Metódo para detalhar todos os dados do funcionário
	@Override
	public void getPayRoll() {
		System.out.println("Resumo do Funcionário: " + name);
		System.out.println("Email: " + email);
		System.out.println("CPF: " + cpf);
		System.out.println("Tipo de Contrato: " + employmentContract);
		System.out.println("Auxílio Transporte: " + String.format("%.2f", assistanceTransportation));
		System.out.println("Vale Alimentação: " + String.format("%.2f", foodVouchers));
		System.out.println("Salário Bruto: " + String.format("%.2f", grossSalary));
		System.out.println("Alíquota INSS: " + String.format("%.2f", aliquotInss()) + "%");
		System.out.println("Salário Liquido: " + String.format("%.2f", netSalary()));
		
	}

	
	
	

}
