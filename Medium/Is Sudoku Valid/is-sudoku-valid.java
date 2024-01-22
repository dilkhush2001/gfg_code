//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    static int isValid(int mat[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(mat[i][j]!=0 && !isSafe(mat, i, j, mat[i][j]))return 0;
            }
        }
        return 1;
        
        
    }
    // private static boolean helper(int[][] mat, int row, int col){
    //     if(row==mat.length)
    //         return true;
    //     int nrow=0,ncol=0;
    //     if(col!=mat.length-1){
    //         nrow=row;
    //         ncol=col+1;
    //     }
    //     else{
    //         nrow=row+1;
    //         ncol=0;
    //     }
        
    //     if(mat[row][col]!=0){
    //         if(helper(mat, nrow, ncol))
    //             return true;
    //     }
    //     else{
    //         for(int i=1;i<=9;i++){
    //             if(isSafe(mat, row, col, i)){
    //                 mat[row][col]=i;
    //                 if(helper(mat,nrow, ncol )){
    //                     return true;
    //                 }
    //                 else{
    //                     mat[row][col]=0;
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    // }
    private static boolean isSafe(int[][] mat, int row, int col, int num){
        for(int i=0;i<mat.length;i++){
            if(mat[row][i]==num && i!=col)
                return false;
            if(mat[i][col]==num && i!=row)
                return false;
        }
        int sr=(row/3)*3, sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(mat[i][j]==num && i!=row && j!=col)
                    return false;
            }
        }
        return true;
    }
}