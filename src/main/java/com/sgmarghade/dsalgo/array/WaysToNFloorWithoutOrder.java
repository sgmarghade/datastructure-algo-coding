package com.sgmarghade.dsalgo.array;

import java.util.Scanner;

/**
 * Created by swapnil on 20/11/16.
 * There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does not matter). Order does not matter means for n=4 {1 2 1},{2 1 1},{1 1 2} are considered same.
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=158
 *
 */
public class WaysToNFloorWithoutOrder {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int totalTestCases = scan.nextInt();
        for(int i = 0 ; i < totalTestCases; i++){
            int totalFloors = scan.nextInt();

            int ways = 1;
            while(totalFloors - 2 >= 0){
                ways++;
                totalFloors -= 2;
            }
            System.out.println(ways);
        }
    }

}
