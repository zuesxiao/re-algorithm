package com.xiaoling.leetcode.solution;

import java.util.*;

/**
 * @author xiaoling
 */
public class Q17 {
    public List<String> letterCombinations(String digits) {
        List<String> strings = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return strings;
        }

        int length = digits.length();
        Map<Character, String[]> map = new HashMap<>(8);
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});

        int[] indexes = new int[length];
        Arrays.fill(indexes, 0);

        while (true) {
            strings.add(buildString(map, digits, indexes));
            if (!stepForward(map, digits, indexes)) {
                break;
            }
        }

        return strings;
    }

    private boolean stepForward(Map<Character, String[]> map, String digits, int[] indexes) {
        for (int i = 0; i < indexes.length; i++) {
            int max = map.get(digits.charAt(i)).length - 1;

            if (indexes[i] + 1 > max) {
                indexes[i] = 0;
            } else {
                indexes[i]++;
                return true;
            }
        }
        return false;
    }

    private String buildString(Map<Character, String[]> map, String digits, int[] indexes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indexes.length; i++) {
            sb.append(map.get(digits.charAt(i))[indexes[i]]);
        }
        return sb.toString();
    }
}
