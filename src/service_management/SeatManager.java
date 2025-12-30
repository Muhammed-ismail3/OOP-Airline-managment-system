package service_management;

import java.util.Map;
import java.util.Random;

import flightManagment.Flight;
import flightManagment.Seat;
import java.util.List;
import java.util.ArrayList;
public class SeatManager {
	
    private final static Object lock = new Object();
    	

	public static Map<String,Seat> initializeSeats(int rows, int cols,Seat seatM[][],java.util.Map<String,Seat> seatMap) {
	    for (int i = 0; i < rows; i++) {
	        char rowLetter = (char) ('A' + i);
	        for (int j = 0; j < cols; j++) {
	            Seat s = new Seat(rowLetter + String.valueOf(j + 1));
	            //System.out.println(rowLetter + String.valueOf(j + 1));
	            seatM[i][j] = s;
	            seatMap.put(s.getSeatNum(), s);
	        }
	    }
		return seatMap;
	}
	public static boolean reserveSeatUnsafe(Flight flight) {
		Map<String,Seat> seatMap = flight.getPlane().getSeatMap();
		List<Seat> availableSeats = new ArrayList<>();
		
	    for (Seat seat : seatMap.values()) {
	        if (!seat.isReservedStatus()) {
	            availableSeats.add(seat);
	        }
	    }
	    if (availableSeats.isEmpty()) {
	        return false; 
	    }
	    Random random = new Random();
        int index = random.nextInt(availableSeats.size());
        Seat seat = availableSeats.get(index);

        if (!seat.isReservedStatus()) {
            // Mark it reserved (unsafe)
        	try {
        	    Thread.sleep(20);
        	} catch (InterruptedException e) {}

            seat.setReservedStatus(true, flight.getPlane());
            return true;
        }
        return false;
    }
	
	
	
	public static boolean reserveSeatSafe(Flight flight) {
        synchronized (lock) {
        	Map<String,Seat> seatMap = flight.getPlane().getSeatMap();
			List<Seat> availableSeats = new ArrayList<>();
			
		    for (Seat seat : seatMap.values()) {
		        if (!seat.isReservedStatus()) {
		            availableSeats.add(seat);
		        }
		    }
		    if (availableSeats.isEmpty()) {
		        return false; 
		    }
		    Random random = new Random();
		    Seat seat = availableSeats.get(random.nextInt(availableSeats.size()));

            if (!seat.isReservedStatus()) {
                // Mark it reserved (safe)
            	try {
            	    Thread.sleep(20);
            	} catch (InterruptedException e) {}

                seat.setReservedStatus(true, flight.getPlane());
                return true;
            }
            return false;
        }
    }
	
	
	public static Seat assignRandomSeat(boolean SyncType,Flight flight) {
		if(SyncType == true) {
			synchronized(lock) {
				Map<String,Seat> seatMap = flight.getPlane().getSeatMap();
				List<Seat> availableSeats = new ArrayList<>();
				
			    for (Seat seat : seatMap.values()) {
			        if (!seat.isReservedStatus()) {
			            availableSeats.add(seat);
			        }
			    }
			    if (availableSeats.isEmpty()) {
			        return null; 
			    }
			    Random random = new Random();
			    Seat randomSeat = availableSeats.get(random.nextInt(availableSeats.size()));
			    randomSeat.setReservedStatus(true,flight.getPlane());
			    return randomSeat;
		}
	}else {
		Map<String,Seat> seatMap = flight.getPlane().getSeatMap();
		List<Seat> availableSeats = new ArrayList<>();
		
	    for (Seat seat : seatMap.values()) {
	        if (!seat.isReservedStatus()) {
	            availableSeats.add(seat);
	        }
	    }
	    if (availableSeats.isEmpty()) {
	        return null; 
	    }
	    Random random = new Random();
	    Seat randomSeat = availableSeats.get(random.nextInt(availableSeats.size()));
	    
	    randomSeat.setReservedStatus(true,flight.getPlane());
	    return randomSeat;
	}
		
	}
	
	public static int calculateAvailableSeats(Map<String,Seat> seatMap) {
	    int availableSeats = 0;
	    for (Seat seat : seatMap.values()) {
	        if (!seat.isReservedStatus()) {
	            availableSeats++;
	        }
	    }
	    return availableSeats;
	}
}