package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendProposalBrokerToCLient implements JavaDelegate{	
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String propostaUm = "Juros de 0,9% ao mês depois de 1 ano";
		String propostaDois = "Juros de 0,3% por mês em todos os pagamentos";
		
		String bancoOuCorretora = (String) execution.getVariable("bancoOuCorretora");		
		
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("propostaFinanciamento")
		.setVariable("propostaUm", propostaUm)
		.setVariable("propostaDois", propostaDois)
		.setVariable("bancoOuCorretora", bancoOuCorretora)
		.correlate();
		
		}

}
