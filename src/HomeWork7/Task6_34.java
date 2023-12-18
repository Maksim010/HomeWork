package HomeWork7;

public class Task6_34 {
//    Найти 15 первых натуральных чисел, делящихся нацело на 19 и находящихся
//    в интервале, левая граница которого равна 100.

    public static void main(String[] args) {
        int n=19;int y=0;
        for(int i=100;i<n*21;i++){
            if(i%n==0) {
                y++;
                System.out.printf("%d число = ",y);
                System.out.println(i);

            }


        }
    }
}
