// Approach and Explanation


// => This code is solving the problem of finding the minimum time required to collect all apples in a given tree. The tree is represented by a list of edges, where each edge connects two nodes, and a list of booleans that indicates whether each node has an apple or not.

// => The main function "minTime" takes in 3 arguments:

//      1. n: number of nodes in the tree
//      2. edges: a 2D array representing the edges of the tree
//      3. hasApple: a list of booleans indicating whether each node has an apple or not.


// It starts by creating an adjacency list representation of the tree from the given edges. An adjacency list is a data structure that is used to represent a graph, where each element of the list represents a node of the graph and contains a list of the nodes it is connected to.

//      => Then it calls the helper function "minTimeToCollectApples" which takes four arguments:

//            1. index: the current node being processed
//            2. adj: the adjacency list representation of the tree
//            3. hasApple: a list of booleans indicating whether each node has an apple or not
//            4. parent: the parent of the current node


// The function starts by initializing a variable "total" to zero. It then iterates over all the neighbors of the current node (excluding the parent) and recursively calls the function on each of the neighbors. This way it explores all the path from the current node to all the children nodes.

// Then, if the current node is not the root of the tree and it has an apple or any of its children has an apple, it adds 2 to the "total" variable as this represent that we need to take 2 steps: one step to reach the apple and one step back to the parent.

// Finally, it returns the "total" variable.

class Solution {
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        // Create an adjacency list to represent the tree
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        //populate the adjancy list
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        return collectApple(0,adj,hasApple,0);
        
    }
    
    private int collectApple(int index, List<List<Integer>> adj, List<Boolean> hasApple, int parent){
        int total =0;
        
        for(int nbr: adj.get(index)){
            if(nbr==parent) continue;
            
            total += collectApple(nbr,adj,hasApple,index);
        }
        
        if(index!=0 && (hasApple.get(index) || total>0))
            total +=2;
        
        return total;
}
}