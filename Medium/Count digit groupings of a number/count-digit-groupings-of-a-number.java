//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int[][] dp;
    public int TotalCount(String str)
    {
        dp=new int[str.length()][1000];
        for(int[] temp : dp)Arrays.fill(temp, -1);
        return dfs(str, 0, 0);
    }
    int dfs(String s, int idx , int preSum){
        if(idx==s.length())return 1;
        if(dp[idx][preSum] !=-1)return dp[idx][preSum];
        int sum=0, count=0;
        for(int i=idx;i<s.length();i++){
            sum+=(s.charAt(i)-'0');
            if(preSum<=sum){
                count+=dfs(s, i+1, sum);
            }
        }
        return dp[idx][preSum]=count;
    }
}