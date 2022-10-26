package Lab2;
import java.util.Scanner;
import java.util.Random;
/**
 C5 = 314 mod 5 = 4     C=A×B
 C7 = 314 mod 7 = 6     float
 С11 = 314 mod 11 = 6   Обчислити суму найбільших елементів в стовпцях
 матриці з парними номерами та найменших елементів в стовпцях матриці з непарними номерами
 */
public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        String n_str = "";
        int n = 0;
        while (n <= 0) {
            System.out.print("Введіть розмірність матриці (більше за нуль): ");
            n_str = in.nextLine();
            try {
                n = Integer.parseInt(n_str);
            } catch (NumberFormatException e) {
                System.out.println("Помилка вводу: введіть натуральне число.");
            }
        }

        float[][] a = new float[n][n];
        float[][] b = new float[n][n];
        float[][] c = new float[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (float) Math.round(rand.nextFloat()*10);
                b[i][j] = (float) Math.round(rand.nextFloat()*10);
            }
        }
        System.out.println("---------------------"+"\n"+"Отримані матриці:"+"\n"+"Матриця А:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%5.1f", a[i][j]);
            }
            System.out.println("");
        }
        System.out.println("Матриця B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%5.1f", b[i][j]);
            }
            System.out.println("");
        }
        //умножение
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                for (int k=0; k<n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }}}

        float S=0;
        float max = 0;
        float min = c[0][0];
        for (int j = 0; j < n; j++) {
            if ((j+1) % 2 == 1) {
                for (int i = 0; i < n; i++) {
                    if (c[i][j]<=min) min=c[i][j];
                }
                S+=min;
            }
            else {
                for (int i = 0; i < n; i++) {
                    if (c[i][j]>=max) max=c[i][j];
                }
                S+=max;
            }
            min=c[0][0];
            max=0;
        }


        System.out.println("---------------------"+"\n"+"Результат:"+"\n"+"Матриця С=A×B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%6.1f", c[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\nСума найменших елементів у непарних стовбцях і найбільших у парних: "+S);
    }
}

