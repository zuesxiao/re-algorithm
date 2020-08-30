package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q299 {
    public String getHint(String secret, String guess) {
        int length = secret.length();
        int[] mark = new int[length];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                mark[i] = 1;
            }
        }

        for (int i = 0; i < length; i++) {
            if (mark[i] == 1) {
                continue;
            }

            char cg = guess.charAt(i);
            int start = 0;
            while (start < length) {
                int index = secret.indexOf(cg, start);

                if (index == -1) {
                    break;
                }

                if (mark[index] == 0) {
                    cows++;
                    mark[index] = 2;
                    break;
                } else {
                    start = index + 1;
                }
            }
        }

        return bulls + "A" + cows + "B";
    }

    public String getHint1(String secret, String guess) {
        int length = secret.length();
        int[] mark = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < length; i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg) {
                bulls++;
            } else {
                if (mark[cg - '0']++ < 0) {
                    cows++;
                }
                if (mark[cs - '0']-- > 0) {
                    cows++;
                }
            }
        }

        return bulls + "A" + cows + "B";
    }
}
