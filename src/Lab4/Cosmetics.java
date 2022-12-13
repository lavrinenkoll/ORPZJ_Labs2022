package Lab4;

import java.util.Comparator;
import java.lang.String;

class Cosmetics {
    // type of cosmetics
    public final String type;

    // country of origin of cosmetics
    public final String country;

    // brand of cosmetics
    public final String brand;

    // name of cosmetics
    public final String name;

    // prize of cosmetics
    private int prize;

    // constructor of class Cosmetics
    Cosmetics (String type, String country, String brand, String name, int prize){
        this.type = type;
        this.country = country;
        this.brand = brand;
        this.name = name;
        this.prize = prize;
    }

    // comparator for sorting by prize
    static class SortByPrize implements Comparator<Cosmetics> {
        public int compare(Cosmetics a, Cosmetics b) {
            return Integer.compare(a.prize, b.prize);
        }
    }

    // reverse comparator for sorting by country
    static class SortByCountry implements Comparator<Cosmetics> {
        public int compare(Cosmetics a, Cosmetics b) {
            int FirstLetter1 = a.country.charAt(0);
            int FirstLetter2 = b.country.charAt(0);
            return Integer.compare(FirstLetter1, FirstLetter2)*(-1);
        }
    }

    // method that return string with data of product
    @Override
    public String toString() {
        return String.format("%-20s%-12s%-15s%-50s%-5d грн\n", type, country, brand, name, prize);
    }

    // method for printing table of cosmetics
    public static void printTable(Cosmetics[] cosmetics) {
        // create divider for table
        String divider = new String(new char[108]).replace("\0", "-");

        // print table
        System.out.println(divider);
        System.out.printf("%-20s%-12s%-15s%-50s%-7s\n", "Вид косметики", "Країна", "Бренд", "Назва", "Ціна");
        System.out.println(divider);
        for (Cosmetics element: cosmetics){
            System.out.print(element.toString());
        }
        System.out.println(divider);
    }

}

