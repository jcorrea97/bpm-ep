package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ChooseProposal implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		
		String propostaEscolhidaClienteField = (String) execution.getVariable("propostaEscolhidaClienteField");
		
		String infoProposta = "";
		
		String bancoOuCorretora = (String) execution.getVariable("bancoOuCorretora");
		
		if(propostaEscolhidaClienteField.equals("propostaum")) {
			infoProposta = (String) execution.getVariable("propostaUm");
		} else {
			infoProposta = (String) execution.getVariable("propostaDois");
		}
		
		if (bancoOuCorretora.equals("banco")) {
			
			execution.getProcessEngineServices().getRuntimeService()
			.createMessageCorrelation("propostaEscolhidaDoCliente")
			.setVariable("propostaEscolhidaClienteField", infoProposta)
			.setVariable("bancoOuCorretora", bancoOuCorretora)
			.correlate();
		} else {
			execution.getProcessEngineServices().getRuntimeService()
			.createMessageCorrelation("corretoraRecebePropostaEscolhidaDoCliente")
			.setVariable("propostaEscolhidaClienteField", infoProposta)
			.setVariable("bancoOuCorretora", bancoOuCorretora)
			.correlate();
		}
		
	}

}
