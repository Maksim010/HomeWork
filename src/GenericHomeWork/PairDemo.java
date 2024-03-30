package GenericHomeWork;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;

public class PairDemo {
    public static void main(String[] args) {
        Pair<Integer,String> pair=Pair.of(1,"123");
        Pair<Integer,String>pair1=Pair.of(1,null);
        System.out.println(pair1);
        Pair<Integer,String> pair2=Pair.empty();
        pair2.ifPresent((firts,second)-> System.out.println(firts+" "+second));
        pair.ifPresent((first,second)-> System.out.println(first+" "+second));
        System.out.println(pair.equals(pair1));
        


    }
}
class Pair<T,U> {
    private T first;
    private U second;

    private Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
    public static <T,U> Pair <T,U> of(T t,U u){
        return new Pair<>(t,u);
    }
    public void ifPresent(BiConsumer<T, U> consumer) {
        if (first != null && second != null) {
            consumer.accept(first, second);
        }
    }
    public static <T, U> Pair<T, U> empty() {
        return new Pair<>(null, null);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
