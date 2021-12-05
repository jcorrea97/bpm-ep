package com.example.workflow;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


@Named
public class FinalCheck implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String situation = "aprovado";
		
		//pega as três tarefas anteriores e verifica se todas estão aprovadas
		String situationHealth = (String) execution.getVariable("situationHealth");
		String situationIncome = (String) execution.getVariable("situationIncome");
		String statusField = (String) execution.getVariable("statusField");
		
		if(situationHealth.equals("recusado") || situationIncome.equals("recusado") || statusField.equals("recusado")) {
			situation = "recusado";
		}
		
		execution.setVariable("situationFinal", situation);
		
	}

}
