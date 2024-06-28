//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        // Code here
        int n=arr.length;
        for(int i=0;i<n;i++){
            boolean f=false;
            int j=0, k=n-1;
            while(j<k){
                if(arr[i][j]!=arr[i][k]){
                    f=true;
                    break;
                }
                j++;
                k--;
            }
            if(!f)return ""+i+" R";
            
        }
        
        for(int i=0;i<n;i++){
            boolean f=false;
            int j=0, k=n-1;
            while(j<k){
                if(arr[j][i]!=arr[k][i]){
                    f=true;
                    break;
                }
                j++;
                k--;
            }
            if(!f)return ""+i+" C";
            
        }
        return "-1";
    }
    // private boolean isPalidrome(String s){
    //     int i=0, j=s.length()-1;
    //     while(i<j){
    //         if(s.charAt(i)!=s.charAt(j))return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
}
