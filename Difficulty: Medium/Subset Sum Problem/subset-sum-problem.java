//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    Boolean[][] dp;
    public boolean isSubsetSum(int arr[], int sum) {
        dp=new Boolean[arr.length][sum+1];
        return find(arr, 0, sum);
        
    }
    private Boolean find(int arr[] , int idx, int sum){
        if(sum==0)return true;
        if(idx>=arr.length || sum<0)return false;
        if(dp[idx][sum]!=null)return dp[idx][sum];
        return dp[idx][sum]=find(arr, idx+1, sum-arr[idx])| find(arr, idx+1, sum);
    }
}