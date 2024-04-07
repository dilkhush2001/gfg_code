//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int m = sc.nextInt();
                    int a[] = new int[n];
                    int b[] = new int[m];
                    for(int i = 0;i<n;i++)
                        a[i] = sc.nextInt();
                    for(int i = 0;i<m;i++)
                        b[i] = sc.nextInt();    
                    Solution ob = new Solution();
                    System.out.println(ob.maxDotProduct(n, m, a, b));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int n, m;
    int[][] dp;
	public int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
	    this.n=n;
	    this.m=m;
	    dp=new int[n][m];
	    for(int[] temp : dp)Arrays.fill(temp, -1);
		// Your code goes here
		return find(0, 0, a, b);
	} 
	
	private int find(int i , int j, int[] a, int[] b){
	    if(j==m)return 0;
	    if(i==n)return Integer.MIN_VALUE;
	    if(dp[i][j]!=-1)return dp[i][j];
	    int take=a[i]*b[j]+find(i+1, j+1, a, b);
	    int notTake=find(i+1, j, a, b);
	    return dp[i][j]=Math.max(take, notTake);
	}
}
