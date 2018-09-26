package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.flight.beans.Flight;

public class FlightReadWriteDAOImplementation implements FlightsReadWriteDAO {
	public void writeCsvFile(String fileName) {

	}

	public List<Flight> readCsvFile(String fileName) {

		BufferedReader fileReader = null;
		
		// Create a new list of student to be filled by CSV file data
		List<Flight> flights = new ArrayList();
		String line = "";

		try {
			// Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));

			// Read the CSV file header to skip it
			fileReader.readLine();

			// Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				// Get all tokens available in line
				String[] tokens = line.split(COMMA_DELIMITER);

				if (tokens.length > 0) {
					// Create a new student object and fill his data
					Flight flight = new Flight(tokens[FLIGHT_AIRLINE_IDX],
							tokens[FLIGHT_ORIGIN_IDX],
							tokens[FLIGHT_DESTINATION_IDX],
							Double.parseDouble(tokens[FLIGHT_PRICE_IDX].replaceAll("[\\D]", "")));
					flights.add(flight);
				}
			}
			// Print the new student list

			for (Flight flight  : flights) {

				System.out.println(flight.toString());

			}
		} catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}
		return flights;
	}

}
