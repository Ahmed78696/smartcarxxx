import java.time.LocalDate;

public class Vehicle {
    protected int id;
    protected String regNo;
    protected String manufacturer;
    protected String model;
    protected LocalDate regDate;
    protected String location;
    protected double hourlyRate;
    protected double dailyRate;

    public Vehicle(int id, String regNo, String manufacturer, String model, LocalDate regDate, String location) {
        this.id = id;
        this.regNo = regNo;
        this.manufacturer = manufacturer;
        this.model = model;
        this.regDate = regDate;
        this.location = location;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public String toString() {
        return "Vehicle ID: " + id + ", Model: " + model + ", Location: " + location;
    }
}
