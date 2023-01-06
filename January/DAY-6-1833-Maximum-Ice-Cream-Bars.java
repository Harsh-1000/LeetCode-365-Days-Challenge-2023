class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        Arrays.sort(costs);
        int sum=0;
        int count=0;
        for(int x: costs){
            if(sum+x<=coins){
                count++;
                sum+=x;
            }
        
        }
        
        return count;
        
        
    }
}