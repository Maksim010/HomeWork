package HomeWork7;

import java.util.Random;

public class Task5_47 {
            //    Даны числа
//1 2 6 a a a , , ..., .
//    Определить их произведение
            public static void main(String[] args) {
                int n = 6;
                int comp = 1;
                Random random = new Random();
                for (int i = 0; i < n; i++) {
                    int a = random.nextInt(10)+1;
                    System.out.println(a);
                    comp *= a;
                }
                System.out.println(comp);
            }
        }
