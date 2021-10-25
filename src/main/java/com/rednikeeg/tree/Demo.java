package com.rednikeeg.tree;

import java.util.function.BiConsumer;

public class Demo {
    public static void main(String[] args) {
        TreeMap tm = new TreeMap();

        BiConsumer<String, String> print = (s1, s2) -> System.out.println(s1 + " " + s2);

        tm.insert("Hleb", "0942443");
        tm.insert("Petro", "0942424");
        tm.insert("Ivan", "0942444");
        tm.insert("Sergii", "0942333");
        tm.insert("Maksym", "0942442");
        tm.insert("Svitlana", "094264");
        tm.insert("Maryna", "0942673");
        tm.insert("Daryna", "0942453");
        tm.insert("Khrystyna", "0942742");

        tm.getInOrder(print);

        tm.delete("Maksym");
        tm.delete("Daryna");

        System.out.println();

        tm.getInOrder(print);

    }
}
