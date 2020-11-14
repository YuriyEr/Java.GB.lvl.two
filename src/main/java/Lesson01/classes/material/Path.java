package Lesson01.classes.material;

import java.util.Random;

public class Path {
    private Integer length;

    public Path() {
        this.length = new Random().nextInt(100);
    }

    public Integer getLength() {
        return length;
    }
}
