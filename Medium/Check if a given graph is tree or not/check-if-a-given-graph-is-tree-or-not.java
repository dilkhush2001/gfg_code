//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public boolean solve(ArrayList<ArrayList<Integer>> graph,boolean[] vis,int prev,int vertex){
        vis[vertex]=true;
        for(int i:graph.get(vertex))
        if(i==prev)
        continue;
        else
        if(!vis[i])
        {if(!solve(graph,vis,vertex,i))
        return false;}
        else return false;
        return true;
    }
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // code here
        boolean vis[]=new boolean[n];
        //Set<Integer> set=new HashSet<Integer>();
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList());
        }
        for(int i=0;i<m;i++){
            graph.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            graph.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        if(!solve(graph,vis,-1,0))
        return false;
        for(boolean i:vis)
        if(!i)
        return false;
        return true;

        
    }
}

