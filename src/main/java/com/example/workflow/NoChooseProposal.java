package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class NoChooseProposal implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String infoSemProposta = "Cliente ainda não mandou proposta escolhida";
		
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("clienteNaoEscolheuProposta")
		.setVariable("infoSemProposta", infoSemProposta)
		.correlate();
		
	}

}
