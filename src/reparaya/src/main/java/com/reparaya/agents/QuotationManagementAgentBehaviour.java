package com.reparaya.agents;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reparaya.dtos.EstadoSolicitudDto;
import com.reparaya.services.QuotationService;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import net.sf.json.JSONObject;

public class QuotationManagementAgentBehaviour extends CyclicBehaviour {

	public QuotationManagementAgentBehaviour() {
	}

	@Override
	public void onStart() {
		System.out.println("Inicie QuotationManagementAgentBehaviour");
	}

	@Override
	public void action() {
		List<String> soliditudesCotizadas = QuotationService.getInstance().asignarCotizaciones();
		AID id = new AID();
		id.setLocalName("notificationManagementAgent");

		// Creación del objeto ACLMessage
		ACLMessage mensaje = new ACLMessage(ACLMessage.REQUEST);

		// Rellenar los campos necesarios del mensaje
		mensaje.setSender(getAgent().getAID());
		mensaje.setLanguage("ES");
		mensaje.addReceiver(id);
		EstadoSolicitudDto estadoSolicitud = null;
		ObjectMapper mapper = new ObjectMapper();
		for (String IDSolicitud : soliditudesCotizadas) {
			estadoSolicitud = new EstadoSolicitudDto();
			estadoSolicitud.IDSolicitud = IDSolicitud;
			estadoSolicitud.NuevoEstado = "YI";
			String contenido = null;
			try {
				contenido = mapper.writeValueAsString(estadoSolicitud);
				contenido.toString();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				break;
			}
			mensaje.setContent(contenido);
			// Envia el mensaje a los destinatarios
			getAgent().send(mensaje);
		}
		block(2000);
	}

}
