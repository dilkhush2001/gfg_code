//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n=mat.length;
        // code here
        for(int i=0;i<n;i++){
            int s1=0, s2=0;
            for(int j=0;j<n;j++){
                if(i==j)continue;
                s1+=mat[i][j];
                s2+=mat[j][i];
            }
            if(s2==n-1 && s1==0)return i;
        }
        return -1;
    }
}