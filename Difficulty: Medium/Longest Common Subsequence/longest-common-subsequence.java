//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the lcs function with the lengths of the strings as
            // parameters
            System.out.println(obj.lcs(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    int[][] dp;
    public int lcs(String s1, String s2) {
        // code here
        dp=new int[s1.length()+1][s2.length()+1];
        for(int[] t: dp)Arrays.fill(t, -1);
        // for(int i=1;i<=s1.length();i++){
        //     for(int j=1;j<=s2.length();j++){
        //         if(s1.charAt(i-1)==s2.charAt(j-1)){
        //             dp[i][j]=Math.max(dp[i][j], 1+dp[i-1][j-1]);
        //         }
        //         else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
        //     }
            
        // }
        // return dp[s1.length()][s2.length()];
        return find(0, 0, s1, s2);
    }
    private int find(int i, int j, String s1, String s2){
        if(i>=s1.length() || j>=s2.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+find(i+1, j+1, s1, s2);
        }
        return dp[i][j]=Math.max(find(i + 1, j, s1, s2), find(i, j + 1, s1, s2));
    }
    
}