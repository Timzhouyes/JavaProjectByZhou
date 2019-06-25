package com.company;

public class Main {

    public static void main(String[] args) {

        int[] intArr={-2,0,3,-5,2,-1};
        int[] intTest={};

         com.company.NumArray obj = new com.company.NumArray(intTest);
         obj.update(3,6);
         int param_2 = obj.sumRange(1,5);
    }
}
