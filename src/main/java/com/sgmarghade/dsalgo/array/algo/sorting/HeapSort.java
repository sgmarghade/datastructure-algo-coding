package com.sgmarghade.dsalgo.array.algo.sorting;

import java.util.Arrays;

/**
 * We will use array to represent heap.
 * We have to create max heap before we start sorting.
 * Max heap can be created by running heapify process on every element from bottom to up.
 * Once max heap is created, move max element from top to bottom and bottom element from to top and reduce heap size
 * and run heapify process.
 * This will move right element to top.
 * <p>
 * Run same process till heap size is 0.
 * TimeCOmplexity : O(n log(n))
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] input = new int[]{4, 9, 2, 3, 5, 7, 1, 6};

        new HeapSort().buildMaxHeap(input);

        System.out.println("Max heap array" + Arrays.toString(input));

        //we can sort from here now.

        //Swap bottom and top element and run heapify on top swapped element with reduced heapSize.
        int currentHeapSize = input.length;

        for(int i = input.length - 1; i > 0; i--) {
           int tmp = input[0];
           input[0] = input[currentHeapSize - 1];
           input[currentHeapSize - 1] = tmp;  //Biggest element moved to bottom.

           new HeapSort().heapify(input, 0, --currentHeapSize); //This will move big element at top.
        }


        System.out.println("Sorted Array : " + Arrays.toString(input));
    }

    private void buildMaxHeap(int[] input) {
        for (int i = input.length - 1; i >= 0; i--) {
            heapify(input, i, input.length);
        }
    }

    private void heapify(int[] input, int currentIndex, int heapSize) {

        int leftIndex = 2 * currentIndex + 1;
        int rightIndex = 2 * currentIndex + 2;
        int largeValueIndex = currentIndex;

        if (leftIndex < heapSize && input[largeValueIndex] < input[leftIndex]) {
            largeValueIndex = leftIndex;
        }

        if (rightIndex < heapSize && input[largeValueIndex] < input[rightIndex]) {
            largeValueIndex = rightIndex;
        }

        if (largeValueIndex != currentIndex) {
            int largeValue = input[largeValueIndex];
            input[largeValueIndex] = input[currentIndex];
            input[currentIndex] = largeValue;

            //As current index value is swapped continue heapify process.
            heapify(input, largeValueIndex, heapSize);
        }
    }

}
