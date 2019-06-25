package com.company;

class NumArray {


    //LeetCode 303 another solution: use predefinition

    private int[] sum;
    private int[] data;

    // 即sum[i]存储nums[0...i-1]的和
    // sum(i, j) = sum[j + 1] - sum[i]
    public NumArray(int[] nums) {
        data=new int[nums.length];
        for(int i=0;i<nums.length;i++)
            data[i]=nums[i];
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1 ; i < sum.length ; i ++)
            sum[i] = sum[i - 1] + nums[i - 1];
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public void update(int i ,int val)
    {
        if(sum==null)
            throw new IllegalArgumentException("Empty array");
        data[i]=val;

        for(int j=i;j<sum.length;j++)
            sum[j+1]=data[j]+sum[j];
    }



}