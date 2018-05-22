package com.reparaya.agents;

import jade.core.Agent;

public class AppointmentManagementAgent extends Agent{

	@Override
	protected void setup() {
		System.out.println("Bienvenido, el agente manejador de Appointments esta listo.");
		addBehaviour(new AppointmentManagementAgentBehaviour());
	}
}