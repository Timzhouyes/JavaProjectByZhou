class NumArray2 {


    //LeetCode 303 another solution: use predefinition 

    private int[] sum;

    public NumArray2(int[] nums) {
        if(nums.length==0)
            throw new IllegalArgumentException("Empty Array");
        sum= new int[nums.length];

        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++)
            sum[i]=nums[i]+sum[i-1];

    }

    public int sumRange(int i, int j) {
        if(sum==null)
            throw new IllegalArgumentException("Empty array");

        if(i==0)
            return sum[j];

        return sum[j]-sum[i-1];
    }

}