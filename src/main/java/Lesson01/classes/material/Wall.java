package Lesson01.classes.material;

import java.util.Random;

public class Wall {
    private Integer height;

    public Wall() {
        this.height = new Random().nextInt(5);
    }

    public Integer getHeight() {
        return height;
    }
}
