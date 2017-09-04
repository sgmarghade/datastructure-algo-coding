package com.sgmarghade.dsalgo.array.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Recursive method.
 * subString(0,0) of string returns empty string.
 * subString(0,3) returns string from 0 index and total 3 chards
 * subString(3) return string 3 char onwards means from 4th char.
 *
 *
 * For last char d we call getPermutations with empty string which return hash with empty string as value.
 *
 */
public class PurmutationOfString {
    public static void main(String[] args) {
        new PurmutationOfString().run();

    }

    private void run() {
        Set permutations = getPermutations("abcd");
        System.out.println(permutations);
    }

    private Set<String> getPermutations(String input) {

        Set<String> permutations = new HashSet<String>();

        if(input == null || input.length() == 0) {
            permutations.add("");
            return permutations;
        }

        String firstChar = input.substring(0, 1);

        Set<String> remainingPermutations = getPermutations(input.substring(1));

        for(String word : remainingPermutations) {
            for(int i = 0; i <= word.length(); i++) { //<= sign used to get at least 1 char for say string d with substring(0, 1);
                String prefix = word.substring(0, i); //Get i chars from i index. abc get a for substring 0,1
                String suffix = word.substring(i); //Get char i index onwards (not i). abc get from b for i = 1
                permutations.add(prefix + firstChar + suffix);
            }
        }

        return permutations;
    }


}
