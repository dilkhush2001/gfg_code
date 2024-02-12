//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int mod=(int)1e9+7;
    int n;
    long sequence(int n){
        this.n=n;
       return help(1L, 1L);
        
    }
    
    long help(long s , long  level){
        if(level>n)return 0;
        
        
        long t=1;
        for(long i=s; i<(s+level);i++){
            t=(t%mod*i)%mod;
        }
        
        return (t+help(s+level, level+1))%mod;
    }
}