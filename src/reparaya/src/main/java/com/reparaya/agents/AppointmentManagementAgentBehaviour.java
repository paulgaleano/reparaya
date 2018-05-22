package com.reparaya.agents;

import java.util.List;


import jade.core.behaviours.CyclicBehaviour;
import com.reparaya.adapters.SolicitudRepacionODataAdapterImpl;
import com.reparaya.adapters.SolicitudReparacionAdapter;
import com.reparaya.services.AppointmentServicesImpl;

public class AppointmentManagementAgentBehaviour extends CyclicBehaviour{		
	@Override
	public void onStart(){
		System.out.println("Inicie AppointmentManagementAgentBehaviour");
	}
	
	@Override
	public void action() {
		AppointmentServicesImpl.getInstance().assignVisitas();
		block(9000);
	}
}
