package flightManagment;

public class Seat {
	
	public enum SeatClass {
	    ECONOMY(0),
	    BUSINESS(1);

	    private final int index;

	    SeatClass(int index) {
	        this.index = index;
	    }

	    public int getIndex() {
	        return index;
	    }
	}

	private String seatNum;
	private double price;
	private boolean reservedStatus;
	private SeatClass level;
	public Seat(String seatNum) {
		this.seatNum = seatNum;
	}
	public Seat(String seatNum,double price,boolean reservedStatus,SeatClass level) {
		this.seatNum = seatNum;
		this.price = price;
		this.reservedStatus = reservedStatus;
		this.level = level;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isReservedStatus() {
		return reservedStatus;
	}

	public void setReservedStatus(boolean reservedStatus,Plane plane) {
		// Update plane counters based on transition only
		boolean previous = this.reservedStatus;
		if (previous == reservedStatus) {
			// No change
			this.reservedStatus = reservedStatus;
			return;
		}
		if (reservedStatus) {
			// marking seat as now reserved
			plane.setFulledSeatsCount(plane.getFulledSeatsCount() + 1);
			if (plane.getEmptySeatsCount() > 0) {
				plane.setEmptySeatsCount(plane.getEmptySeatsCount() - 1);
			}
		} else {
			// marking seat as now empty
			if (plane.getFulledSeatsCount() > 0) {
				plane.setFulledSeatsCount(plane.getFulledSeatsCount() - 1);
			}
			plane.setEmptySeatsCount(plane.getEmptySeatsCount() + 1);
		}
		this.reservedStatus = reservedStatus;
	}

	public SeatClass getLevel() {
		return level;
	}

	public void setLevel(int level) {//adding checker for the setlevel method 0,1
		
		 this.level = level == 0 ? SeatClass.ECONOMY : SeatClass.BUSINESS;
	}

	@Override
	public String toString() {
		return "Seat [seatNum=" + seatNum + ", price=" + price + ", reservedStatus=" + reservedStatus + ", level="
				+ level + "]";
	}
	
	
	
	
}