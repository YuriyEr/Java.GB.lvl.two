package Lesson01.inteface;

import java.util.Random;

public interface Action {
    default void run() { System.out.println("I am running"); }
    default void jump() {
        System.out.println("I am jumping");
    }
    default Integer limitRun () {
        return new Random().nextInt(100);
    }
    default Integer limitJump () {
        return new Random().nextInt(5);
    }

    Integer getMaxJump();
    Integer getMaxRun();
}
