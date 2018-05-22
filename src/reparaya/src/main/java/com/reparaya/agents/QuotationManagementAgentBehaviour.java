package com.reparaya.agents;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class QuotationManagementAgentBehaviour extends CyclicBehaviour{
	 @Override
	 public void onStart(){
		 System.out.println("Inicie QuotationManagementAgentBehaviour");
	}
	
	@Override
	public void action() {
		AID id = new AID();
		id.setLocalName("nma");

      // Creación del objeto ACLMessage
         ACLMessage mensaje = new ACLMessage(ACLMessage.REQUEST);

      //Rellenar los campos necesarios del mensaje
          mensaje.setSender(getAgent().getAID());
          mensaje.setLanguage("Español");
          mensaje.addReceiver(id);
          mensaje.setContent("{\"notificar\":true;\"tipo_notificacion\":1}");

      //Envia el mensaje a los destinatarios
        getAgent().send(mensaje);
		block(2000);
	}

}
