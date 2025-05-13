package at.technikum.exercises.voexercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class ListExample {
    private static int MAX_NUMBERS = 1000000;

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();      // read = O(1), write = O(n), read fast, write slow
        System.out.println(numbers.size());
        numbers.add(13);
        System.out.println(numbers.size());
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_NUMBERS; i++) {
            numbers.add(i);
        }

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        System.out.println("time elapsed array list: " + timeElapsed);

        List<Integer> linkedList = new LinkedList<>();  // read = O(n), write = O(1), write fast, read slow
        linkedList.add(1);
        System.out.println(linkedList);

        start = System.currentTimeMillis();
        for (int i = 0; i < MAX_NUMBERS; i++) {
            linkedList.add(i);
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;

        System.out.println("time elapsed linked list: " + timeElapsed);

    }

}