package com.sgmarghade.dsalgo.array.algo.sorting;

import java.util.Arrays;

/**
 * Merge sort is Divide and concure type of sorting algorithm.
 * Space Complexity : O(n) : we do copy elements to tmpArray
 * TimeComplexity : O(nlog(n))
 *
 * Consider middle element and divide array.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] input = new int[] {3,1,3,5,6,2};
        new MergeSort().mergeSort(input, 0, input.length - 1 );

        System.out.println("Sorted array is " );
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }

    }

    private void mergeSort(int[] inputs, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;  //Floor value of division.
            mergeSort(inputs, start, mid);   //We are dividing.
            mergeSort(inputs, mid + 1, end);

            merge(inputs, start, mid, end);  //1st time merge will be called with single value array.
        }
    }

    private void merge(int[] inputs, int start, int mid, int end) {


            int[] leftArray = new int[mid - start + 1];  //This is just size.
            int[] rightArray = new int[end - mid];  //This is size (end-mid) index will start from mid+1

            //Copy data to temp array.
            for(int i = 0; i < leftArray.length; i++) {
                leftArray[i] = inputs[i + start];
            }

            //Copy data to tmp array.
            for(int i = 0 ; i < rightArray.length; i++) {
                rightArray[i] = inputs[i + mid + 1];
            }

            int rightArrayIndex = 0;
            int leftArrayIndex = 0;

            //Basic comparison of sorted array and copying element to existing array.
            for(int currentInputIndex = start; currentInputIndex <= end; currentInputIndex++) {
                if(rightArrayIndex >= leftArray.length) {
                    //Coppy all leftArrayIndex elements.
                    inputs[currentInputIndex] = rightArray[leftArrayIndex];
                    leftArrayIndex++;
                }else if(leftArrayIndex >= rightArray.length) {
                    //Copy all rightArrayIndex elements
                    inputs[currentInputIndex] = leftArray[rightArrayIndex];
                    rightArrayIndex++;

                }else if(leftArray[rightArrayIndex] < rightArray[leftArrayIndex]) {
                    inputs[currentInputIndex] = leftArray[rightArrayIndex];
                    rightArrayIndex++;
                }else {
                    inputs[currentInputIndex] = rightArray[leftArrayIndex];
                    leftArrayIndex++;
                }
            }
    }
}
