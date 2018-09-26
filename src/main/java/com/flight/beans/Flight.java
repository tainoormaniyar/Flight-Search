package com.flight.beans;


public class Flight {
		String airline;
		String origin;
		String destination;
		Double price;
		
		public String getAirline() {
			return airline;
		}
		public void setAirline(String airline) {
			this.airline = airline;
		}
		public String getOrigin() {
			return origin;
		}
		public void setOrigin(String origin) {
			this.origin = origin;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public Flight(String airline, String origin, String destination, Double price) {
			super();
			this.airline = airline;
			this.origin = origin;
			this.destination = destination;
			this.price = price;
		}
		@Override
		public String toString() {
			return "Flight [airline=" + airline + ", origin=" + origin + ", destination=" + destination + ", price="
					+ price + "]";
		}
		
		
		
}
