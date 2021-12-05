package com.example.workflow;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class FinancingSuccess implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		
		String propostaEscolhidaClienteField = (String) execution.getVariable("propostaEscolhidaClienteField");
		String name = (String) execution.getVariable("name");
		
		String infoClienteFinal = name + " " + propostaEscolhidaClienteField;
		
		
		
		execution.setVariable("infoClienteFinal", infoClienteFinal);
		
	}

}
