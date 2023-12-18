package HomeWork7;

import java.util.Random;

public class Task5_40 {
    public static void main(String[] args) {
        int n=5;double sum=0;
        Random random=new Random();
        for(int i=0;i<n;i++) {
            double a = random.nextDouble();
            sum += a;
        }
            System.out.println("Сумма вещественных чисел = "+sum);

    }
}
