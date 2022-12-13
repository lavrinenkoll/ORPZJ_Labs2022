package Lab6;

//class of kettle device
public class Kettle extends Device {
    //constructor
    public Kettle(Boolean isPlugged, int power, int radiation) {
        super("Чайник", isPlugged, power, radiation);
    }
}
