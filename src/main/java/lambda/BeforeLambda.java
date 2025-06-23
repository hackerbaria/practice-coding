package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BeforeLambda {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green", 4), new Apple("red", 3),
                new Apple("green", 2), new Apple("green", 1),new Apple("green", 10));
        // before java 8
        apples.sort(new Comparator<Apple>() {

            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        System.out.println(apples);

        // using lambda
        //apples.sort((Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight());

        // using method reference
        apples.sort((Comparator.comparingInt(Apple::getWeight)));
    }
}

class Apple {
    private final String color;
    private final int weight;
    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }
    public String getColor() {
        return color;
    }
    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "Apple [color=" + color + ", weight=" + weight + "]";
    }
}
