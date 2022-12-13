package Lab6;

//class of PC device
public class PC extends Device {
    //constructor
    public PC(Boolean isPlugged, int power, int radiation) {
        super("ПК", isPlugged, power, radiation);
    }
}