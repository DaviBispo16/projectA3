package services;

import java.util.List;

import entities.Employee;
import exceptions.CpfInvalidFormat;
import exceptions.IncorrectEmploymentContract;

public class FieldValidations {
	
	public String validateCPFFormat(String cpf) {
		if (cpf.length() == 14 && cpf.charAt(3) == '.' && cpf.charAt(7) == '.' && cpf.charAt(11) == '-') {
			return cpf;
		} else {
			throw new CpfInvalidFormat("CPF no formato incorreto!");
		}
	}
	
	public String validateEmployementContract(String employementContract) {
		if (employementContract.equals("PJ") || employementContract.equals("CLT")) {
			return employementContract;
		} else {
			throw new IncorrectEmploymentContract("O contrato de trabalho deve ser CLT ou PJ!");
		}
	}
	
	public String validateEqualCPF(String cpf, List<Employee> employees) {
	boolean flag = false;
	for (Employee emp : employees) {
		if (emp.getCpf().equals(cpf)) {
			flag = true;
			throw new CpfInvalidFormat("CPF já cadastrado!");
		}
	}
		return cpf;
	}
	
	
	
}
