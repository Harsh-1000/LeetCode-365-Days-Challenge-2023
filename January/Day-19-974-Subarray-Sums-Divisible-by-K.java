class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int sum=0;
        
        int[] freq = new int[k];
        
        freq[0]=1;
        
        for(int i=0;i<nums.length;i++){
            
            sum += nums[i];
            
            int idx = sum%k;
            
            if(idx<0){
                idx = idx + k;
            }
            
            freq[idx]++;
            
        }
        
        int ans = 0;
        
        for(int i=0;i<k;i++){
            if(freq[i]>1){
                ans += ((freq[i])*(freq[i]-1))/2;
            }
        }
        
        return ans;
        
    }
}