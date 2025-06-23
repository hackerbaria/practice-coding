package lambda;

public interface Bird {
    void canFly(); // public abstract method
    default void canSwim() {
        System.out.println("Can Swim");
        privateMethod();
        swim();
    }

    static void swim() {
        System.out.println("Swim");
        staticMethod();

    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }

    private static void staticMethod() {
        System.out.println("staticMethod");
    }
}
