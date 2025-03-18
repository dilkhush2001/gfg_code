//{ Driver Code Starts
// Initial Template for Java

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

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
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
    public boolean equalPartition(int arr[]) {
        // code here
        int tot=0;
        for(int ele : arr)tot+=ele;
        if(tot%2!=0)return false;
        dp=new Boolean[arr.length][tot/2+1];
        return find(arr, 0, 0, tot);
    }
    private Boolean find(int[] arr, int idx, int curr, int tot){
        if(idx>=arr.length || curr>tot/2)return false;
        if(tot/2==curr)return true;
        if(dp[idx][curr]!=null)return dp[idx][curr];
        return dp[idx][curr]=find(arr, idx+1, curr+arr[idx], tot) | find(arr, idx+1, curr, tot);
    }
}