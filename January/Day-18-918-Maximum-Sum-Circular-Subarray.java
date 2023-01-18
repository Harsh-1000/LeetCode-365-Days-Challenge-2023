class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int cur=nums[0];
        int max=nums[0];
        int min=nums[0];
        
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            cur= Math.max(cur+nums[i],nums[i]);
            max =Math.max(cur,max);
        }
        cur=nums[0];
        
        for(int i=1;i<n;i++)
        {
            cur =Math.min(cur+nums[i],nums[i]);
            min =Math.min(cur,min);
        }
        
        int sum=0;
        
        for(int i=0;i<n;i++)
            sum += nums[i];
        
        if(min==sum)
            return max;
        
        return Math.max(sum-min,max);
        
        
        
    }
}
