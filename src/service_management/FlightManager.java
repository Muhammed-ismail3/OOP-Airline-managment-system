package service_management;
import flightManagment.*;
import java.util.*;
import reservation_ticketing.*;
import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class FlightManager {
	
	public FlightManager () {
		
	}
	//first functions create, update and delete flights
	
	public void createFlight(int flightNum,String departurePlace,String arrivalPlace,LocalDate date,LocalTime hour,Duration duration) {
			//extract data from gui and create flites make sure to save the file before exiting program
	}
	public void createFlight(String filePath) throws FileNotFoundException {
		//call the file io class functions and create the flights with the input from the csv files
		FileOp r = new FileOp(filePath);
	}
	public Flight updateFlight(Flight flight) {
		
		return flight;
	}
	public boolean deleteFlight(int flightNum) {
		
		return true;
	}
	 

}
