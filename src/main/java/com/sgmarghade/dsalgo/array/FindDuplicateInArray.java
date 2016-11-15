package com.sgmarghade.dsalgo.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by swapnil on 15/11/16.
 */
public class FindDuplicateInArray {
    public int repeatedNumber(final List<Integer> a) {
        Set<Integer> set = new HashSet<Integer>();
        for(Integer data : a){
            if(set.contains(data)){
                return data;
            }else{
                set.add(data);
            }
        }
        return -1;
    }
}
