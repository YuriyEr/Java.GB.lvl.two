package Lesson01.classes.material;

import java.util.ArrayList;

public class Obstacles {
    private final Path path;
    private final ArrayList<Wall> walls;

    public Obstacles() {
        this.path = new Path();
        this.walls = new ArrayList<Wall>();
        while (this.walls.size() < 5) {
            walls.add(new Wall());
        }
    }

    public Path getPath() {
        return path;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    @Override
    public String toString(){
        return "Текущий маршрут длинной " + this.path.getLength() + ".\nКол-во препятсвий " + this.walls.size();
    }
}
