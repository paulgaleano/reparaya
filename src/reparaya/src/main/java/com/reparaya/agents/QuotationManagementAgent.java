package com.reparaya.agents;

import jade.core.Agent;

public class QuotationManagementAgent extends Agent {

	@Override
	protected void setup() {
		System.out.println("Bienvenido, el agente manejador de Quotation esta listo.");
		addBehaviour(new QuotationManagementAgentBehaviour());
	}
	
}
