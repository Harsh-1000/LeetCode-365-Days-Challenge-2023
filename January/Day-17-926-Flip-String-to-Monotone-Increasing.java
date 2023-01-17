class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int m=0;
        int n= s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0')
               m++;
        }
        
        int ans=m;
        
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                m--;
                ans = Math.min(ans,m);
            }
            else m++;
        }
        
        return ans;
        
    }
}
