package Lesson01.classes;

import Lesson01.inteface.Action;

public class Human implements Action {
    private Integer maxJump;
    private Integer maxRun;

    public Human() {
        this.maxJump = limitJump();
        this.maxRun = limitRun();
    }

    public Integer getMaxJump() {
        return maxJump;
    }

    public Integer getMaxRun() {
        return maxRun;
    }
}
