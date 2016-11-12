package com.sgmarghade.dsalgo;

/**
 * Created by swapnil on 11/11/16.
 * Given a point on x axis, (N,0), you are standing at origin and you can only move on x-axis. Lets say you are at (x,0), at each step you can either move one step forward ie (x+1,0) or one step backwards (x-1,0) or make a jump to double your current position (2*x,0). One step movement costs you A while a jump costs you B. If your initial position is (0,0) , find the minimum cost to reach (N,0) .
 * Input N A B
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=1388
 */

public class OptimalWalk {
    public static void main(String[] args) {
//        args = new String[]{"7", "1", "100"};
        int N = new Integer(args[0]);
        int A = new Integer(args[1]);
        int B = new Integer(args[2]);
        int[] valueMarker = new int[N+1];
        for(int i = 0 ; i < valueMarker.length; i++){
            valueMarker[i]=Integer.MAX_VALUE;
        }
       new OptimalWalk().checkForCost(0, A, B, N, valueMarker,0);
       System.out.println(valueMarker[N]);
    }

    private int checkForCost(int currentIndex, int a, int b, int n, int[] valueMarker,int prevValue) {

        int nextStepValue =Integer.MAX_VALUE;
        int prevStepValue = Integer.MAX_VALUE;
        int jumpStepValue = Integer.MAX_VALUE;

        if(currentIndex + 1 <= n && prevValue + a < valueMarker[currentIndex+1] ){
            valueMarker[currentIndex+1] = prevValue + a;
            nextStepValue = checkForCost(currentIndex+1,a,b,n,valueMarker,prevValue + a);
        }

        if(currentIndex - 1 >= 0 && prevValue + a < valueMarker[currentIndex - 1]){
            valueMarker[currentIndex - 1] = prevValue + a;
            prevStepValue = checkForCost(currentIndex -1,a,b,n,valueMarker,prevValue+a);
        }

        if(currentIndex * 2 <= n && prevValue + b < valueMarker[currentIndex*2]){
            valueMarker[currentIndex*2] = prevValue + b;
            jumpStepValue = checkForCost(currentIndex*2,a,b,n,valueMarker,prevValue+b);
        }

        return Math.min(Math.min(nextStepValue,prevStepValue),jumpStepValue);

    }

}
