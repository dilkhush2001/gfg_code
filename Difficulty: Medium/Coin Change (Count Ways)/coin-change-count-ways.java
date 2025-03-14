//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int[][] dp;
    public int count(int coins[], int sum) {
        // code here.
        dp=new int[coins.length+1][sum+1];
        for(int[] t : dp)Arrays.fill(t, -1);
        return find(0, coins, sum);
    }
    private int find(int idx, int[] coins, int sum){
        if(idx>=coins.length || sum<0)return 0;
        if(sum==0)return 1;
        if(dp[idx][sum]!=-1)return dp[idx][sum];
        int take=find(idx, coins, sum-coins[idx]);
        int ntake=find(idx+1, coins, sum);
        return dp[idx][sum]= take+ntake;
    }
}