package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static List<String> classification(String[] data) {
        List<String> results = new ArrayList<>();
        if (data.length == 1) {
            results.add(data[0]);
            return results;
        }
        String[] part1 = new String[1];
        part1[0] = data[0];
        String[] part2 = new String[data.length - 1];
        System.arraycopy(data, 1, part2, 0, part2.length);
        List<String> res_part1 = classification(part1);
        List<String> res_part2 = classification(part2);
        results.addAll(res_part1);
        results.addAll(res_part2);
        for (String x : res_part1) {
            for (String y : res_part2) {
                results.add(x + " " + y);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        // write your code here
        String[] data1 = {"apple", "banana", "phone", "water"};
        Map<String, Integer> map = new HashMap<>();
        List<String>  classifications = classification(data1);
        for (String x : classifications) {
            System.out.println(x);
            map.put(x, map.get(x) == null ? 1 : map.get(x) + 1);
        }
        System.out.println();
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        int num = 5;
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        System.out.println(mask);
        System.out.println(mask - num);


    }
}
