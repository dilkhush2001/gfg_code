//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    int[][] dp;
    public int minCoins(int coins[], int sum) {
        // code here
        dp=new int[coins.length][sum+1];
        for(int[] t : dp)Arrays.fill(t, -1);
        int ans=find(coins, sum, 0);
        return ans==(int)1e9+7  ? -1 : ans;
    }
    private int find(int[] coins, int sum, int idx){
        if(idx>=coins.length || sum<0)return (int)1e9+7;
        if(sum==0)return 0;
        if(dp[idx][sum]!=-1)return dp[idx][sum];
        int take=1+find(coins, sum-coins[idx], idx);
        int ntake=find(coins, sum, idx+1);
        return dp[idx][sum]=Math.min(take, ntake);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends