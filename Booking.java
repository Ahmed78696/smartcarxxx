import java.time.LocalTime;

public class Booking {
    private int bookingId;
    private int custNo;
    private String location;
    private String vehicleType;
    private LocalTime pickUpTime;
    private LocalTime returnTime;

    public Booking(int bookingId, int custNo, String location, String vehicleType, LocalTime pickUpTime, LocalTime returnTime) {
        this.bookingId = bookingId;
        this.custNo = custNo;
        this.location = location;
        this.vehicleType = vehicleType;
        this.pickUpTime = pickUpTime;
        this.returnTime = returnTime;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + ", Customer No: " + custNo + ", Location: " + location + ", Vehicle Type: " + vehicleType +
                ", Pick-Up Time: " + pickUpTime + ", Return Time: " + returnTime;
    }
}
