import java.time.LocalDate;

public class SmartElectric extends Vehicle {
    private double batterySize;
    private int range;
    private int efficiency;

    public SmartElectric(int id, String regNo, String manufacturer, String model, LocalDate regDate, String location, double batterySize, int range, int efficiency) {
        super(id, regNo, manufacturer, model, regDate, location);
        this.batterySize = batterySize;
        this.range = range;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return super.toString() + ", Battery Size: " + batterySize + " kWh, Range: " + range + " km, Efficiency: " + efficiency + " kWh/km";
    }
}

