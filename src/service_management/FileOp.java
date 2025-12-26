package service_management;
import java.util.*;
import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import flightManagment.Plane;
import flightManagment.Flight;
import reservation_ticketing.Passenger;
import reservation_ticketing.Reservation;
import reservation_ticketing.Ticket;
@SuppressWarnings("unused")

public class FileOp {

    private static Scanner scanner;

    public FileOp(String FileName) throws FileNotFoundException {
        //this.FileName = FileName;
        File file = new File(FileName);
        scanner = new Scanner(file);
    }

    // This Reads The data From The file // chat changed and added a scanner passing
     ArrayList<Flight> GetFlightData() {

        ArrayList<Flight> flights = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            Flight tmp = new Flight(Integer.parseInt(data[0]), data[1], data[2],LocalDate.parse(data[3]),LocalTime.parse(data[4]),Duration.parse(data[5]));
            flights.add(tmp);
        }
        return flights;
    }
    //chat solution might get removed
   

    
    ArrayList<Plane> GetPlaneData() {

        ArrayList<Plane> planes = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            Plane tmp = new Plane(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]),Integer.parseInt(data[3]));
            planes.add(tmp);
        }
        return planes;
    }
    
    ArrayList<Passenger> getPassengerData() {

        ArrayList<Passenger> ps = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            Passenger tmp = new Passenger(Integer.parseInt(data[0]), data[1], data[2],Integer.parseInt(data[3]));
            ps.add(tmp);
        }
        return ps;
    }
    
    
    ArrayList<Reservation> GetReservationData() {

        ArrayList<Reservation> rs = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            Reservation tmp = new Reservation(data[0],Integer.parseInt(data[1]), Integer.parseInt(data[2]),data[3],LocalDate.parse(data[4]));
            rs.add(tmp);
        }
        return rs;
    }
    ArrayList<Ticket> getTicketData() {

        ArrayList<Ticket> tk = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            Ticket tmp = new Ticket(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]),Integer.parseInt(data[3]));
            tk.add(tmp);
        }
        return tk;
    }
    
    static <T> void SaveFile(String fileName, ArrayList<T> list) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (T item : list) {
                writer.append(item.toString()).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file!");
        }
    }

    

    /*

    static void SaveFile(String FileName, ArrayList<Flight> flights){

        try {
            FileWriter writer = new FileWriter(FileName);
            for (Flight i : flights) {
                writer.append(i.getFlightNum() + "," + i.getDeparturePlace() + "," + i.getArrivalPlace() + ","+ i.getDate()+ "," + i.getHour()+","+i.getDuration()+ "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing To the File !!!!");
        }
    }
    */

}