//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
     ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        boolean[] vis=new boolean[n];
        Collections.sort(arr);
        helper(arr, new ArrayList<Integer>() , vis, n);
        return ans;
        
    
    }
    private void helper(ArrayList<Integer> arr, ArrayList<Integer> curr, boolean[] vis, int n){
        if(curr.size()==n){
            ans.add(new ArrayList<>(curr));
        }
        for(int i=0;i<n;i++){
            if(vis[i] || (i>0 && arr.get(i)==arr.get(i-1) && !vis[i-1]))continue;
            vis[i]=true;
            curr.add(arr.get(i));
            helper(arr, curr, vis, n);
            curr.remove(curr.size()-1);
            vis[i]=false;
        }
    }
};