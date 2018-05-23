package com.reparaya.agents;

import jade.core.behaviours.CyclicBehaviour;
import com.reparaya.services.AppointmentService;


public class AppointmentManagementAgentBehaviour extends CyclicBehaviour {
	
	@Override
	public void onStart(){
		System.out.println("Inicie AppointmentManagementAgentBehaviour");
	}

	@Override
	public void action() {
		AppointmentService.getInstance().setAgent(getAgent());
		AppointmentService.getInstance().createVisitas();
		block(9000);
	}
}