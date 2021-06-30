package model.services;

import model.entities.CarRental;

public class RentalService {

	private Double pricePerDay;
	private Double privePerHour;

	private BrazilTaxService brazilTaxService;

	public RentalService(Double pricePerDay, Double privePerHour, BrazilTaxService brazilTaxService) {
		this.pricePerDay = pricePerDay;
		this.privePerHour = privePerHour;
		this.brazilTaxService = brazilTaxService;
	}

	public void processInvoice(CarRental carRental) {

	}

}
