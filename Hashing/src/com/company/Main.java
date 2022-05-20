package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        int[][] arary = {{1, 2}, {2, 3}, {3, 4}, {4, 3}, {2, 1}};
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < arary.length; i++) {
//            int first = arary[i][0];
//            int second = arary[i][1];
//
//            if (map.containsKey(second) && map.get(second) == first) {
//                System.out.println("first = " + first + " second = " + second);
//                continue;
//            }
//            map.put(first, second);
//        }

        // first unique char
//        String input = "abcdebadf";
//        char[] array = input.toCharArray();
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < array.length; i++) {
//            char current = array[i];
//            if(map.containsKey(current))
//            {
//                int value = map.get(current);
//                map.put(current, value+1);
//                continue;
//            }
//
//            map.put(current, 1);
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            char current = array[i];
//            if(map.containsKey(current) && map.get((current))==1)
//            {
//                System.out.println(current);
//                break;
//            }
//        }

        HashSet<Integer> hashSet = new HashSet<>();
        int[] array = {4, 5, 8, 9, 7, 6, 7, 3, 3};
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }

        int count = 0;
        int currentElement = array[0];
        while (hashSet.contains(currentElement)) {
            count++;
            currentElement--;
        }

        currentElement = array[0] + 1;
        while (hashSet.contains(currentElement) == true) {
            count++;
            currentElement++;
        }

        if (count == (hashSet.size())) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }



}


