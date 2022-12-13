package Lab3;

import java.util.Arrays;
import java.util.Scanner;

/**
 C3 = 314 mod 3 = 2       Тип: String
 C17 = 314 mod 17 = 8     Відсортувати слова заданого тексту за зростанням кількості в них заданої літери.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть рядок:");
        String line = in.nextLine();

        boolean flag = true;

        String[] words = new String[0];

        while (flag) {
            // чи пустий рядок
            if ((line.replaceAll("( )+", "")).isEmpty()) {
                System.out.println("Рядок не містить текстових символів.\n");
                System.out.println("Введіть рядок заново:");
                line = in.nextLine();
                continue;
            } else {
                flag = false;
            }

            //видалити зайві пробіли
            line = line.trim();
            line = line.replaceAll("( )+", " ");

            words = line.split(" ");

            //видалити пунктуацію по боках слова
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].replaceAll("^[\\p{Punct}]+|[\\p{Punct}]+$", "");
            }

            //очистити масив від пустих елементів (якщо залишилися декілька символів пунктуації, наприклад -,)
            String[] words2 = new String[words.length];
            int j = 0;
            for (int i = 0; i < words.length; i++) {
                if (!words[i].isEmpty()) {
                    words2[j] = words[i];
                    j++;
                }
            }
            words = Arrays.copyOf(words2, j);

            // винятки, в яких більше 1 знаку всередині слова: віч-на-віч, між'яр'я та інші
            String[] exceptions = {"віч-на-віч", "пліч-о-пліч", "всього-на-всього", "будь-що-будь", "хоч-не-хоч",
                    "як-не-як", "де-не-де", "коли-не-коли", "над'яр'я", "під'яр'я", "між'яр'я"};

            //переверка коректності усіх слів: чи є вони словами (по боках букви, всередені 1 знак '-) або не є винятками
            for (int i = 0; i < words.length; i++) {
                //якщо слово це одна буква то продрвжити
                if (words[i].length() == 1 && Character.isLetter(words[i].charAt(0))) {
                    continue;
                }
                else if (((!words[i].matches("^[\\p{L}]+['-]{0,1}[\\p{L}]+$"))) && !Arrays.asList(exceptions).contains(words[i])) {
                    System.out.print("Введено некоректний рядок. ");
                    System.out.println(words[i] + " - некоректне слово.");
                    System.out.println("Введіть рядок заново:");
                    line = in.nextLine();
                    flag = true;
                    break;
                }
            }
        }

        System.out.println("Введіть шукану літеру:");
        char symbol = ' ';

        while (symbol == ' ') {
            String s = in.nextLine();
            if (s.length() == 1 && Character.isLetter(s.charAt(0))) {
                symbol = s.charAt(0);
                break;
            } else {
                System.out.print("Помилка, введіть 1 літеру: ");
            }
        }

        //порахувати кількість входжень символу в слова
        int[] count = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (Character.toLowerCase(words[i].charAt(j)) == Character.toLowerCase(symbol)) {
                    count[i]++;
                }
            }
        }

        //відсортувати масиви за зростанням
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count.length - 1; j++) {
                if (count[j] > count[j + 1]) {
                    int temp = count[j];
                    count[j] = count[j + 1];
                    count[j + 1] = temp;

                    String temp2 = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp2;
                }
            }
        }

         System.out.printf("Відсортований рядок, за зростанням вмісту літери '%s': ", symbol);

         for (int i=0;i<count.length;i++){
            System.out.print(words[i]+" ");
            }
    }
}

//контрольні приклади
/**
 * Хата Шевченків стояла на краю села. Стара й убога, під солом'яною стріхою з чорним димарем, була вона навколо побілена.
 *      ! Подруги    вирішили ,, поговорити -! віч-на-віч.? У мене в кишені_ всього-на-всього десять гривень.......
 *чим довші , ре!-чення і чим більше7 довгих сл2ів, тим більше помилок13.
 */
