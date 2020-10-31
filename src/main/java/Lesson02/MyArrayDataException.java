package Lesson02;

public class MyArrayDataException extends Exception {
    public MyArrayDataException() {
        super("Преобразование к Number не удалось");
    }
    public MyArrayDataException(String s) {
        super("Преобразование к Number не удалось\n" + s);
    }
    public MyArrayDataException(String s, Throwable cause) {
        super("Преобразование к Number не удалось\n" + s, cause);
    }
}
