package com.company;

import java.util.List;
import java.util.TreeMap;

class Solution2 {
    //For problem 347: Most frequent K elements

    private class Freq implements Comparable<Freq> {
        public int e;
        public int freq;

        public Freq(int e,int freq)
        {
            this.e=e;
            this.freq=freq;
        }

        @Override
        public int compareTo(Freq another)
        {
            if (this.e<another.e)
                return 1;
            if(this.e>another.e)
                return -1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer,Integer> freqMap=new TreeMap<>();
        for(int num:nums)
        {
            if(freqMap.containsKey(num))
                freqMap.put(num,freqMap.get(num)+1);
            else
                freqMap.put(num,1);
        }


    }
}