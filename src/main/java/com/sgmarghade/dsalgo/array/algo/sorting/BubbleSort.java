package com.sgmarghade.dsalgo.array.algo.sorting;
import java.util.Arrays;
import java.util.List;

/**
 * Swap adjuscent values.
 * Move bigger number to bottom.
 * [12, 35], 87, 26, 9, 28, 7     12 < 35, no swapping required
 * 12, [35, 87], 26, 9, 28, 7     35 < 87, no swapping required
 * 12, 35, [87, 26], 9, 28, 7     87 > 26, swap
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] list = new Integer[]{3,1,2,8,3,5};
        new BubbleSort().run(Arrays.asList(list));
    }

    private void run(List<Integer> input) {
        for(int i = 0; i< input.size(); i++) {  //We have to iterate swapping list n times.


            //This is the loop which checks adjacent numbers.
            for(int j = 0; j + 1 < (input.size() - i); j++) {  //After 1st swap biggest element will be at the bottom. no need to check it next time.

                if(input.get(j) > input.get(j + 1)) {
                    Integer tmp = input.get(j);
                    input.set(j, input.get(j+1));
                    input.set(j+1, tmp);
                }

            }

        }

        System.out.println("**********Sorted*********");

        for(int i = 0; i< input.size(); i++) {
            System.out.println(input.get(i));
        }
    }
}
