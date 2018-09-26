package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flight.beans.Flight;

import dao.FlightReadWriteDAOImplementation;
import dao.FlightsReadWriteDAO;

@RestController
@RequestMapping("/search")
public class FlightController {
	
	@RequestMapping(value = "/{origin_search}/{destination_search}", method = RequestMethod.GET)
	public List<Flight> searchFlight(@PathVariable String origin_search,@PathVariable String destination_search) throws IOException{
		System.out.println("---------> "+System.getProperty("user.dir"));
		List<Flight> found = new ArrayList<Flight>();
		System.out.println(new java.io.File(".").getCanonicalPath() +"\\src\\main\\java\\data\\");
		FlightsReadWriteDAO flightReaderWriter =new FlightReadWriteDAOImplementation();
		
		List<Flight> flights = flightReaderWriter.readCsvFile("C:\\Users\\Tainoor\\workspace\\FlightNetworkAsg\\src\\main\\java\\data\\Flightdata.csv");
		
		for (Flight flight  : flights) {
			if(origin_search.equals(flight.getOrigin().trim()) && destination_search.equals(flight.getDestination().trim())){
				found.add(flight);
			}
			/*if(destination_search.equals(flight.getOrigin().trim()) && origin_search.equals(flight.getDestination().trim())){
				found.add(flight);
			}*/
		}
		System.out.println("************");
		Collections.sort(found,new FlightsPriceCompare());
		for (Flight flight  : found) {

			System.out.println(flight.toString());

		}
		return found;
	}

}
