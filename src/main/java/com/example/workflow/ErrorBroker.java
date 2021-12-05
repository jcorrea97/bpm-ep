package com.example.workflow;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class ErrorBroker implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		throw new BpmnError("Server_error_Broker", "Erro no servidor, tente mais tarde");
		
	}

}
