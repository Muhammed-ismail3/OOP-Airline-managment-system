package flightManagment;

import java.util.Arrays;

public class Plane {
	private int planeID;
	private String planeModel;
	private int capacity;
	private String seatM[][];
	private int seatNum;
	
		public Plane(int planeId,String planeModel,int capacity,int seatAmount) {
			this.planeID = planeId;
			this.planeModel = planeModel;
			this.capacity = capacity;
			this.seatM = new String[seatAmount][capacity/seatAmount];
			this.seatNum= seatAmount;
			
		}

		public int getPlaneID() {
			return planeID;
		}

		public void setPlaneID(int planeID) {
			this.planeID = planeID;
		}

		public String getPlaneModel() {
			return planeModel;
		}

		public void setPlaneModel(String planeModel) {
			this.planeModel = planeModel;
		}

		public int getCapacity() {
			return capacity;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

		public String[][] getSeatM() {
			return seatM;
		}

		public void setSeatM(String[][] seatM) {
			this.seatM = seatM;
		}
		

		@Override
		public String toString() {
			return "Plane [planeID=" + planeID + ", planeModel=" + planeModel + ", capacity=" + capacity + ", seatM="
					+ Arrays.toString(seatM) + "]";
		}
		public String toFileString() {
		    return getPlaneID() + "," +
		           getPlaneModel() + "," +
		           getCapacity() + "," +
		           this.seatNum;
		}

		
}
