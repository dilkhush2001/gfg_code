//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int n=arr.length , m=arr[0].length;
        int max=Integer.MIN_VALUE;
        int ans=-1,c=0;
        for(int i=0;i<n;i++){
             c=0;
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    c++;
                    if(c>max){
                        max=c;
                        ans=i;
                    }
                }
            }
        }
        return ans;
    }
    
}

