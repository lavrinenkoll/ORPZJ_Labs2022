package Lab1;

/**
 C2 = 314 mod 2 = 0     O1 : +
 C3 = 314 mod 3 = 2     C = 2
 C5 = 314 mod 5 = 4     O2 : -
 C7 = 314 mod 7 = 6     double i, j
 */
public class Main {

    public static void main(String[] args) {
        float S = 0;
        int a = 4;      // i
        int b = 1;      // j
        int n = 6;
        int m = 2;
        int C = 2;
        if ((a <= n && b <= m) && (a+C !=0)) {
            for (double i = a; i <= n; i++) {
                for (double j = b; j <= m; j++) {
                    S += (i + j) / (i + C);
                }
            }
            System.out.printf ("Результат = %.5f", S);
        }
        else if (a+C == 0){
            System.out.println("Помилка: ділення на 0.");
        }
        else {
            System.out.println("Помилка: останнє число суми не може бути менше ніж початкове.");
        }
    }
}


