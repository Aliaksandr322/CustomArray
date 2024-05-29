package main.task.task1;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CustomArray<String> strings = new CustomArray<String>();
        strings.add("One");
        strings.add("Two");
        System.out.println(strings.size());
        for(String e : strings){
            System.out.println(e);
        }
        strings.addByIndex("Three", 1);
        for(String e : strings){
            System.out.println(e);
        }
        strings.add("Four");

        strings.addByIndex("Five", 0);
        for(String e : strings){
            System.out.println(e);
        }
//        strings.addByIndex("Five", 10);
        strings.removeAll();
        System.out.println(strings.size());

//        ArrayList<String> strings = new ArrayList<>();
//
//        strings.add("One");
//        strings.add("Two");
//
//        strings.add(1,"Three");
//        for(String e : strings){
//            System.out.println(e);
//        }

    }
}
