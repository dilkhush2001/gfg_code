//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    long[][] dp;
    public long count(int n) {
        dp=new long[3][n+1];
        for(int i=0;i<3;i++)
            Arrays.fill(dp[i], -1);
        
       return helper(n, 0);
    }
    int[] arr=new int[]{3, 5, 10};
    private long helper(int n, int idx){
        if(n==0)return 1L;
        if(dp[idx][n]!=-1)return dp[idx][n];
        long t=0;
        for(int i=idx; i<3;i++){
            if(n-arr[i]>=0)
                t+=helper(n-arr[i], i);
        }
        return dp[idx][n]=t;
    }
}