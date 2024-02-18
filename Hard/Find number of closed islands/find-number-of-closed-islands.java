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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    boolean[][] vis;
    boolean flag=false;
    public int closedIslands(int[][] mat, int N, int M)
    {
        // Code here
        int c=0;
        vis=new boolean[N][M];
        for(int i=1;i<N-1;i++){
            for(int j=1;j<M-1;j++){
                if(mat[i][j]==1 && !vis[i][j]){
                    flag=false;
                    heleper(i, j, mat, N, M);
                    if(!flag)
                        c++;
                }
            }
        }
        return c;
    }
    private void heleper(int i, int j, int[][] mat, int N, int M){
        
        if(i<0 || j<0 || i==N || j==M || mat[i][j]==0 || vis[i][j])
            return;
        if(i==0 || j==0 || i==N-1 || j==M-1)
            flag=true;
        vis[i][j]=true;
        heleper(i+1, j, mat, N, M);
        heleper(i-1, j, mat, N, M);
        heleper(i, j+1, mat, N, M);
        heleper(i, j-1, mat, N, M);
    }
}