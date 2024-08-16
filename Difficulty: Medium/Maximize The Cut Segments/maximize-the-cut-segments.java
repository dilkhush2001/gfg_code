//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    
    int[] dp;
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
        dp=new int[6000];
        Arrays.fill(dp, -1);
        int ans=find(n, x, y, z);
        return ans<0 ? 0 :ans;
    }
    private int find(int n, int x, int y, int z){
        if(n<=0)return 0;
        if(dp[n]!=-1)return dp[n];
        int x1= n>=x ? find(n-x, x, y, z) :-(int)1e9;
        int y1=n>=y ? find(n-y, x, y, z): -(int)1e9;
        int z1=n>=z ? find(n-z, x,y, z) : -(int)1e9;
        return dp[n]=Math.max(x1, Math.max(y1, z1))+1;
    }
}
