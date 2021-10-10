package HA4;

import HA3.HashFromString;

import java.util.Arrays;

/**
 * Created by lorenz on 19.01.17.
 */
public class HashTable {
    /**
     * Array of words
     */
    private String[] words = null;

    public HashTable(int length) {
        this.words = new String[length];
    }

    public String print() {
        return Arrays.toString(this.words);
    }

    /**
     * Store a new word in this.words if the position generated as a hash from the word and this.words.length is free.
     * @param word The word to store
     * @return true If string has been stored
     */
    public boolean store(String word) {
        int hash = HashFromString.makeHash(word, this.words.length);
        if (this.words[hash] != null) {
            // this position in the words array is occupied!
            return false;
        }

        this.words[hash] = word;
        return true;
    }

    /**
     * Search str in this.words.
     * @param str The string the user is looking for
     * @return The strings position in the Array or -1 if not existent.
     */
    public int search(String str) {

        String[] arr = this.words;
        int foundAt = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null || arr[i].compareTo(str) != 0) continue;
            foundAt = i;
        }
        return foundAt;
    }

    /**
     * Find and delete str in this.words if existent.
     * @param str The string to be deleted
     */
    public void delete(String str) {
        int strPos = this.search(str);
        if (strPos != -1) {
            this.words[strPos] = null;
        }
    }
}
