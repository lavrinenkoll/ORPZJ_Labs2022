package Lab6;

public class Device {
    //type of device
    private final String type;

    //plugging status of device
    private final Boolean isPlugged;

    //power of device
    private final int power;

    //radiation of device
    private final int radiation;

    // Constructor
    public Device(String type, Boolean isPlugged, int power, int radiation) {
        this.type = type;
        this.isPlugged = isPlugged;
        this.power = power;
        this.radiation = radiation;
    }

    //get type of device
    public String getType() {
        return type;
    }

    //get plugging status of device
    public Boolean getIsPlugged() {
        return isPlugged;
    }

    //get power of device
    public int getPower() {
        return power;
    }

    //get radiation of device
    public int getRadiation() {
        return radiation;
    }

    //print device
    @Override
    public String toString() {
        return String.format("%-17s%-20s%-4s Вт      %-5s Ггц", type, isPlugged ? "Підключений" : "Не підключений", power, radiation);
    }
}
