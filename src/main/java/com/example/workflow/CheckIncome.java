package com.example.workflow;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class CheckIncome implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String situation = "aprovado";
		
		//pega o valor da renda mensal
		String rendaMensal = (String) execution.getVariable("rendaMensalField");
		double rendaMensalDouble = Double.parseDouble(rendaMensal);
		
		//pega o salario médio dos ultimos 5 anos
		String mediaSalarioField = (String) execution.getVariable("mediaSalarioField");
		double mediaSalarioFieldDouble = Double.parseDouble(mediaSalarioField);
		
		
		//verifica se o valor da renda mensal vezes três é maior que a média salarial
		double rendaMansalVezesDois = rendaMensalDouble * 3;
		
		if(rendaMansalVezesDois < mediaSalarioFieldDouble) {
			situation = "recusado";
		}
		
		execution.setVariable("situationIncome", situation);
		
	}

}
