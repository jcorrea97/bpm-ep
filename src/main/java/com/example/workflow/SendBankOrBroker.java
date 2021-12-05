package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendBankOrBroker implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String name = (String) execution.getVariable("name");
		String valorFinanciamento = (String) execution.getVariable("valorFinanciamento");
		String bancoOuCorretora = (String) execution.getVariable("bancoOuCorretora");
		String rendaMensalField = (String) execution.getVariable("rendaMensalField");
		String mediaSalarioField = (String) execution.getVariable("mediaSalarioField");
		
		if (bancoOuCorretora.equals("banco")) {
			
			execution.getProcessEngineServices().getRuntimeService()
			.createMessageCorrelation("informacoesIniciaisDoCliente")
			.setVariable("name", name)
			.setVariable("valorFinanciamento", valorFinanciamento)
			.setVariable("bancoOuCorretora", bancoOuCorretora)
			.setVariable("rendaMensalField", rendaMensalField)
			.setVariable("mediaSalarioField", mediaSalarioField)
			.correlate();
		} else {
			
			execution.getProcessEngineServices().getRuntimeService()
			.createMessageCorrelation("informacoesIniciaisDoClienteCorretora")
			.setVariable("name", name)
			.setVariable("valorFinanciamento", valorFinanciamento)
			.setVariable("bancoOuCorretora", bancoOuCorretora)
			.setVariable("rendaMensalField", rendaMensalField)
			.setVariable("mediaSalarioField", mediaSalarioField)
			.correlate();
		}
		
	}

}
