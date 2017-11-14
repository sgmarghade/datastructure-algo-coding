package com.sgmarghade.dsalgo.array.algo.sorting;

import java.util.Arrays;
import java.util.List;

/**
 * In this approach we move smallest element to top.
 * Repeat this process till we reach the bottom.
 */
public class SelectionSort {

    public static void main(String[] args) {
        new SelectionSort().run(Arrays.asList(new Integer[]{2,4,3,1}));
    }

    private void run(List<Integer> input) {
        //This many times we have iterate top most swapping element for smallest number.
        for(int i = 0; i< input.size() - 1; i++) {

            //This will move till bottom compare element with ith element and swap it if i is less than j
           for(int j = i + 1; j < input.size(); j++) {
               if(input.get(i) > input.get(j)) {
                   Integer tmp = input.get(i);
                   input.set(i, input.get(j));
                   input.set(j, tmp);
               }
           }

        }

        System.out.println("**********Sorted*********");
        for(int i = 0; i< input.size(); i++) {
            System.out.println(input.get(i));
        }

    }
}
