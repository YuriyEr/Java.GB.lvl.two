package Lesson01.inteface;

public interface Action {
    default void run() {
        System.out.println("I am running");
    }

    default void jump() {
        System.out.println("I am jumping");
    }
}
