package dao;

import java.util.List;

import com.flight.beans.Flight;

public interface FlightsReadWriteDAO {
	
	//Delimiter used in CSV file
	public final String COMMA_DELIMITER = ",";
	public static final String NEW_LINE_SEPARATOR = "\n";
	
	//Flight attributes index
	public static final int FLIGHT_AIRLINE_IDX = 0;
	public static final int FLIGHT_ORIGIN_IDX = 1;
	public static final int FLIGHT_DESTINATION_IDX = 2;
	public static final int FLIGHT_PRICE_IDX = 3; 

	//CSV file header
	public static final String FILE_HEADER = "airline,origin,destination,price";
	
	public void writeCsvFile(String fileName);
	public List<Flight> readCsvFile(String fileName);
	
}
