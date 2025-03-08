//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution{
    static String longestPalindrome(String S){
        String ans="";
        for(int i=0;i<S.length();i++){
            String oddP=find(S, i, i);
            String evenP=find(S, i, i+1);
            
            oddP=oddP.length()>evenP.length()?oddP: evenP;
            
            if(oddP.length()>ans.length()){
                ans=oddP;
            }
        }
        return ans;
        
    }
    private static String find(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1, j);
    } 
}