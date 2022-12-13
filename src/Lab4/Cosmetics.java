package Lab4;

// С11 = 314 mod 11 = 6     Визначити клас косметика, який складається як мінімум з 5-и полів.
import java.util.Arrays;
import java.util.Comparator;
import java.lang.String;

public class Cosmetics {
    final private String type, country, brand, name;
    final private int prize;

    Cosmetics (String type, String country, String brand, String name, int prize){
        this.type = type;
        this.country = country;
        this.brand = brand;
        this.name = name;
        this.prize = prize;
    }

    static class SortByPrize implements Comparator<Cosmetics> {
        public int compare(Cosmetics a, Cosmetics b) {
            return Integer.compare(a.prize, b.prize);
        }
    }

    static class SortByCountry implements Comparator<Cosmetics> {
        public int compare(Cosmetics a, Cosmetics b) {
            int FirstLetter1 = (int) a.country.charAt(0);
            int FirstLetter2 = (int) b.country.charAt(0);
            return Integer.compare(FirstLetter1, FirstLetter2)*(-1);
        }
    }

    public static void main(String[] args){
        Cosmetics[] cosmetics = new Cosmetics[5];
        cosmetics[0] = new Cosmetics("Тональний засіб", "Японія", "Isehan", "Isehan Kiss Me Ferme Skincare CC Milk", 430);
        cosmetics[1] = new Cosmetics("Помада", "США", "Estee Lauder", "Estee Lauder Pure Color Envy Sculpting Lipstick", 623);
        cosmetics[2] = new Cosmetics("Тіні для очей", "США", "Tarte", "Tarte Cosmetics Tartelette in Bloom Clay Palette", 2085);
        cosmetics[3] = new Cosmetics("Пудра", "Італія", "Pupa", "Pupa Luminys Baked All Over", 424);
        cosmetics[4] = new Cosmetics("Туш для вій", "Бельгія", "Clinique", "Clinique High Impact Curling Mascara", 401);

        Arrays.sort(cosmetics, new Cosmetics.SortByPrize());
        System.out.println("Відсортовано за ціною:");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-12s%-15s%-50s%-7s\n", "Вид косметики", "Країна", "Бренд", "Назва", "Ціна");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        for (Cosmetics i: cosmetics){
            System.out.printf("%-20s%-12s%-15s%-50s%-5d грн\n", i.type, i.country, i.brand, i.name, i.prize);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");

        Arrays.sort(cosmetics, new Cosmetics.SortByCountry());
        System.out.println("\n"+"Відсортовано за країною в обратному порядку:");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-12s%-15s%-50s%-7s\n", "Вид косметики", "Країна", "Бренд", "Назва", "Ціна");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        for (Cosmetics i: cosmetics){
            System.out.printf("%-20s%-12s%-15s%-50s%-5d грн\n", i.type, i.country, i.brand, i.name, i.prize);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }
}

