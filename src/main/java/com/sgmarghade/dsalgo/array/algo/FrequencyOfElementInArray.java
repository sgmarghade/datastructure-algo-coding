package com.sgmarghade.dsalgo.array.algo;

/**
 * There are 2 optimised way to solve this problem.
 *
 * Question : In array of size n elements 1 to n are repeated multiple times and we have to find out total occurance of
 * each element.
 *
 *   ArraySize : n
 *   minElement : 1,
 *   maxElement : n,
 *
 *
 * Algo1 :
 *
 *       1. Create another array of size n and mark all elements from 0 to n-1 as 0 as tmpArray;
 *       2. Traverse input array from 0 to n-1 and mark tmpArray[input[i] - 1]++;
 *       3. Traverse tmpArray and print tmpArray[i] = totalTimes value (i+1) repeated.
 *       4. Time and Space complexity o(n)
 *
 * Algo2 :
 *
 *       0. This is inplace replacement method.
 *              Overal logic is :
 *                  say a = 5;
 *                  add 9 3 times to 5
 *                  value becomes 5 + 9*3 = 32;
 *                  divide 32 by 9 you get 3(total times 9 added)
 *                  module of 32 by 9 u get 5 (original value)
 *       1. reduce all values in input array by 1. So that all values will be in the range of 0 to n-1.
 *       2. traverse array from i = 0 to n-1 and mark input[i % n]  = input[i % n] + n
 *       3. Above step will increment index by max n value.
 *       4. Say 5 is repeated 3 times in array of size 7 then value at index 4 will be existingValue + 3 * 7;
 *       5. With respect to step 5 , totalOccurance = totalValue / 7 and originalValue = totalOccurance % 7 + 1
 */
public class FrequencyOfElementInArray {

    public static void main(String[] args) {
        new FrequencyOfElementInArray().run();
    }

    private void run() {
        System.out.println("bc".substring(0));
        int []input = {1,4,5,2,6,2,5,3,2,5}; //Array of 10. so n = 10

        //Step1 : reduce value of each element by 1 so that values will be from 0 to n-1 i.e. 0 to 9, this is for simplicity.
        for(int i = 0; i < input.length; i++) {
            input[i] = input[i] - 1;
        }

        //Step2 : Traverse array and add 10 to each index value.

        for(int i = 0; i < input.length; i++) {
            int currentIndexValue = input[i] % input.length; //(Modulo value as 10 to this index location might have been added due to previous operation.)
            input[currentIndexValue] = input[currentIndexValue] + input.length; //Adding 10 to currentIndexValue.
        }


        //Step3 : Print the values at each location (just by dividing by 10.
        // as occurrence = total times 10 added to this location.)
        //Say at 0th index, 10 is added 2 times, means somewhere 0 occurred 2 times. (0 is due to 1 reduction at step 1)

        for(int i = 0; i < input.length; i++) {
            System.out.println((i+1)+" occured "+(input[i] / input.length)+" times");
        }

        //Step4 : revert back to original input array , we can do this step with step3 too.

        for(int i = 0; i < input.length; i++) {
            input[i] = (input[i] % input.length) + 1;
        }
    }



}
