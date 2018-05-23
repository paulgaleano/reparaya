package com.reparaya.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import com.reparaya.adapters.CotizacionOdataAdapter;
import com.reparaya.dtos.ValorCotizacionDto;

public class QuotationService {
	private static QuotationService quotationServicesImpl;

	private QuotationService() {
	}

	public static QuotationService getInstance() {
		if (QuotationService.quotationServicesImpl == null) {
			QuotationService.quotationServicesImpl = new QuotationService();
		}
		return QuotationService.quotationServicesImpl;
	}

	public List<String> asignarCotizaciones() {
		List<ValorCotizacionDto> solicitudes =  CotizacionOdataAdapter.getInstance().getSolicitudesACotizar();
		List<String> solicitudesCotizadas = new ArrayList<String>();
		for (ValorCotizacionDto valorCotizado : solicitudes) {
			valorCotizado.currencyCode = "COP";
			valorCotizado.ValorCotizacion = Double.toString(ThreadLocalRandom.current().nextInt(200000, 400000 + 1));
			solicitudesCotizadas.add(valorCotizado.IDSolicitud);
			 CotizacionOdataAdapter.getInstance().asignarValorCotizacion(valorCotizado);
		}
		return solicitudesCotizadas;
	}

}
