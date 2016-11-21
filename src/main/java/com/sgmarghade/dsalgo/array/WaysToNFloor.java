package com.sgmarghade.dsalgo.array;

import java.util.Scanner;

/**
 * Created by swapnil on 20/11/16.
 * There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top .
 * http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 *
 */
public class WaysToNFloor {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int totalTestCases = scan.nextInt();
        for(int i = 0 ; i < totalTestCases; i++){
            int[] floors = new int[scan.nextInt()];
            floors[floors.length - 1] = 1;
            if(floors.length >= 2){
                floors[floors.length - 2] = 2;
            }
            if(floors.length >= 3){
                floors[floors.length - 3] = 3;
            }

            new WaysToNFloor().run(floors,floors.length - 4);
            if(floors.length == 1) {
                System.out.println(1);
            }else {
                System.out.println(floors[0]);
            }

        }
    }

    private void run(int[] floors,int currentIndex) {
        if(currentIndex < 0 ){
            return;
        }
        floors[currentIndex] = floors[currentIndex+1] + floors[currentIndex+2];
        run(floors,currentIndex-1);
    }
}
