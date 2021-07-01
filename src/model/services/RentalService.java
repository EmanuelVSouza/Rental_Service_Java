package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerDay;
	private Double pricePerHour;

	private BrazilTaxService taxService;;

	public RentalService(Double pricePerDay, Double pricePerHour, BrazilTaxService brazilTaxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = brazilTaxService;
	}

	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		double hours = (double) (t2 - t1) / 1000 / 60 / 60;
		double basicPyament;

		if (hours <= 12.0) {
			basicPyament = Math.ceil(hours) * pricePerHour;
		} 
		else {
			basicPyament = Math.ceil(hours / 24) * pricePerDay;
		}

		double tax = taxService.tax(basicPyament);
		
		carRental.setInvoice(new Invoice(basicPyament, tax));

	}

}
