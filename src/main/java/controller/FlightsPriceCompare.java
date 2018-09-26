package controller;

import java.util.Comparator;

import com.flight.beans.Flight;

public class FlightsPriceCompare implements Comparator<Flight> {

	public int compare(Flight o1, Flight o2) {
		if(o1.getPrice()<o2.getPrice()){
			return 1;
		}
		else
			return -1;
	}

}
