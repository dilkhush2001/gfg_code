//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends




// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    final  int[] dx={1,-1,0,0};
    final  int[] dy={0,0,1,-1};
    final  char[] idx={'R','L','D','U'}; 
    ArrayList<String> ans=new ArrayList<String>();
    public  ArrayList<String> findPath(int[][] m ) {
        int n=m.length;
        if(m[0][0]==0)
            return ans;
        boolean[][] visited=new boolean[n][n];
        visited[0][0]=true;
        helper(m, n, 0,0,"", visited);
        
        return ans;
    }
    private void helper(int[][] mat, int n , int row, int col, String s, boolean[][] visited){
        if(row==n-1 && col==n-1){
            ans.add(s);
            return ;
        }
        for(int i=0;i<4;i++){
            int ncol=col+dx[i];
            int nrow=row+dy[i];
            if(nrow>=0 && ncol>=0 && nrow<n  && ncol<n && mat[nrow][ncol]==1 && !visited[nrow][ncol]){
                visited[nrow][ncol]=true;
                helper(mat,n, nrow, ncol, s+idx[i], visited);
                visited[nrow][ncol]=false;
            }
        }
        
       
    }
}