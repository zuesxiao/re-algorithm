package com.xiaoling.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 *
 * @author xiaoling
 */
public class Offer20 {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }

        s = s.trim().toLowerCase();
        int length = s.length();

        if (length == 0) {
            return false;
        }

        if (length == 1) {
            return isDigit(s.charAt(0));
        }

        int eIndex = s.indexOf("e");
        int eLastIndex = s.lastIndexOf("e");

        if (eIndex != eLastIndex) {
            return false;
        }

        if (eIndex == 0 || eIndex == length - 1) {
            return false;
        }

        if (eIndex == -1) {
            return isFloat(s);
        } else {
            String first = s.substring(0, eIndex);
            String second = s.substring(eIndex + 1, length);

            return isFloat(first) && isInt(second);
        }
    }

    private boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    private boolean isSymbol(char c) {
        return c == '+' || c == '-';
    }

    private boolean isDot(char c) {
        return c == '.';
    }

    private boolean isFloat(String s) {
        int length = s.length();
        boolean hasSymbol = false;
        boolean hasDot = false;
        boolean hasDigit = false;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (isSymbol(c)) {
                if (!hasSymbol && i == 0) {
                    hasSymbol = true;
                    continue;
                } else {
                    return false;
                }
            }

            if (isDot(c)) {
                if (!hasDot) {
                    hasDot = true;
                    continue;
                } else {
                    return false;
                }
            }

            if (!isDigit(c)) {
                return false;
            } else {
                hasDigit = true;
            }
        }

        return hasDigit;
    }

    private boolean isInt(String s) {
        int length = s.length();
        boolean hasSymbol = false;
        boolean hasDigit = false;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (isSymbol(c)) {
                if (!hasSymbol && i == 0) {
                    hasSymbol = true;
                    continue;
                } else {
                    return false;
                }
            }

            if (!isDigit(c)) {
                return false;
            } else {
                hasDigit = true;
            }
        }

        return hasDigit;
    }

    /**
     * 有限状态自动机
     *
     * @param s
     * @return
     */
    public boolean isNumber1(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_POINT, pointMap);
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_END, endMap);

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    enum State {
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END,
    }

    enum CharType {
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL,
    }
}
