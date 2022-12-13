package Lab4;

import java.util.Arrays;

// С11 = 314 mod 11 = 6     Визначити клас косметика, який складається як мінімум з 5-и полів.

public class Main {
    public static void main(String[] args){
        // initialize array of cosmetics
        Cosmetics[] cosmetics = new Cosmetics[5];

        // add data to array
        cosmetics[0] = new Cosmetics("Тональний засіб", "Японія", "Isehan", "Isehan Kiss Me Ferme Skincare CC Milk", 430);
        cosmetics[1] = new Cosmetics("Помада", "США", "Estee Lauder", "Estee Lauder Pure Color Envy Sculpting Lipstick", 623);
        cosmetics[2] = new Cosmetics("Тіні для очей", "США", "Tarte", "Tarte Cosmetics Tartelette in Bloom Clay Palette", 2085);
        cosmetics[3] = new Cosmetics("Пудра", "Італія", "Pupa", "Pupa Luminys Baked All Over", 424);
        cosmetics[4] = new Cosmetics("Туш для вій", "Бельгія", "Clinique", "Clinique High Impact Curling Mascara", 401);

        // sort cosmetics by prize with comparator SortByPrize
        Arrays.sort(cosmetics, new Cosmetics.SortByPrize());

        // print table of cosmetics
        System.out.println("Відсортовано за ціною:");
        Cosmetics.printTable(cosmetics);

        // sort cosmetics by country with comparator SortByCountry
        Arrays.sort(cosmetics, new Cosmetics.SortByCountry());

        // print table of cosmetics
        System.out.println("\n"+"Відсортовано за країною в обратному порядку:");
        Cosmetics.printTable(cosmetics);
    }
}
