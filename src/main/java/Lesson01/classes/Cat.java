package Lesson01.classes;

import Lesson01.inteface.Action;

public class Cat implements Action {
    private Integer maxJump;
    private Integer maxRun;
    public Cat() {
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
