package com.example.workflow;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class BrokerAnalysisLimit implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		String valorAcimadoLimite = "aprovado";
		
		//pega o valor do financiamento
		String valorFinanciamento = (String) execution.getVariable("valorFinanciamento");
		double valorFinanciamentoDouble = Double.parseDouble(valorFinanciamento);
		
		if(valorFinanciamentoDouble > 9000.00) {
			valorAcimadoLimite = "recusado";
		}
	
		
		execution.setVariable("valorAcimadoLimite", valorAcimadoLimite);
		
		
	}
}
