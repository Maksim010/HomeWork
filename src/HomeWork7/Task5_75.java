package HomeWork7;

public class Task5_75 {
//    Найти сумму
//2 3 4 10 2 2 2 ... 2 .
//    Операцию возведения в степень не использовать.

    public static void main(String[] args) {
        int n=2;int res=2,sum=0;
        for(int i=0;i<9;i++){
            for(int j=1;j!=0;j--){
                res*=n;
            }
            System.out.println(res);
            sum+=res;
        }
        System.out.println(sum);
    }
}
