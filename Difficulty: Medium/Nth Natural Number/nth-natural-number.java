//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            long n = ob.nextLong();
            Solution ab = new Solution();
            long k = ab.findNth(n);
            System.out.println(k);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    long findNth(long n) {
        // code here
        long ans=0;
        long m=1;
        while(n!=0){
            ans+=(n%9)*m;
            n/=9;
            m*=10;
        }
        return ans;
    }
}

// 18
//  n=2 , 2*10=20
// n=20 , n=2;
// n=2   