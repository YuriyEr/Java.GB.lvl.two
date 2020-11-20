package Lesson01.classes;

import Lesson01.inteface.Action;

public class Robot implements Action {
    private Integer maxJump;
    private Integer maxRun;
    public Robot() {
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
