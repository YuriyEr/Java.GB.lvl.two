package Lesson02;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Ошибка заданного размера массива 4х4");
    }
    public MyArraySizeException(String s) {
        super("Ошибка заданного размера массива 4х4\n" + s);
    }
    public MyArraySizeException(String s, Throwable cause) {
        super("Ошибка заданного размера массива 4х4\n" + s, cause);
    }
}
