package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class Main {
    static Integer[] wuw = { 68, 34, 34, 2234, 465, 23, 566, 23, 34, 90, 465, 23, 68, 23 };
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(wuw);
        sortBasedOnFrequencyAndValue(list);
    }

    public static void
    sortBasedOnFrequencyAndValue(List<Integer> list)
    {
        int n = wuw.length;
        final HashMap<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
        final HashMap<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (mapCount.containsKey(wuw[i])) {
                mapCount.put(wuw[i], mapCount.get(wuw[i]) + 1);
            }
            else {
                mapCount.put(wuw[i], 1);
                mapIndex.put(wuw[i], i);
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2)
            {
                int num1 = mapCount.get(n1);
                int num2 = mapCount.get(n2);
                if (num1 != num2) {
                    return num2 - num1;
                }
                else {
                    return mapIndex.get(n1) - mapIndex.get(n2);
                }
            }
        });
        System.out.println(list);
    }
}