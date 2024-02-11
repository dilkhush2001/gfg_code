//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int[]  arr=new int[n];
        for(int i=1;i<n;i++){
            int t=arr[i-1]-i;
            for(int j=0;j<i;j++){
                if(t==arr[j] || t<0){
                    t=arr[i-1]+i;
                    break;
                    
                }
            }
            arr[i]=t;
        }
        for( int el : arr)ans.add(el);
        return ans;
    }
}