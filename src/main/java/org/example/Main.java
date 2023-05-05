package org.example;

import java.util.Random;

public class Main {

    static Random _rnd = new Random();

    public static void main(String[] args) {
        MyLinkedList<Integer> lst = new MyLinkedList<>();
        MyLinkedListBasedSet<Integer> set = new MyLinkedListBasedSet<>();
        for(int i = 0; i < 20; i++) {
            lst.add(_rnd.nextInt(1000));
            set.add(_rnd.nextInt(10000));
        }
        lst.addAtPosition(5, 8974);
        set.add(8974);
        System.out.println(lst);
        System.out.println(lst.contains(8974));
        System.out.println("-----------------------------------------------");
        System.out.println(set);
        System.out.println(set.contains(8974));


    }
}