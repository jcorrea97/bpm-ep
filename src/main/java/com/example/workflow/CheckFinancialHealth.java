package com.example.workflow;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class CheckFinancialHealth implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String situation = "aprovado";
		
		//pega o valor da renda mensal
		String rendaMensal = (String) execution.getVariable("rendaMensalField");
		double rendaMensalDouble = Double.parseDouble(rendaMensal);
		
		//pega o valor do financiamento
		String valorFinanciamento = (String) execution.getVariable("valorFinanciamento");
		double valorFinanciamentoDouble = Double.parseDouble(valorFinanciamento);
		
		
		//verifica se o valor do financiamento é 10 vezes maior que a renda mensal
		double rendaMansalVezesDez = rendaMensalDouble * 10;
		
		if(rendaMansalVezesDez < valorFinanciamentoDouble) {
			situation = "recusado";
		}
		
		execution.setVariable("situationHealth", situation);
		
		
	}

}
