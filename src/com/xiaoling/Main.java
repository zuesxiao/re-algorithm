package com.xiaoling;

/**
 * @author xiaoling
 */
public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.add("abc");
        System.out.println(trie.find("abc"));
        System.out.println(trie.find("ab"));
        System.out.println(trie.find("abcd"));
        trie.add("ab");
        System.out.println(trie.find("abc"));

        trie.add("ab");
        trie.delete("ab");
        System.out.println(trie.find("ab"));
        trie.delete("ab");
        System.out.println(trie.find("ab"));

        trie.add("");
        System.out.println(trie.find(""));
        trie.delete("");
        System.out.println(trie.find(""));
    }
}
