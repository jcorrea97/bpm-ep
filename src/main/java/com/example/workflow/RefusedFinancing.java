package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RefusedFinancing implements JavaDelegate{
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String financingRefused = "Financiamento recusado";
		
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("mensagemFinanciamentoNegado")
		.setVariable("financingRefused", financingRefused)
		.correlate();
		
	}

}
