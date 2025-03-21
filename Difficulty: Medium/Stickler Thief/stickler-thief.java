//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int[] dp;
    public int findMaxSum(int arr[]) {
        // code here
        dp=new int[arr.length];
        Arrays.fill(dp, -1);
        return find(arr, 0);
        
    }
    private int find(int[] arr, int idx){
        if(idx>=arr.length)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int take=arr[idx]+find(arr, idx+2);
        int ntake=find(arr, idx+1);
        return dp[idx]=Math.max(take, ntake);
    }
}