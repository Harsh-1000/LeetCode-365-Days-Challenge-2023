class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost){
        
        int total=0;
        
        int cur=0;
        
        int st=0;
        
        for(int i=0;i<gas.length;i++)
        {
            total = total + (gas[i]-cost[i]);
            cur = cur + (gas[i]-cost[i]);
            
            if(cur<0)
            {
                  st=i+1;
                  cur=0;
            }
              
        }
        
        if(total<0)
            return -1;
        
        return st;
 
    }
}