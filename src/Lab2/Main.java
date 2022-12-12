package Lab2;
import java.util.Scanner;
import java.util.Random;
/**
 C5 = 314 mod 5 = 4     C=A×B - дія, що виконується з матрицями
 C7 = 314 mod 7 = 6     float - тип елементів матриці
 С11 = 314 mod 11 = 6   Обчислити суму найбільших елементів в стовпцях
 матриці з парними номерами та найменших елементів в стовпцях матриці з непарними номерами
 */
public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int m = -1, n2 = -2, n = 0, m2 = 0;
        //введення розмірності 2 матриць
        while (m != n2) {
            System.out.println("Введіть розмірність першої матриці: ");
            System.out.print("Введіть кількість рядків: ");
            String str = in.nextLine();
            while (!str.matches("[0-9]+") || str.matches("0")) {
                System.out.println("Помилка: введіть число, більше 0.");
                System.out.print("Введіть кількість рядків: ");
                str = in.nextLine();
            }
            n = Integer.parseInt(str);
            System.out.print("Введіть кількість стовпців: ");
            str = in.nextLine();
            while (!str.matches("[0-9]+") || str.matches("0")) {
                System.out.println("Помилка: введіть число, більше 0.");
                System.out.print("Введіть кількість стовпців: ");
                str = in.nextLine();
            }
            m = Integer.parseInt(str);
            System.out.println("\nВведіть розмірність другої матриці: ");
            System.out.print("Введіть кількість рядків: ");
            str = in.nextLine();
            while (!str.matches("[0-9]+") || str.matches("0")) {
                System.out.println("Помилка: введіть число, більше 0.");
                System.out.print("Введіть кількість рядків: ");
                str = in.nextLine();
            }
            n2 = Integer.parseInt(str);
            System.out.print("Введіть кількість стовпців: ");
            str = in.nextLine();
            while (!str.matches("[0-9]+") || str.matches("0")) {
                System.out.println("Помилка: введіть число, більше 0.");
                System.out.print("Введіть кількість стовпців: ");
                str = in.nextLine();
            }
            m2 = Integer.parseInt(str);
            if (m != n2) {
                System.out.println("Помилка: кількість стовпців першої матриці не дорівнює кількості рядків другої матриці.");
                System.out.println("Множення неможливе, спробуйте ввести дані ще раз.");
            }
        }

        float[][] a = new float[n][m];
        float[][] b = new float[n2][m2];
        float[][] c = new float[n][m2];

        //заповнення матриць рандомними числами
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = rand.nextFloat() * 20;
            }
        }
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                b[i][j] = rand.nextFloat() * 20;
            }
        }

        System.out.println("---------------------"+"\n"+"Отримані матриці:"+"\n"+"Матриця А:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%5.1f", a[i][j]);
            }
            System.out.println("");
        }
        System.out.println("Матриця B:");
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                System.out.printf("%5.1f", b[i][j]);
            }
            System.out.println("");
        }

        //множення матриць
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        //Сума найменших елементів у непарних стовбцях і найбільших у парних
        float S=0;
        float max = 0;
        float min = c[0][0];
        for (int j = 0; j < m2; j++) {
            if ((j+1) % 2 == 0) {
                for (int i = 0; i < m; i++) {
                    if (c[i][j] > max) {
                        max = c[i][j];
                    }
                }
                S += max;
                max = 0;
            } else {
                for (int i = 0; i < m; i++) {
                    if (c[i][j] < min) {
                        min = c[i][j];
                    }
                }
                S += min;
                min = c[0][0];
            }
        }

        System.out.println("---------------------"+"\n"+"Результат:"+"\n"+"Матриця С=A×B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m2; j++) {
                System.out.printf("%6.1f", c[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\nСума найменших елементів у непарних стовбцях і найбільших у парних: "+S);
    }
}

