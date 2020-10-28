package Lesson01;

import Lesson01.classes.Cat;
import Lesson01.classes.Human;
import Lesson01.classes.Robot;
import Lesson01.classes.material.Obstacles;
import Lesson01.classes.material.Wall;
import Lesson01.inteface.Action;

import java.util.ArrayList;

public class Go {
    private static ArrayList<Action> participants;
    private static Obstacles obstacles;

    public static void main(String[] args) {
        init();
        System.out.println(obstacles);
        game();
    }

    static void init() {
        participants = new ArrayList<Action>();
        participants.add(new Robot());
        participants.add(new Human());
        participants.add(new Cat());
        obstacles = new Obstacles();
    }

    static void game() {
        System.out.println("Гонка началась");
        for (Action player : participants) {
            Boolean success = true;
            String name = player.getClass().getSimpleName();
            System.out.println("Начало игры для " + name);
            if (player.getMaxRun() > obstacles.getPath().getLength()) {
                System.out.println("Игрок " + name + " сможет пробежать такую дистнцию, поэтому он начал бежать и прыгать");
                for (Wall obs : obstacles.getWalls()){
                    System.out.println(name + " пытается преодолеть препятствие высотой " + obs.getHeight());
                    if (obs.getHeight() > player.getMaxJump()) {
                        System.out.println("Игрок падает и выбывает");
                        success = false;
                        break;
                    } else {
                        System.out.println(name + " смог перепрыгнуть");
                    }
                }
            } else {
                System.out.println("Игрок " + name + " не может пройти дистанцию так как он может бегать максимум " + player.getMaxRun());
                success = false;
            }
            System.out.println("*****");
            if (success) {
                System.out.println(name + " смог пройти трассу");
                System.out.println("*****");
            }
        }
    }
}
