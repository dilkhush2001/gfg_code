//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
       int p0=1, p1=1, p2=1, curr=1;
       
       for(int i=3;i<=n;i++){
           curr=(p2+p1)%((int)1e9+7);
           p2=p1;
           p1=p0;
           p0=curr;
           
       }
       return curr;
       
    }
    
}
