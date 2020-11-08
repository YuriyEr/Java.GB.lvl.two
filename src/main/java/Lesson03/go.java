package Lesson03;

import java.lang.reflect.Array;
import java.util.*;

public class go {
    public static void main(String[] args) {
        //task 01
        ArrayList<String> array = makeArray();
        System.out.println("****** task 01 ******");
        System.out.println("Кол-во совпадений по городам с уникальными ключами\n" + countWords(array));

        //task 02
        PhoneBook somePhoneBook = new PhoneBook();
        somePhoneBook.setPhones("Yuriy", 899900011);
        somePhoneBook.setPhones("Yuriy", 899900999);
        somePhoneBook.setPhones("Vacia", 788998873);
        somePhoneBook.setPhones("Vacia", 788998873);
        somePhoneBook.setPhones("Vacia", 788998874);
        System.out.println("\n****** task 02 ******");
        System.out.println(somePhoneBook);
    }

    private static ArrayList<String> makeArray() {
        ArrayList<String> array = new ArrayList<String>(Arrays.asList(
                "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань",
                "Нижний Новгород", "Челябинск", "Новосибирск", "Самара", "Омск", "Ростов-на-Дону", "Уфа",
                "Новосибирск", "Москва", "Челябинск", "Новосибирск", "Омск"
        ));
        return array;
    }

    private static TreeMap<String, Integer> countWords (ArrayList<String> arrayList) {
        TreeMap<String, Integer> dict = new TreeMap<>();
        for (String val : arrayList) {
            if (dict.containsKey(val)) {
                dict.put(val, dict.get(val)+1);
            } else {
                dict.put(val, 1);
            }
        }
        return dict;
    }
}
