package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendConfirmFinancingFinal implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String name = (String) execution.getVariable("name");
		String infoClienteFinal = (String) execution.getVariable("infoClienteFinal");
		
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("confirmacaoFinanciamentoFinal")
		.setVariable("name", name)
		.setVariable("informacaoFinal", infoClienteFinal)
		.correlate();
		
	}

}
