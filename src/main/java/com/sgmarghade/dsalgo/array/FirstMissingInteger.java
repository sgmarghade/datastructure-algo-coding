package com.sgmarghade.dsalgo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by swapnil on 30/11/16.
 * https://www.interviewbit.com/problems/first-missing-integer/
 *
 * Replace each index with it's own value. Missing index will be having -ve value.
 * Test cases :
 *
 * 1,1,1 : 2
 *
 *
 *
 */
public class FirstMissingInteger {
    public static void main(String[] args) {
        System.out.println(new FirstMissingInteger().firstMissingPositive(Arrays.asList(-8, -7, -6)));
    }

    private int firstMissingPositive(List<Integer> a) {
        int minValue = Integer.MAX_VALUE;

        //Handling special case of 1 element in array. [1], [-1], [0]
        if(a.size() == 1){
            if(a.get(0) > 0) {
                return a.get(0) + 1;
            }else{
                return 1;
            }
        }

        for(int i = 0; i < a.size();i++){

            int currentValue = a.get(i);
            if(currentValue < minValue){
                minValue = currentValue;
            }

            while(currentValue > 0 && currentValue < a.size() && a.get(currentValue) != currentValue){
                int tmp = a.get(currentValue);
                a.set(currentValue,currentValue);
                currentValue = tmp;
                if(currentValue < minValue){
                    minValue = currentValue;
                }
            }
        }

        for(int i = 1; i < a.size(); i++){
            if(a.get(i) != i){
                return i;
            }
        }
        return minValue == 0 ? a.size() : a.size() + 1; //Handling special case like , [0,1,2] ans = 3 and [1,2,3] and = 4;
    }
}
