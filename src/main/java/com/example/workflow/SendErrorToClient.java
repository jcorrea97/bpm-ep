package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendErrorToClient implements JavaDelegate{
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String serverError;
		String errorMessage;
		
		if (execution.getVariable("Server_error_Broker") != null) {
			serverError = (String) execution.getVariable("Server_error_Broker");
		} else {
			serverError = "nao tem server error";
		}
		
		if (execution.getVariable("Server_error_Broker") != null) {
			errorMessage = (String) execution.getVariable("Error_Message");
		} else {
			errorMessage = "nao tem mensagem error";
		}	
		
			
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("errorMensagemSistema")
		.setVariable("serverError", serverError)
		.setVariable("errorMessage", errorMessage)
		.correlate();
	}

}
