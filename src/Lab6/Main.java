package Lab6;
/*
C13 = 314 mod 13 = 2
Визначити ієрархію електроприладів. Увімкнути деякі електроприлади в розетку.
Підрахувати споживану потужність. Провести сортування приладів у квартирі на основі потужності.
Знайти прилад у квартирі, що відповідає заданому діапазону електор-магнітного випромінювання.
*/
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //create scanner for input and random for random values
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //input time of work in hours with validation
        System.out.print("Введіть години роботи приладів для розрахунку споживаної потужності: ");
        int time;
        while (!scanner.hasNextInt() || (time = scanner.nextInt()) <= 0) {
            System.out.print("Введіть години роботи приладів для розрахунку споживаної потужності: ");
            scanner.next();
        }

        //input number of devices with validation
        System.out.print("Введіть кількість приборів: ");
        int number;
        while (!scanner.hasNextInt() || (number = scanner.nextInt()) <= 0) {
            System.out.print("Введіть кількість приборів: ");
            scanner.next();
        }
        System.out.println();

        //input range of radiation with validation
        System.out.println("Задайте границі можливого електромагнітного випромінювання.");
        int min, max;
        System.out.print("Початкове значення: ");
        while (!scanner.hasNextInt() || (min = scanner.nextInt()) < 0) {
            System.out.print("Початкове значення: ");
            scanner.next();
        }
        System.out.print("Кінцеве значення: ");
        while (!scanner.hasNextInt() || (max = scanner.nextInt()) < 0) {
            System.out.print("Кінцеве значення: ");
            scanner.next();
        }
        System.out.println();

        //create array of devices
        Device[] devices = new Device[number];

        //fill array with devices
        for (int i = 0; i < number; i++) {
            switch (random.nextInt(4)) {
                case 1 -> devices[i] = new Fridge(random.nextBoolean(), random.nextInt(1000 - 100), random.nextInt(1000 - 100));
                case 2 -> devices[i] = new Kettle(random.nextBoolean(), random.nextInt(1000 - 100), random.nextInt(1000 - 100));
                case 3 -> devices[i] = new PC(random.nextBoolean(), random.nextInt(1000 - 100), random.nextInt(1000 - 100));
                default -> devices[i] = new TV(random.nextBoolean(), random.nextInt(1000 - 100), random.nextInt(1000 - 100));
            }
        }

        //create array of home devices
        ElectricalDevices home_devices = new ElectricalDevices(devices);

        //calculate total power and print it
        int total_power_per_hour = home_devices.getTotalPower();
        double total_power;
        total_power = total_power_per_hour*time;
        System.out.printf("Усі увімкнені прилади споживають %s Вт за %s год. роботи.\n\n", total_power, time);

        //sort devices by power and print it
        home_devices.sortByPower();
        System.out.println("Посортовані прилади за потужністю:");
        ElectricalDevices.printDevices(devices);

        //find devices in range of radiation and print it
        Device[] devices_in_range = home_devices.findRadiationInRange(min, max);
        if (devices_in_range.length == 0) {
            System.out.println("Нема приладів, які задовольняють заданий діапазон електромагнітного випромінювання.");
        } else {
            System.out.printf("Прилади, електромагнітне випромінювання яких у заданих межах від %s до %s Ггц:\n",
                    min, max);
            ElectricalDevices.printDevices(devices_in_range);
        }

    }
}
