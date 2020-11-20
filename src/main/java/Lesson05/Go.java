package Lesson05;

import java.util.HashMap;

public class Go {

    static final int size = 10000000;
    static final int h = size / 2;
    static volatile float[] arr = new float[size];
    static float[] arrOne = new float[h];
    static float[] arrTwo = new float[h];

    public static void main(String[] args) {
        metrickMS(new arrayEngineInput() {
            @Override
            public void EngineInput() {
                float[] someArray = arr.clone();
                for (Integer i = 0; i < someArray.length; i++) {
                    someArray[i] = 1;
                }
            }
        }, "Время заполнения единицами");

        metrickMS(new arrayEngineInput() {
            @Override
            public void EngineInput() {
                for (Integer i = 0; i < arr.length; i++) {
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        }, "Время заполнения результатом математической операции в одном потоке");

        metrickMS(new arrayEngineInput() {
            @Override
            public void EngineInput() {
                System.arraycopy(arr, 0, arrOne, 0, h);
                System.arraycopy(arr, h, arrTwo, 0, h);
            }
        }, "Время деления массива на 2 части");

        metrickMS(new arrayEngineInput() {
            @Override
            public void EngineInput() {
                Thread one = new Thread(() -> {
                    for (Integer i = 0; i < arrOne.length; i++) {
                        arrOne[i] = (float) (arrOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                    System.out.println("Первый поток закончил работу");
                });
                one.start();
                Thread two = new Thread(() -> {
                    for (Integer i = 0; i < arrTwo.length; i++) {
                        arrTwo[i] = (float) (arrTwo[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                    System.out.println("Второй поток закончил работу");
                });
                two.start();
                try {
                    one.join();
                    two.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.arraycopy(arrOne, 0, arr, 0, h);
                System.arraycopy(arrTwo, 0, arr, h, h);
            }
        }, "Заполнение массива математическими значениями и склейки в ассинхронном режиме");
    }

    static public void metrickMS(arrayEngineInput obj, String metric) {
        final long startTime = System.currentTimeMillis();
        obj.EngineInput();
        final long endTime = System.currentTimeMillis();
        System.out.println(metric + ": " + (endTime - startTime) + "мс");
    }
}

interface arrayEngineInput {
    public void EngineInput();
}