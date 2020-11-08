package Lesson03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

public class PhoneBook {
    private TreeMap<String, ArrayList<Integer>> book = new TreeMap<>();

    public ArrayList<Integer> getPhones(String name) {
        ArrayList<Integer> phones = new ArrayList<>();
        if (book.containsKey(name)){
            phones = book.get(name);
        }
        return phones;
    }

    public void setPhones(String name, Integer phone) {
        ArrayList<Integer> phones = new ArrayList<>();
        if (!book.containsKey(name)){
            phones = book.put(name, new ArrayList<>(Arrays.asList(phone)));
        }
        if (book.containsKey(name)) {
            if (!book.get(name).contains(phone)) {
                book.get(name).add(phone);
            }
        }
    }
    @Override
    public String toString() {
        AtomicReference<String> message = new AtomicReference<>(new String());
        book.forEach((key, value) -> {
            message.set(message.get() + key + " имеет значения номеров:\n" + value + "\n");
        });
        return message.get();
    }
}
