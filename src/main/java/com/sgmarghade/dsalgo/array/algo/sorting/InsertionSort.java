package com.sgmarghade.dsalgo.array.algo.sorting;

import java.util.Arrays;
import java.util.List;

/**
 * Stable sort = for same values order is not changed.
 * Online sort = it can sort list as and when it receives it.
 * Inplace Sort = no need of extra space.
 *
 * Start with 1st index and check with left element.
 * If its smaller swap it. repeat till it reaches the end.
 * Then move index to 2nd element and repeat process.
 *
 *
 * Eg:
 * i = 1:    12, 35
 *   35 > 12, so the array is still sorted.
 *
 *  i = 2:    12, 35, 87
    87 > 35 added to already sorted array, so no change needed.

    i = 3:    12, 35, 87, 26
    As 26 < 87, the sub array is not sorted now and we need to place 26 at is correct position.
 */
public class InsertionSort {
    public static void main(String[] args) {
        new InsertionSort().run(Arrays.asList(new Integer[]{5,3,4,2}));
    }

    private void run(List<Integer> input) {

        for(int i = 1; i < input.size(); i++) {

            //Pick current element and moves it to left till it reaches the right position.
            for(int j = i; j > 0; j--) {
                if(input.get(j) < input.get(j - 1)) {
                    Integer tmp = input.get(j - 1);
                    input.set(j - 1, input.get(j));
                    input.set(j, tmp);
                }else {
                    //Its sorted here onwards break the loop.
                    break;
                }
            }


        }


        System.out.println("**********Sorted*********");
        for(int i = 0; i< input.size(); i++) {
            System.out.println(input.get(i));
        }
    }
}
