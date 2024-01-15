//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int result = solution.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    int[][] dp;
    public int max_courses(int n, int total, int[] cost) {
        dp=new int[n+1][total+1];
        for(int temp[] :dp)Arrays.fill(temp,-1);
        return dfs(n, total, cost, 0);
    }
    private int dfs(int n , int total , int[] cost, int i){
        if(i>=n)return 0;
        if(dp[i][total]!=-1)return dp[i][total];
        if(total>=cost[i]){
            return dp[i][total]=Math.max(dfs(n, total-(cost[i]-(9*cost[i])/10), cost, i+1)+1, dfs(n, total, cost, i+1) );
        }
        return  dp[i][total]=dfs(n, total, cost, i+1);
        
    }
}

