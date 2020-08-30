package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q345 {
    public String reverseVowels(String s) {
        int length = s.length();

        if(length<=1){
            return s;
        }

        int left = 0;
        int right = length - 1;
        char[] chars = s.toCharArray();

        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);

            if (isVowel(cLeft) && isVowel(cRight)) {
                chars[left++] = cRight;
                chars[right--] = cLeft;
            } else {
                if (!isVowel(cLeft)) {
                    chars[left++] = cLeft;
                }
                if (!isVowel(cRight)) {
                    chars[right--] = cRight;
                }
            }
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
