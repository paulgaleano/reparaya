package reparaya.agents;

import java.util.List;

import jade.core.behaviours.CyclicBehaviour;
import reparaya.adapters.SolicitudRepacionAdapterImpl;
import reparaya.adapters.SolicitudReparacionAdapter;
import reparaya.dtos.SolicitudReparacionDto;

public class AppointmentManagementAgentBehaviour extends CyclicBehaviour{	
	private SolicitudReparacionAdapter solicitudReparacionAdapter;
	private List<SolicitudReparacionDto> solicitudesRepacion;
	private int indice=0;
	
	@Override
	public void onStart(){
		System.out.println("Inicie AppointmentManagementAgentBehaviour");
		this.solicitudReparacionAdapter=SolicitudRepacionAdapterImpl.getInstance();
	}
	
	@Override
	public void action() {
		this.indice=this.indice==9?0:this.indice+1;
		this.solicitudesRepacion=this.solicitudReparacionAdapter.getSolicitudesNoAsignadas();
		System.out.println(this.solicitudesRepacion.get(this.indice).getDescripcion());
		block(1000);
		/*if(this.indice<10){
			this.solicitudesRepacion=this.solicitudReparacionAdapter.getSolicitudesNoAsignadas();
			block(1000);
			System.out.println(this.solicitudesRepacion.get(this.indice).getDescripcion());
			this.indice+=1;
		}else{
			System.out.println("entre");
			myAgent.doDelete();
			
		}*/
	}
}
