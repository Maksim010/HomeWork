package HomeWork7;

public class Task5_57 {
    public static void main(String[] args) {
//    Известны оценки двух учеников по четырем предметам. Определить сумму
//    оценок каждого ученика.
                int sum1=0;int sum2=0;
                for(int i=0;i<4;i++){
                    int n=(int)(Math.random()*10)+1;
                    System.out.println(n);
                    sum1+=n;

                }
                for(int j=0;j<4;j++){
                    int m=(int)(Math.random()*10)+1;
                    sum2+=m;
                }
                System.out.println(sum1+" Сумма оценок первого ученика \n"+sum2+" Сумма оценок второго ученика");

            }
        }

