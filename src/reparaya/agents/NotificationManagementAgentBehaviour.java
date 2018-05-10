package reparaya.agents;

import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import reparaya.adapters.SolicitudRepacionAdapterImpl;
import jade.core.*;

public class NotificationManagementAgentBehaviour extends SimpleBehaviour  {

	 private ACLMessage mensaje;
	 
	 @Override
	 public void onStart(){
		 System.out.println("Inicie NotificationManagementAgentBehaviour");
	}
	 
	@Override
	public void action() {
		System.out.println("Preparandose para recibir");
		 
        this.mensaje=getAgent().receive();

        if (mensaje!= null){
            System.out.println("Recibi el siguiente mensaje: ");
            System.out.println(mensaje.toString());
        }else{
        	block();
        }
	}

	@Override
	public boolean done() {
		return false;
	}

}
