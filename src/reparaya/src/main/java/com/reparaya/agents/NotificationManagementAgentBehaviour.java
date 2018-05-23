package com.reparaya.agents;

import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import net.sf.json.JSONObject;

import com.reparaya.dtos.EstadoSolicitudDto;
import com.reparaya.services.NotificationService;

public class NotificationManagementAgentBehaviour extends SimpleBehaviour {
	private ACLMessage mensaje;

	public NotificationManagementAgentBehaviour() {
		super();	
	}

	@Override
	public void onStart() {
		System.out.println("Inicie NotificationManagementAgentBehaviour");
	}

	@Override
	public void action() {
		System.out.println("Preparandose para recibir");

		this.mensaje = getAgent().receive();

		if (mensaje != null) {
			System.out.println("Recibi el siguiente mensaje: ");
			System.out.println(mensaje.toString());
			JSONObject payload = JSONObject.fromObject(mensaje.getContent());
			EstadoSolicitudDto estadoSolicitud = new EstadoSolicitudDto();
			estadoSolicitud.IDSolicitud = payload.getString("IDSolicitud");
			estadoSolicitud.NuevoEstado = payload.getString("NuevoEstado");
			NotificationService.getInstance().asignarEstadoSolicitud(estadoSolicitud);
		} else {
			block();
		}
	}

	@Override
	public boolean done() {
		return false;
	}

}
