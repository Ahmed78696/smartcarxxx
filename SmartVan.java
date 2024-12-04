import java.time.LocalDate;

public class SmartVan extends Vehicle {
    private double engineSize;
    private int co2;

    public SmartVan(int id, String regNo, String manufacturer, String model, LocalDate regDate, String location, double engineSize, int co2) {
        super(id, regNo, manufacturer, model, regDate, location);
        this.engineSize = engineSize;
        this.co2 = co2;
    }

    @Override
    public String toString() {
        return super.toString() + ", Engine Size: " + engineSize + ", CO2: " + co2;
    }
}
