package Lesson02;

import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class go {
    static Logger logger;
    public static void main(String[] args) {
        logger = logConfig();
        ArrayList<Integer> newSum = null;
        newSum = mappingSum(getArray(6));
        logger.log(Level.INFO, newSum.toString());

        System.out.println(newSum);
    }

    static ArrayList<ArrayList<String>> getArray(Integer size) {
        ArrayList<ArrayList<String>> twoDimArray = new ArrayList<ArrayList<String>>();
        ArrayList<String> element = new ArrayList<String>(Arrays.asList("10", "args2", "2", "3"));
        while (twoDimArray.size() < size) {
            twoDimArray.add(element);
        }
        return twoDimArray;
    }

    static <T> ArrayList<Integer> mappingSum(ArrayList<ArrayList<T>> twoDimensionalArray) {
        chekSize(twoDimensionalArray);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (ArrayList<T> array : twoDimensionalArray) {
            chekSize(array);
            Integer sum = 0;
            for (T x : array) {
                Optional<Integer> value = parse(x);
                if (value != null){
                    sum += value.get();
                }
            }
            result.add(sum);
        }
        return result;
    }

    static <T> void chekSize (ArrayList<T> arrayList) {
        try {
            if (arrayList.size() != 4) {
                throw new MyArraySizeException();
            }
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    static <T> Optional<Integer> parse(T x) {
        try {
            Integer num = Integer.parseInt(x.toString());
            return Optional.ofNullable(num);
        } catch (NumberFormatException e) {
            try {
                throw new MyArrayDataException();
            } catch (MyArrayDataException e1) {
                System.out.println(e1.getMessage());
                logger.log(Level.WARNING, e.getMessage());
                return null;
            }
        }
    }

    static Logger logConfig(){
        Logger logger = null;
        try {
            logger = Logger.getLogger("mylog");
            FileHandler fh = new FileHandler("./mylog.txt");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logger;
    }
}
