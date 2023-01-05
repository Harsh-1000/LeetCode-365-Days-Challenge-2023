class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int arrow =1;

        int y = points[0][1];

        for(int i=1;i<points.length;i++){

            int x = points[i][0];
            if(x>y){
                arrow++;
                y = points[i][1];
            }
            else y = Math.min(y, points[i][1]);
        }

        return arrow;

       
    }
}