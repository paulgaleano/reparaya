package com.reparaya.services;

import com.reparaya.adapters.EstadoSolicitudOdataAdapter;
import com.reparaya.dtos.EstadoSolicitudDto;

public class NotificationService {
	private static NotificationService notificationServicesImpl;

	private NotificationService() {
	}

	public static NotificationService getInstance() {
		if (NotificationService.notificationServicesImpl == null) {
			NotificationService.notificationServicesImpl = new NotificationService();
		}
		return NotificationService.notificationServicesImpl;
	}

	public void asignarEstadoSolicitud(EstadoSolicitudDto estadoSolicitud) {
		String currentStatus = estadoSolicitud.NuevoEstado;
		String newStatus = "YG";
		switch (currentStatus) {
		case "YG":
			newStatus = "YH"; break;
		case "YH":
			newStatus = "YI";break;
		case "YI":
			newStatus = "YJ";break;
		case "YM":
			newStatus = "YN";
		}
		estadoSolicitud.NuevoEstado = newStatus;
		EstadoSolicitudOdataAdapter.getInstance().actualizarEstadoSolicitud(estadoSolicitud);
	}

}
