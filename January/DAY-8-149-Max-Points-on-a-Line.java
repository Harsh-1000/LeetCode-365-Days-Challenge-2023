// Approach and Explantation

// 1. It does this by iterating through every combination of two points (i and j) in the input array of points and then checks every other point (k) to see if it is collinear with i and j.

// 2. To determine if three points are collinear, the code calculates the slope between point i and point j, and then compares it to the slope between point i and point k. If the slopes are equal, then the three points are collinear.

// 3. The slope between two points (x1, y1) and (x2, y2) is calculated as (y2 - y1) / (x2 - x1).Let suppose we have three points (x1, y1),(x2, y2) and (x3, y3) and compare the two slopes then expression is written in this formet(y2 - y1) * (x3 - x1) = (y3 - y1) * (x2 - x1) similarly In this code, this calculation is broken down into two separate parts: (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]) and (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]). The reason for this is to avoid a division by zero error in cases where the two points have the same x-coordinate.

// 4. If the code determines that three points i, j, and k are collinear, it increments a temporary count variable temp. After checking every point k, the code compares temp to the current maximum number of collinear points found so far, ans, and updates ans if temp is larger.

// 5. Finally, the code returns the maximum number of collinear points, ans.

class Solution {
    public int maxPoints(int[][] points) {
        
        int max = 2;
        int n = points.length;
        
        if(n<=2)
            return n;
        
        for(int i=0;i<n;i++){    
            for(int j=i+1;j<n;j++){
                
               int total =2;
                
                for(int k=0;k<n;k++){
                    
                    if(k!=i && k!=j && slope(points[i],points[j],points[k]))
                        total++;
        
                }
                 max = Math.max(max,total);
            }
           
        }
        
        return max;
        
    }
    
    private boolean slope(int[] p1, int[] p2, int[] p3)
    {
        int x1 = p1[0];
        int y1 = p1[1];
        
        int x2 = p2[0];
        int y2 = p2[1];
        
        int x3 = p3[0];
        int y3 = p3[1];
        
        return (y2-y1)*(x3-x1)==(y3-y1)*(x2-x1);
    }
}