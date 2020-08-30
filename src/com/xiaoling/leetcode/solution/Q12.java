package com.xiaoling.leetcode.solution;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author xiaoling
 */
public class Q12 {
    public String intToRoman(int num) {
        Map<Integer, String> map = new TreeMap<Integer, String>(Comparator.reverseOrder()) {{
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }};

        String result = "";
        while (num > 0) {
            for (Integer i : map.keySet()) {
                if (num >= i) {
                    result = result + map.get(i);
                    num -= i;
                    break;
                }
            }
        }

        return result;
    }
}
