//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String S)
    {
        ArrayList<Integer> ar=new ArrayList<Integer>();
         int n=S.length();
         int m=pat.length();
         
         for(int i=0;i<=n-m;i++){
             int j;
             for( j=0;j<m;j++){
                 if(S.charAt(i+j)!=pat.charAt(j))
                    break;
             }
             if(j==m)
                ar.add(i+1);
         }
        return ar;
    }
}