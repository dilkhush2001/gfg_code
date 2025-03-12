//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.minCostClimbingStairs(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    int[] dp;
     int minCostClimbingStairs(int[] cost) {
        // Write your code here
        dp=new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(find(cost, 0), find(cost, 1));
    }
    private  int find(int[] cost, int idx){
        if(idx>=cost.length)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int take=cost[idx]+find(cost, idx+1);
        int ntake=cost[idx]+find(cost, idx+2);
        return dp[idx]=Math.min(take, ntake);
    }
};