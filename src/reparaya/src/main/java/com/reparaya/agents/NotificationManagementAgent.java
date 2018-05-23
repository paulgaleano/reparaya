package com.reparaya.agents;

import jade.core.Agent;

public class NotificationManagementAgent extends Agent{

	@Override
	protected void setup() {
		System.out.println("Bienvenido, el agente manejador de Notification esta listo.");
		addBehaviour(new NotificationManagementAgentBehaviour());
	}
}
