package Lab6;

import java.util.Arrays;
import java.util.Comparator;

public class ElectricalDevices {
    //list of devices
    private final Device[] devices;

    // Constructor
    public ElectricalDevices(Device[] devices) {
        this.devices = devices;
    }

    // get all devices
    public Device[] getDevices() {
        return devices;
    }

    //print table of devices
    public static void printDevices(Device[] devices) {
        //create divider for table
        String divider = new String(new char[82]).replace("\0", "-");
        // print table
        System.out.println(divider);
        System.out.printf("%-17s%-20s%-13s%-35s\n", "Тип приладу", "Підключення", "Потужність", "Електромагнітне випромінювання");
        System.out.println(divider);
        for (Device device : devices) {
            System.out.println(device);
        }
        System.out.println(divider+"\n");
    }

    // calculate total power of plugged devices
    public int getTotalPower() {
        int totalPower = 0;
        for (Device device : devices) {
            if (device.getIsPlugged()) {
                totalPower += device.getPower();
            }
        }
        return totalPower;
    }

    //sort devices by power with comparator
    public void sortByPower() {
        Arrays.sort(devices, Comparator.comparing(Device::getPower));
    }

    //find device with radiation in range a,b
    public Device[] findRadiationInRange(int a, int b) {
        Device[] radiationInRange = new Device[devices.length];
        int index = 0;
        for (Device device : devices) {
            if (device.getRadiation() >= a && device.getRadiation() <= b) {
                radiationInRange[index] = device;
                index++;
            }
        }
        return Arrays.copyOf(radiationInRange, index);
    }
}
