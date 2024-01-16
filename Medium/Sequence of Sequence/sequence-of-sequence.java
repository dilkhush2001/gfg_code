//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
     int numberSequence(int m, int n)
    {
        if(n==0)return 1;
        if(m<=0)return 0;
        return  numberSequence(m/2, n-1)+numberSequence(m-1, n);
    }
    // int helper(int m, int n , int seqi, int next, int len ){
    //     if(len==n)return 1;
    //     if(next>=seqi && next<=m){
    //         return helper(m, n , next, 2*seqi, len+1)+1;
    //     }
    //     return helper(m, n , next, seqi+1, len);
    // }
}