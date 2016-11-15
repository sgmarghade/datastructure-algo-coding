package com.sgmarghade.dsalgo.array;

import java.util.*;

/**
 * Created by swapnil on 15/11/16.
 * Input :
 * Arrivals :   [1 3 5]
 * Departures : [2 6 8]
 * K : 1 //Total rooms
 *
 * return false, At day = 5, there are 2 guests in the hotel. But I have only one room.
 */
public class HotelBookingsPossible {
    public static void main(String[]args){
        System.out.println(new HotelBookingsPossible().hotel(Arrays.asList(13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8),Arrays.asList(28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53),23));
    }

    public boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {

        Collections.sort(arrive);

        Collections.sort(depart);


        int currentRoomRequired = 1;
        int arriveIndex = 1;
        int departIndex = 0;
        int arriveLastValue = arrive.get(0);

        while (arriveIndex < arrive.size() && departIndex < depart.size()) {
            while (arriveIndex < arrive.size() && arrive.get(arriveIndex) < depart.get(departIndex) ) {
                arriveLastValue = arrive.get(arriveIndex);
                currentRoomRequired++;
                arriveIndex++;
            }
            if(currentRoomRequired > K){
                return false;
            }

            //
            if(arriveIndex < arrive.size()){
                arriveLastValue = arrive.get(arriveIndex);
            }

            while(departIndex < depart.size() && depart.get(departIndex) <= arriveLastValue){
                currentRoomRequired--;
                departIndex++;
            }
        }

        return true;
    }
}
