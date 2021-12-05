package com.example.workflow;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class ReserveSeatOnBoat implements JavaDelegate{

	
	@Override
	public void execute(DelegateExecution delegateexecution) throws Exception {
		
		String money = "0.0";
		String ticketType = "Coach";
		
		money = (String) delegateexecution.getVariable("valorFinanciamento");
		double moneyDouble = Double.parseDouble(money);
		
		
		if(moneyDouble >= 10000) {
			ticketType = "Fisrt Class";
			
		} else if (moneyDouble >= 5000){ 
			ticketType = "Business class";
		} else if (moneyDouble <= 10) {
			ticketType = "Stowaway Class";
			throw new BpmnError("Fall_Overboard", "A cheap ticket has led to a small wave throwing you overboar.");
		}
		
		delegateexecution.setVariable("ticketType", ticketType);
			
	}

}
