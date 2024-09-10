//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isCircle(String arr[]) {
        // code here
        int[] inDeg=new int[26];
        int[] outDeg=new int[26];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        
        for(String s: arr){
            int u=s.charAt(0)-'a';
            int v=s.charAt(s.length()-1)-'a';
            
            adj.get(u).add(v);
            outDeg[u]++;
            inDeg[v]++;
        }
        for(int i=0;i<26;i++){
            if(inDeg[i]!=outDeg[i])return 0;
        }
        boolean[] vis=new boolean[26];
        
        dfs(arr[0].charAt(0)-'a', adj, vis);
        for(int i=0;i<26 ;i++){
            if(outDeg[i]>0 && !vis[i])return 0;
        }
        return 1;
    }
    private void dfs(int node , List<List<Integer>> adj , boolean[] vis){
        vis[node]=true;
        for(int v : adj.get(node)){
            if(!vis[v]){
                dfs(v, adj, vis);
            }
        }
    }
}