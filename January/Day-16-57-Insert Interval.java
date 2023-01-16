class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = intervals.length;
        int a = newInterval[0];
        int b = newInterval[1];
        
        boolean flag= true;
        
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(a);
        l1.add(b);
       
        for(int i=0;i<n;i++){
           ArrayList<Integer> l = new ArrayList<>();
            l.add(intervals[i][0]);
            l.add(intervals[i][1]);
            list.add(l);
        }
        
        
        
        for(int i=0;i<n;i++){
            int x1 = list.get(i).get(0);
            if(a<=x1)
            {
                list.add(i,l1);
                flag=false;
                break;
            }
        }
        
        
        if(list.size()==0 || flag)
            list.add(l1);
       
        
        
        
        
        
        
        
        
         
        merge(list);
    
        int[][] ans = new int[list.size()][2];
    
        for(int k=0;k<ans.length;k++)
        {
            ans[k][0]=list.get(k).get(0);
            ans[k][1]=list.get(k).get(1);
        }
        
        return ans;
        
    }
    
    private void merge(ArrayList<ArrayList<Integer>> res){
       
        
        int i=0;
         while(i<res.size()-1){
            int x1 = res.get(i).get(0);
            int y1 = res.get(i).get(1);
            int x2 = res.get(i+1).get(0);
            int y2 = res.get(i+1).get(1);

            if(x2<=y1){
                ArrayList<Integer> list = res.get(i);
                list.set(0,Math.min(x1,x2));
                list.set(1,Math.max(y1,y2));
                res.remove(i+1);
            }
            else
                i++;
        }
        
        
        


    }
}
