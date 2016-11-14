package com.sgmarghade.dsalgo.dp;

import java.util.Scanner;

/**
 * Created by swapnil on 14/11/16.
 * Given an array arr[] consisting of 0’s and 1’s. A flip operation is one in which you turn 1 into 0 and a 0 into 1.You have to do atmost one “Flip” operation on a subarray. Then finally display maximum number of 1 you can have in the array.

 Input:

 First line of input consist of a single integer T denoting the total number of test case.First line of test case contains an integer N.Second line of test case contains N space separated integers denoting the array arr[].


 */
public class FlipBits {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);

        int totalTestCases = scan.nextInt();
        while(totalTestCases > 0){
            int totalInput = scan.nextInt();
            printResult(totalInput,scan);
            totalTestCases--;
        }


    }

    private static void printResult(int totalInput,Scanner scan) {
        int[] array = new int[totalInput];
        for(int i = 0; i< totalInput; i++){
            array[i] = scan.nextInt();
        }

        int total1s = 0;
        for(int i = 0; i< array.length; i++){
            if(array[i] == 1){
                total1s++;
            }
        }

        int currentPositive = 0;
        int previousPositive = 0;

        for(int i =0; i< array.length; i++){
            if(array[i] == 0){
                currentPositive++;
            }else{
                currentPositive--;
            }

            if(currentPositive < 0){
                currentPositive = 0;
            }


            if(currentPositive > previousPositive){
                previousPositive = currentPositive;
            }
        }

        System.out.println(total1s+previousPositive);
    }
}
