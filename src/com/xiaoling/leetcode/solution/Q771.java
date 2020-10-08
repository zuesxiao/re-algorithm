package com.xiaoling.leetcode.solution;


/**
 * @author xiaoling
 */
public class Q771 {
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.length() == 0 || S == null || S.length() == 0){
            return 0;
        }

        boolean[] mark = new boolean[58];

        for(int i = 0; i < J.length(); i ++){
            mark[J.charAt(i) - 'A'] = true;
        }

        int count = 0;
        for(int i = 0; i < S.length(); i ++){
            if(mark[S.charAt(i) - 'A']){
                count ++;
            }
        }

        return count;
    }
}
