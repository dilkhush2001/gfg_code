//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> set=new ArrayList<>();
    ArrayList<String> NBitBinary(int N) {
        find(new StringBuilder(), N, 0, 0);
        return set;
    }
    void  find(StringBuilder sb,int  n, int count0, int count1){
        
        if(count0>count1 || sb.length()>n)return ;
        
        if(sb.length()==n && count0<=count1){
            set.add(sb.toString());
            return ;
        }
        // if(count0<count1)
        sb.append('1');
        find(sb, n, count0, count1+1);
        sb.deleteCharAt(sb.length()-1);
        
        sb.append('0');
        find(sb, n, count0+1, count1);
        sb.deleteCharAt(sb.length()-1);
    
        
        
    }
}