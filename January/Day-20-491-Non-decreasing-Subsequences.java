class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        
        find(nums,ans,list,0);
        
        for(List<Integer> listu: dummy)
        {
            ans.add(listu);
        }
        return ans;
    }
    
     HashSet<List<Integer>> dummy = new HashSet<>();
    
    private void find(int[] nums, List<List<Integer>> ans, List<Integer> list,int start){
        
        if(list.size()>=2){
            dummy.add(new ArrayList<>(list));
        }
        
        if(start>=nums.length)
            return;
        
        for(int i=start;i<nums.length;i++){
            
            if(list.size()!=0 && nums[i]<list.get(list.size()-1))
                    continue;
            
            list.add(nums[i]);
            
            find(nums,ans,list,i+1);
            
            list.remove(list.size()-1);
            
        }
    }
}